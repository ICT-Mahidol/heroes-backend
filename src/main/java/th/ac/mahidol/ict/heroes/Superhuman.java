package th.ac.mahidol.ict.heroes;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
public abstract class Superhuman {
    @Id
    private Integer id;
    private String name;
    private String superpower;
    private String imageURL;


    @ManyToMany(mappedBy = "superhumanFriends", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Human> humanFriends;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Weapon> weapons;

    public Superhuman() {

    }

    public Superhuman(int id, String name, String superpower, String imageURL, List<Human> humanFriends) {
        this.id = id;
        this.name = name;
        this.superpower = superpower;
        this.imageURL = imageURL;
        this.humanFriends = humanFriends;
    }

    public List<Human> getHumanFriends() {
        return humanFriends;
    }

    public void setHumanFriends(List<Human> humanFriends) {
        this.humanFriends = humanFriends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String image) {
        this.imageURL = image;
    }

    @Override
    public String toString() {
        return "Superhuman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", superpower='" + superpower + '\'' +
                ", image='" + imageURL + '\'' +
                '}';
    }
}

