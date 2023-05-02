package be.thomasmore.toydoc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Appointment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private Date date;


    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    @NotNull
    private Date time;


    @OneToOne
    private Toy toy;


    @ManyToOne
    private Client client;


    @ManyToOne
    private Doctor doctor;



    public Appointment() {
    }

    public void createAppointmentNonUser(Date date, int time,String firstname,String lastname,String phone,String email,Doctor doctor) {
        this.date = date;
        this.time = hoursToDate(time);
    }
    public void createAppointmentUser(Date date, int time,Client client,Doctor doctor) {
        this.date = date;
        this.time = hoursToDate(time);
        this.client = client;
        this.doctor = doctor;
    }
//    public void createAppointmentUser(Date date, int time,Client client,Doctor doctor,Toy toy) {
//        this.date = date;
//        this.time = hoursToDate(time);
//        this.client = client;
//        this.doctor = doctor;
//        this.toy = toy;
//    }


    public static Date hoursToDate(int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public int getClientId(){
        return client.getId();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
