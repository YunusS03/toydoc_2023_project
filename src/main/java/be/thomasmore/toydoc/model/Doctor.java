package be.thomasmore.toydoc.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String speciality;
    private String email;
    @OneToMany(mappedBy = "doctor")
    private Collection<Appointment> appointments;
    @ManyToMany(mappedBy = "doctors")
    private Collection<Toy> toys;
    @OneToMany(mappedBy = "doctor")
    private Collection<Client> clients;




}
