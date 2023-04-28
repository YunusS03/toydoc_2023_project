package be.thomasmore.toydoc.model;


import jakarta.persistence.Entity;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Day {

    private Date date;
    private TimeSlot[] hours; // an array of TimeSlot objects to represent the available time slots for the day
    private String dayOfWeek;

    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");



    public int getDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.date);
        return cal.get(Calendar.DAY_OF_YEAR);
    }




    public Day(Date date) {
        generateTimeSlots();
        this.date = date;
        setDayOfWeek();
    }


    private void generateTimeSlots(){
        this.hours = new TimeSlot[24];

        for (int i = 0; i < 24; i++) {
            this.hours[i] = new TimeSlot(i); // create a new TimeSlot object for each hour and add it to the array
            System.out.println(i);
        }

    }


    public void setDayOfWeek() {
        String[] daysOfWeek = new DateFormatSymbols(Locale.ENGLISH).getWeekdays();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.date);
        int dayOfWeekInt = cal.get(Calendar.DAY_OF_WEEK);
        this.dayOfWeek = daysOfWeek[dayOfWeekInt];
    }



    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Date getDate() {
        return date;
    }

    public TimeSlot[] getHours() {
        return hours;
    }

    public void bookTime(int hour) {
        TimeSlot timeSlot = this.hours[hour];
        if (!timeSlot.isOccupied()) { // if the time slot is available
            timeSlot.book(); // book the time slot
            System.out.println("Booked time slot for hour " + hour);
        } else {
            System.out.println("Time slot for hour " + hour + " is already booked.");
        }
    }


    public void cancelBooking(int hour) {
        TimeSlot timeSlot = this.hours[hour];
        if (timeSlot.isOccupied()) { // if the time slot is booked
            timeSlot.cancelBooking(); // cancel the booking for the time slot
            System.out.println("Cancelled booking for hour " + hour);
        } else {
            System.out.println("Time slot for hour " + hour + " is already available.");
        }
    }



    public void setDate(Date date) {
        this.date = date;
    }
}
