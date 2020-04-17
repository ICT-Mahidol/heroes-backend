//package th.ac.mahidol.ict.heroes;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@SpringBootApplication
//public class CommandLineApplication implements CommandLineRunner {
//    @Autowired
//    private SuperhumanRepository superhumanRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(th.ac.mahidol.ict.heroes.CommandLineApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) {
//        ArrayList<Human> friends = new ArrayList<>();
//        Human ned = new Human(1,"Ned");
//        friends.add(ned);
//        Hero spidey = new Hero(1,"Spider-Man", "spider sense", "Peter Parker",  friends);
//        ArrayList<Weapon> sweapons = new ArrayList<>();
//        sweapons.add(new Weapon("spider web", "Lots of web", spidey));
//        sweapons.add(new Weapon("mechanical arms", "Lots of arm", spidey));
//        spidey.setWeapons(sweapons);
//        ned.addFriend(spidey);
//        superhumanRepository.save(spidey);
//        System.out.println("Saved");
//
//        Villain thanos = new Villain(2, "Thanos", "strength", "Titan", null);
//        ArrayList<Weapon> tweapons = new ArrayList<>();
//        tweapons.add(new Weapon("gaunlet", "Large gaunlet", thanos));
//        tweapons.add(new Weapon("infinity stones", "5 powerful gems", thanos));
//        tweapons.add(new Weapon("double-edged sword", "Sharp blade", thanos));
//        thanos.setWeapons(tweapons);
//        superhumanRepository.save(thanos);
//
//        Optional<Superhuman> optionalSuperhuman = superhumanRepository.findById(1);
//        Hero sh = (Hero) optionalSuperhuman.get();
//        System.out.println(sh.getName() + "\n" + sh.getRealname() + "\n" +
//                sh.getSuperpower());
//    }
//}