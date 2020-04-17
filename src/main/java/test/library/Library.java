package test.library;

import javax.persistence.*;

@Entity
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    // standard constructor, getters, setters
}
