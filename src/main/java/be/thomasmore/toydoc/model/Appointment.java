package be.thomasmore.toydoc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.SecureRandom;
import java.util.*;

@Entity
public class Appointment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String secretKey;


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
    private AppUser doctor;


    @ManyToOne
    private AppUser client;



    public Appointment() {
    }

    public void createAppointmentNonUser(Date date, int time,String firstname,String lastname,String phone,String email,AppUser doctor) {
        this.date = date;
        this.time = hoursToDate(time);
        this.doctor = doctor;
    }
    public void createAppointmentUser(Date date, int time,AppUser client, AppUser doctor) {
        this.date = date;
        this.time = hoursToDate(time);
        this.client = client;
        this.doctor = doctor;
        this.secretKey = generateSecretKey();
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

    public AppUser getClient() {
        return client;
    }

    public void setClient(AppUser client) {
        this.client = client;
    }

    public AppUser getDoctor() {
        return doctor;
    }

    public void setDoctor(AppUser doctor) {
        this.doctor = doctor;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public static String generateSecretKey() {
        // Generate random bytes
        byte[] keyBytes = new byte[16];
        new SecureRandom().nextBytes(keyBytes);

        // Encode the bytes as a Base64 string
        String secretKey = Base64.getUrlEncoder().withoutPadding().encodeToString(keyBytes);

        return secretKey;
    }















}
