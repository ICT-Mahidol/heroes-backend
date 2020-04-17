package test.library;

import lombok.*;
import javax.persistence.*;

@Data

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Book() {

    }

    @ManyToOne
    @JoinColumn
    private BookCategory bookCategory;

    public Book(String name) {
        this.name = name;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}