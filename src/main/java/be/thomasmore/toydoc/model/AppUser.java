package be.thomasmore.toydoc.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
//@MappedSuperclass
public class AppUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String speciality;
    private Role role;

    @Column(length=50000)
    private String profileImage;
    @OneToMany(mappedBy = "doctor")
    private Collection<Appointment> appointments;
    @OneToMany(mappedBy = "client")
    private Collection<Toy> toys;

    // Constructors
    public AppUser() {

    }

    public AppUser(String username, String password, String firstName, String lastName, Role role) {
    }

    public AppUser(String firstName, String lastName, Role role) {
    }
    public AppUser(String firstName,String lastName,String email,String phone){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        role=Role.CLIENT;
    }

    public AppUser(String email, String username, String password, String firstName, String lastName, Integer age, String phone, String address, String city, String postalCode, String country, String speciality, Role role) {
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setPhone(phone);
        setAddress(address);
        setCity(city);
        setPostalCode(postalCode);
        setCountry(country);
        setSpeciality(speciality);
        setRole(role);
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
