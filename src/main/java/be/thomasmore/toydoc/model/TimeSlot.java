package be.thomasmore.toydoc.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



public class TimeSlot {
    private int hour; // the hour of the time slot
    private boolean isOccupied; // whether the time slot is occupied or not

    public TimeSlot(int hour) {
        this.hour = hour;
        this.isOccupied = false; // the time slot is initially available
    }
    public void book() {
        this.isOccupied = true; // book the time slot
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void cancelBooking() {
        this.isOccupied = false; // cancel the booking for the time slot
    }

    public boolean isOccupied() {
        return this.isOccupied; // return whether the time slot is occupied or not
    }

    public int getHour() {
        return this.hour; // return the hour of the time slot
    }
}
