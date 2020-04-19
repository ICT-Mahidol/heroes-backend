package th.ac.mahidol.ict.heroes.model;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn
    private Superhuman owner;

    public Weapon() {

    }

    public Weapon(String name, String description, Superhuman owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
