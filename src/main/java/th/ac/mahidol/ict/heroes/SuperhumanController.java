package th.ac.mahidol.ict.heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.heroes.model.*;
import th.ac.mahidol.ict.heroes.repositories.SuperhumanRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class SuperhumanController {
    @Autowired
    private SuperhumanRepository superhumanRepository;

    @CrossOrigin
    @GetMapping("/")
    public @ResponseBody
    String welcome () {
        // show the welcome page at the root
        return "Hello, welcome to the Heroes application";
    }

    // no longer used
    @CrossOrigin
    @GetMapping("/addGet")
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

    @CrossOrigin
    @PostMapping("/heroes")
    public @ResponseBody
    String addHero(@RequestBody Map<String,Object> body) {
        System.out.println(body);
        if (body.get("type").toString().equals("hero")) {
            Hero h = createNewHeroWithId(Integer.parseInt(body.get("id").toString()), body);
            superhumanRepository.save(h);
            return "Saved: " + h;
        } else if (body.get("type").toString().equals("villain")) {
            Villain v = createNewVillainWithId(Integer.parseInt(body.get("id").toString()), body);
            superhumanRepository.save(v);
            return "Saved: " + v;
        }
        return "Error: wrong superhuman type";
    }

    @CrossOrigin
    @GetMapping("/heroes")
    public @ResponseBody
    Iterable<Superhuman> getAllHeroes() {
        // This returns list of JSON objects of all the heroes
        return superhumanRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/heroes/{id}")
    public @ResponseBody
    Optional<Superhuman> getHeroById(@PathVariable("id") int id) {
        // This returns a JSON object of the selected hero
        return superhumanRepository.findById(id);
    }

    @CrossOrigin
    @PutMapping("/heroes/{id}")
    public @ResponseBody
    String updateHeroById(@PathVariable("id") int id, @RequestBody Map<String,Object> body) {
        // delete the existing superhuman first (this is to avoid duplication in the weapons).
        // TODO: need to fix this issue of duplicated weapons when save() directly
        superhumanRepository.deleteById(id);
        // put the new updated one in
        if (body.get("type").toString().equals("hero")) {
            Hero h = createNewHeroWithId(id, body);
            superhumanRepository.save(h);
            return "Saved: " + h;
        } else if (body.get("type").toString().equals("villain")) {
            Villain v = createNewVillainWithId(id, body);
            superhumanRepository.save(v);
            return "Saved: " + v;
        }
        return "Error: wrong superhuman type";
    }

    @CrossOrigin
    @DeleteMapping("/heroes")
    public @ResponseBody
    String removeAllHeroes() {
        // delete all the heroes
        superhumanRepository.deleteAll();
        return "All data has been removed.";
    }

    @CrossOrigin
    @DeleteMapping("/heroes/{id}")
    public @ResponseBody
    String removeHeroById(@PathVariable("id") int id) {
        // delete a specific hero
        superhumanRepository.deleteById(id);
        return "The hero ID = " + id + " has been removed";
    }

    private Hero createNewHeroWithId(int id, Map<String,Object> body) {
        // create a new hero with the given info
        Hero h = new Hero();
        h.setId(id);
        h.setName(body.get("name").toString());
        h.setRealname(body.get("realname").toString());
        h.setSuperpower(body.get("superpower").toString());
        h.setImageURL(body.get("imageURL").toString());
        if (body.get("weapons") != null) {
            h.setWeapons(createWeaponList((ArrayList<Map<String,Object>>) body.get("weapons"), h));
        }
        if (body.get("humanFriends") != null) {
            h.setHumanFriends(createFriendList((ArrayList<Map<String,Object>>) body.get("humanFriends"), h));
        }
        return h;
    }

    private Villain createNewVillainWithId(int id, Map<String,Object> body) {
        // create a new villain with the given info
        Villain v = new Villain();
        v.setId(id);
        v.setName(body.get("name").toString());
        v.setOrigin(body.get("origin").toString());
        v.setSuperpower(body.get("superpower").toString());
        v.setImageURL(body.get("imageURL").toString());
        if (body.get("weapons") != null) {
            v.setWeapons(createWeaponList((ArrayList<Map<String, Object>>) body.get("weapons"), v));
        }
        if (body.get("humanFriends") != null) {
            v.setHumanFriends(createFriendList((ArrayList<Map<String, Object>>) body.get("humanFriends"), v));
        }
        return v;
    }

    private List<Weapon> createWeaponList(ArrayList<Map<String,Object>> weapons, Superhuman h) {
        List<Weapon> weaponList = new ArrayList<>();
        for (Map<String,Object> o: weapons) {
            System.out.println(o);
            Weapon w = new Weapon(o.get("name").toString(), o.get("description").toString(), h);
            weaponList.add(w);
        }
        return weaponList;
    }

    private List<Human> createFriendList(ArrayList<Map<String,Object>> friends, Superhuman h) {
        List<Human> friendList = new ArrayList<>();
        for (Map<String,Object> o: friends) {
            System.out.println(o);
            Human friend = new Human(Integer.parseInt(o.get("id").toString()), o.get("name").toString());
            friend.addFriend(h);
            friendList.add(friend);
        }
        return friendList;
    }
}
