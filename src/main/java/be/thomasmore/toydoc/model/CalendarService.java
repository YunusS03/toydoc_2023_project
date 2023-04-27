package be.thomasmore.toydoc.model;

import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class CalendarService {
    private int numHoursInDay = 24;
    private int numDaysInMonth = 30; // Change this to the number of days in the desired month
    private int numDaysInWeek = 7; // Change this to the number of days in the desired month

    private LocalDate currentDate;


    public CalendarService() {
        currentDate = LocalDate.now();


    }


    public List<Day> getCurrentWeek() {
        List<Day> calendar = new ArrayList<>();
        Calendar calendarInstance = Calendar.getInstance();
        calendarInstance.set(Calendar.HOUR_OF_DAY, 0);
        calendarInstance.set(Calendar.MINUTE, 0);
        calendarInstance.set(Calendar.SECOND, 0);
        calendarInstance.set(Calendar.MILLISECOND, 0);

        LocalDate currentDate = LocalDate.now().plusDays(1);
        LocalDateTime currentDateTime = LocalDateTime.of(currentDate, LocalTime.now());

        int currentHour = currentDateTime.getHour();

        for (int i = 0; i < 7; i++) {

            Date date = calendarInstance.getTime();
            Day day = new Day(numHoursInDay, date);

            Instant instant = day.getDate().toInstant();
            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

            // If the current day is before today, set all hours to occupied
            if (localDate.isBefore(currentDate)) {
                for (TimeSlot hour : day.getHours()) {
                    hour.setOccupied(true);
                }
            }
            // If the current day is today, set all past hours to occupied
            else if (localDate.isEqual(currentDate)) {
                for (TimeSlot hour : day.getHours()) {
                    if (hour.getHour() < currentHour) {
                        hour.setOccupied(true);
                    }
                }
            }

            calendar.add(day);
            calendarInstance.add(Calendar.DAY_OF_MONTH, 1);
        }
        return calendar;
    }



    public List<Day> getNextWeek() {
        currentDate = currentDate.plusWeeks(1);
        return getCurrentWeek();
    }
}

