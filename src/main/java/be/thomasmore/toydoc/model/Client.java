package be.thomasmore.toydoc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    private Collection<Toy> toys;
}
