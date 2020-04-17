package test.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import th.ac.mahidol.ict.heroes.Hero;
import th.ac.mahidol.ict.heroes.Villain;

@Controller
public class LibraryController {
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private AddressRepository addressRepository;
}
