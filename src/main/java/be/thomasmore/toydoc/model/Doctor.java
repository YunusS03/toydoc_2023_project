package be.thomasmore.toydoc.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String speciality;
    private String email;

    @OneToMany(mappedBy = "doctor")
    private Collection<Appointment> appointments;
    @ManyToMany
    private Collection<Toy> toys;
    @OneToMany(mappedBy = "doctor")
    private Collection<Client> clients;

    public Doctor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Collection<Toy> getToys() {
        return toys;
    }

    public void setToys(Collection<Toy> toys) {
        this.toys = toys;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }
}
