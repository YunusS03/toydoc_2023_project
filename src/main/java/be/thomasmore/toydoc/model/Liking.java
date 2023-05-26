package be.thomasmore.toydoc.model;

import jakarta.persistence.*;

@Entity
public class Liking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    public Liking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
