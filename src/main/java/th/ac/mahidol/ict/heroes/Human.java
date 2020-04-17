package th.ac.mahidol.ict.heroes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
public class Human {
    @Id
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "SUPERHUMAN_HUMAN",
            joinColumns = {@JoinColumn(name = "superhero_id")},
            inverseJoinColumns = {@JoinColumn(name = "human_id")}
    )
    @JsonIgnore
    private List<Superhuman> superhumanFriends;

    public Human() {

    }

    public Human(int id, String name) {
        this.id = id;
        this.name = name;
        this.superhumanFriends = new ArrayList<>();
    }

    public void addFriend(Superhuman friend) {
        this.superhumanFriends.add(friend);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Superhuman> getSuperhumanFriends() {
        return superhumanFriends;
    }

    public void setSuperhumanFriends(ArrayList<Superhuman> superhumanFriends) {
        this.superhumanFriends = superhumanFriends;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}

