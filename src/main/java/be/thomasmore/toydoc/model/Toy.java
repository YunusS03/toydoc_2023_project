package be.thomasmore.toydoc.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;

@Entity
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    @ManyToMany(mappedBy = "toys")
    private Collection<Doctor> doctors;
}
