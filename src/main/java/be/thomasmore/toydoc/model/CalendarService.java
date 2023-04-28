package be.thomasmore.toydoc.model;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class CalendarService {

    private LocalDate dateOfArray;
    List<Day> calendar = new ArrayList<>();


    public CalendarService() {
        dateOfArray = LocalDate.now();
    }

    public void setOccupiedOnCalender(Date date, int hour){

        Calendar kalender = Calendar.getInstance();
        kalender.setTime(date);
        int date2 = kalender.get(Calendar.DAY_OF_YEAR);

        for (Day days: calendar) {
            System.out.println("doy " + days.getDayOfYear());
            System.out.println("date " + date2);

            if (days.getDayOfYear() == date2){
                System.out.println("EQUAL OK");
                for (TimeSlot time: days.getHours()) {
                    if (time.getHour() == hour) {
                        time.setOccupied(true);
                    }
                    }
                }
            }
        }




    public List<Day> getCurrentWeek() {


        LocalTime currentTime = LocalTime.now();
        int currentHour = currentTime.getHour();

        for (int i = 0; i < 7; i++) {

            LocalDate date0 = dateOfArray;

            ZonedDateTime zonedDateTime = date0.atStartOfDay(ZoneId.systemDefault());
            Date date = Date.from(zonedDateTime.toInstant());

            Day day = new Day(date);

            // If the current day is before today, set all hours to occupied
            if (dateOfArray.isBefore(LocalDate.now())) {
                for (TimeSlot hour : day.getHours()) {
                    hour.setOccupied(true);
                }
            }
            // If the current day is today, set all past hours to occupied
            else if (dateOfArray.isEqual(LocalDate.now())) {
                for (TimeSlot hour : day.getHours()) {
                    if (hour.getHour() < currentHour) {
                        hour.setOccupied(true);
                    }
                }
            }


            calendar.add(day);
           dateOfArray = dateOfArray.plusDays(1);
        }
        return calendar;
    }




    public List<Day> getNextWeek(int plusweek) {
        dateOfArray = dateOfArray.plusWeeks(plusweek);
        System.out.println(""+ dateOfArray);
        System.out.println(plusweek);
        return getCurrentWeek();
    }

    public List<Day> getPreviousWeek(int plusweek) {
        dateOfArray = dateOfArray.plusWeeks(plusweek);
        System.out.println(""+ dateOfArray);
        return getCurrentWeek();
    }










}

