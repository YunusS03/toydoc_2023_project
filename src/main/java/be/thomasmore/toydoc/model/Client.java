package be.thomasmore.toydoc.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    @OneToOne
    private AppUser appUser;
    @ManyToMany
    private Collection<Doctor> doctors;
    @OneToMany(mappedBy = "client")
    private Collection<Appointment> appointments;
    @OneToMany(mappedBy = "client")
    private Collection<Toy> toys;
    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Collection<Doctor> doctors) {
        this.doctors = doctors;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
