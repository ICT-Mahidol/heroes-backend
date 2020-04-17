package th.ac.mahidol.ict.heroes;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Hero extends Superhuman {
    private String realname;

    public Hero() {

    }

    public Hero(int id, String name, String superpower, String realname, String imageURL, List<Human> humanFriends) {
        super(id, name, superpower, imageURL, humanFriends);
        this.realname = realname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "Hero{" + super.toString() +
                ", realname='" + realname + '\'' +
                '}';
    }
}

