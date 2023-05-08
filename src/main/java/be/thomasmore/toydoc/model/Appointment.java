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
    private Boolean confirmed;


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

    public void createAppointmentNonUser(Date date, int time, String firstname, String lastname, String phone, String email, AppUser doctor) {
        this.date = date;
        this.time = hoursToDate(time);
        this.doctor = doctor;
        this.confirmed = false;
    }

    public void createAppointmentUser(Date date, int time, AppUser client, AppUser doctor) {
        this.date = date;
        this.time = hoursToDate(time);
        this.client = client;
        this.doctor = doctor;
        generateSecretKey(client.getId().toString());
        this.confirmed = false;
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


    public int getClientId() {
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



    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }


    private void generateSecretKey(String userId) {

        // Genereer een array van 16 bytes voor de secretkey
        byte[] keyBytes = new byte[16];
        new SecureRandom().nextBytes(keyBytes);

        // Combineer de secretkey met de bytes van de gebruikers-ID
        byte[] combinedBytes = new byte[keyBytes.length + userId.getBytes().length];
        System.arraycopy(userId.getBytes(), 0, combinedBytes, 0, userId.getBytes().length);
        System.arraycopy(keyBytes, 0, combinedBytes, userId.getBytes().length, keyBytes.length);

        // Encodeer de gecombineerde bytes naar een secretkey in Base64-formaat
        String secretKey = Base64.getUrlEncoder().withoutPadding().encodeToString(combinedBytes);

        // Wijs de secretkey toe aan het huidige object
        this.secretKey = secretKey;
    }


}
