package th.ac.mahidol.ict.heroes;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class SuperhumanController {
    @Autowired
    private SuperhumanRepository superhumanRepository;
    @Autowired
    private WeaponRepository weaponRepository;

    @GetMapping("/addGet") // Map ONLY GET Requests
    public @ResponseBody
    String addNewHero (
            @RequestParam int id
            , @RequestParam String name
            , @RequestParam(required=false) String realname
            , @RequestParam(required=false) String origin
            , @RequestParam String imageURL
            , @RequestParam String superpower
            , @RequestParam String type
            , @RequestParam(required=false) String weapons
            , @RequestParam(required=false) String friends){
        if (type.equals("hero")) {
            Hero h = new Hero();
            h.setId(id);
            h.setName(name);
            h.setRealname(realname);
            h.setSuperpower(superpower);
            h.setImageURL(imageURL);
            if (weapons != null) {
                String[] weaponArray = weapons.split(";");
                List<Weapon> weaponList = new ArrayList<>();
                for (String w : weaponArray) {
                    String[] warray = w.split(",");
                    weaponList.add(new Weapon(warray[0], warray[1], h));
                }
                h.setWeapons(weaponList);
            }
            if (friends != null) {
                String[] friendArray = friends.split(";");
                List<Human> friendList = new ArrayList<>();
                for (String f: friendArray) {
                    String[] farray = f.split(",");
                    Human friend = new Human(Integer.valueOf(farray[0]), farray[1]);
                    friend.addFriend(h);
                    friendList.add(friend);
                }
                h.setHumanFriends(friendList);
            }
            superhumanRepository.save(h);
            return "Saved: " + h;
        } else if (type.equals("villain")) {
            Villain v = new Villain();
            v.setId(id);
            v.setName(name);
            v.setOrigin(origin);
            v.setSuperpower(superpower);
            v.setImageURL(imageURL);
            if (weapons != null) {
                String[] weaponArray = weapons.split(";");
                List<Weapon> weaponList = new ArrayList<>();
                for (String w : weaponArray) {
                    String[] warray = w.split(",");
                    weaponList.add(new Weapon(warray[0], warray[1], v));
                }
                v.setWeapons(weaponList);
            }
            superhumanRepository.save(v);
            return "Saved: " + v;
        }
        return "Error: wrong superhuman type";
    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewHeroPost(@RequestBody Map<String,Object> body) {
        System.out.println(body);
        if (body.get("type").toString().equals("hero")) {
            Hero h = new Hero();
            h.setId(Integer.valueOf(body.get("id").toString()));
            h.setName(body.get("name").toString());
            h.setRealname(body.get("realname").toString());
            h.setSuperpower(body.get("superpower").toString());
            h.setImageURL(body.get("imageURL").toString());
            if (body.get("weapons") != null) {
                String[] weaponArray = body.get("weapons").toString().split(";");
                List<Weapon> weaponList = new ArrayList<>();
                for (String w : weaponArray) {
                    String[] warray = w.split(",");
                    weaponList.add(new Weapon(warray[0], warray[1], h));
                }
                h.setWeapons(weaponList);
            }
            if (body.get("humanFriends") != null) {
                String[] friendArray = body.get("humanFriends").toString().split(";");
                List<Human> friendList = new ArrayList<>();
                for (String f: friendArray) {
                    String[] farray = f.split(",");
                    Human friend = new Human(Integer.valueOf(farray[0]), farray[1]);
                    friend.addFriend(h);
                    friendList.add(friend);
                }
                h.setHumanFriends(friendList);
            }
            superhumanRepository.save(h);
            return "Saved: " + h;
        } else if (body.get("type").toString().equals("villain")) {
            Villain v = new Villain();
            v.setId(Integer.parseInt(body.get("id").toString()));
            v.setName(body.get("name").toString());
            v.setOrigin(body.get("origin").toString());
            v.setSuperpower(body.get("superpower").toString());
            v.setImageURL(body.get("imageurl").toString());
            if (body.get("weapons") != null) {
                String[] weaponArray = body.get("weapons").toString().split(";");
                List<Weapon> weaponList = new ArrayList<>();
                for (String w : weaponArray) {
                    String[] warray = w.split(",");
                    weaponList.add(new Weapon(warray[0], warray[1], v));
                }
                v.setWeapons(weaponList);
            }
            superhumanRepository.save(v);
            return "Saved: " + v;
        }
        return "Error: wrong superhuman type";
    }

    @PutMapping("/updateById/{id}")
    public @ResponseBody
    String addNewHeroPost(@PathVariable("id") int id, @RequestBody Map<String,Object> body) {
        if (body.get("type").toString().equals("hero")) {
            Hero h = new Hero();
            h.setId(id);
            h.setName(body.get("name").toString());
            h.setRealname(body.get("realname").toString());
            h.setSuperpower(body.get("superpower").toString());
            h.setImageURL(body.get("imageURL").toString());
            if (body.get("weapons") != null) {
                String[] weaponArray = body.get("weapons").toString().split(";");
                List<Weapon> weaponList = new ArrayList<>();
                for (String w : weaponArray) {
                    String[] warray = w.split(",");
                    weaponList.add(new Weapon(warray[0], warray[1], h));
                }
                h.setWeapons(weaponList);
            }
            if (body.get("friends") != null) {
                String[] friendArray = body.get("friends").toString().split(";");
                List<Human> friendList = new ArrayList<>();
                for (String f: friendArray) {
                    String[] farray = f.split(",");
                    Human friend = new Human(Integer.valueOf(farray[0]), farray[1]);
                    friend.addFriend(h);
                    friendList.add(friend);
                }
                h.setHumanFriends(friendList);
            }
            superhumanRepository.save(h);
            return "Saved: " + h;
        } else if (body.get("type").toString().equals("villain")) {
            Villain v = new Villain();
            v.setId(id);
            v.setName(body.get("name").toString());
            v.setOrigin(body.get("origin").toString());
            v.setSuperpower(body.get("superpower").toString());
            v.setImageURL(body.get("imageurl").toString());
            if (body.get("weapons") != null) {
                String[] weaponArray = body.get("weapons").toString().split(";");
                List<Weapon> weaponList = new ArrayList<>();
                for (String w : weaponArray) {
                    String[] warray = w.split(",");
                    weaponList.add(new Weapon(warray[0], warray[1], v));
                }
                v.setWeapons(weaponList);
            }
            superhumanRepository.save(v);
            return "Saved: " + v;
        }
        return "Error: wrong superhuman type";
    }

    @DeleteMapping("/clean")
    public @ResponseBody
    String removeAllHeroes() {
        superhumanRepository.deleteAll();
        return "All data has been removed.";
    }

    @DeleteMapping("/deleteById/{id}")
    public @ResponseBody
    String removeHeroById(@PathVariable("id") int id) {
        superhumanRepository.deleteById(id);
        return "The hero ID = " + id + " has been removed";
    }

    @GetMapping("/heroes")
    public @ResponseBody
    Iterable<Superhuman> getAllHeroes() {
        // This returns a JSON or XML with the users
        return superhumanRepository.findAll();
    }

    @GetMapping("/heroById/{id}")
    public @ResponseBody
    Optional<Superhuman> getHeroById(@PathVariable("id") int id) {
        // This returns a JSON or XML with the users
        return superhumanRepository.findById(id);
    }

//    @GetMapping("/weaponByHeroId/{id}")
//    public @ResponseBody
//    Iterable<Weapon> getWeaponByHeroId(@PathVariable("id") int id) {
//        return weaponRepository.fi
//    }
}
