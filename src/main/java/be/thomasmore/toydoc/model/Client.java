//package be.thomasmore.toydoc.model;
//
//import jakarta.persistence.*;
//
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//
//public class Client extends AppUser {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    private Integer id;
//    @OneToOne
//    private AppUser appUser;
//
//
//
//    public Client() {
//    }
//
//    public Client(Integer Id) {
//        this.setId(Id);
//    }
//
//    public Client(String firstName, String lastName, Role role) {
//        super(firstName, lastName, role);
//    }
//
//
//    public Collection<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(Collection<Appointment> appointments) {
//        this.appointments = appointments;
//    }
//
//    public Collection<Toy> getToys() {
//        return toys;
//    }
//
//    public void setToys(Collection<Toy> toys) {
//        this.toys = toys;
//    }
//
//    //    public AppUser getAppUser() {
////        return appUser;
////    }
////
////    public void setAppUser(AppUser appUser) {
////        this.appUser = appUser;
////    }
//
////    public Integer getId() {
////        return id;
////    }
////
////    public void setId(Integer id) {
////        this.id = id;
////    }
//
////    public Collection<Doctor> getDoctors() {
////        return doctors;
////    }
////
////    public void setDoctors(Collection<Doctor> doctors) {
////        this.doctors = doctors;
////    }
//
//
//
//
////    public Integer getAge() {
////        return age;
////    }
////
////    public void setAge(Integer age) {
////        this.age = age;
////    }
////
////    public String getEmail() {
////        return email;
////    }
////
////    public void setEmail(String email) {
////        this.email = email;
////    }
////
////    public String getPhone() {
////        return phone;
////    }
////
////    public void setPhone(String phone) {
////        this.phone = phone;
////    }
////
////    public String getAddress() {
////        return address;
////    }
////
////    public void setAddress(String address) {
////        this.address = address;
////    }
////
////    public String getCity() {
////        return city;
////    }
////
////    public void setCity(String city) {
////        this.city = city;
////    }
////
////    public String getPostalCode() {
////        return postalCode;
////    }
////
////    public void setPostalCode(String postalCode) {
////        this.postalCode = postalCode;
////    }
////
////    public String getCountry() {
////        return country;
////    }
////
////    public void setCountry(String country) {
////        this.country = country;
////    }
//
//
//}
