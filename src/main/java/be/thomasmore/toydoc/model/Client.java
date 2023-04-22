package be.thomasmore.toydoc.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    @ManyToMany(mappedBy = "clients")
    private Collection<Toy> toys;
    @OneToMany(mappedBy = "client")
    private Collection<Appointment> appointments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;
}
