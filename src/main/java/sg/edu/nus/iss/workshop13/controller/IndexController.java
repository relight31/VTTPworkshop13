package sg.edu.nus.iss.workshop13.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.workshop13.model.Person;

@Controller
@RequestMapping(path="/demo", produces = MediaType.TEXT_HTML_VALUE) //annotations have no semicolon
public class IndexController {
    @GetMapping("/currtime")
    public String getCurrDateTime(Model model){
        model.addAttribute("currTime", new Date().toString());
        return "currtime";
    }

    @GetMapping("/person")
    public String getPerson(Model model){
        Person person = new Person();
        person.setId(1);
        person.setGender('M');
        person.setFirstName("Russell");
        person.setLastName("Lim");
        model.addAttribute("person", person);
        model.addAttribute("currTime", new Date().toString());
        return "currtime";
    }

    @GetMapping("/allperson")
    public String getAllPersons(Model model){
        List<Person> allpersons = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setId(1);
        person1.setGender('M');
        person1.setFirstName("Russell");
        person1.setLastName("Lim");
        allpersons.add(person1);

        Person person2 = new Person();
        person2.setId(2);
        person2.setGender('F');
        person2.setFirstName("Abigail");
        person2.setLastName("Chieng");
        allpersons.add(person2);
        model.addAttribute("allPersons", allpersons);
        return "currtime";
    }

    @GetMapping("/searchperson") 
    //search using query string
    //http://localhost:8080/demo/searchperson?firstName=Russell
    public String searchPersons(@RequestParam(required = true) String firstName, Model model){
        List<Person> allpersons = new ArrayList<Person>();
        Person resultPerson = null;
        Person person1 = new Person();
        person1.setId(1);
        person1.setGender('M');
        person1.setFirstName("Russell");
        person1.setLastName("Lim");
        allpersons.add(person1);

        Person person2 = new Person();
        person2.setId(2);
        person2.setGender('F');
        person2.setFirstName("Abigail");
        person2.setLastName("Chieng");
        allpersons.add(person2);

        if(firstName.equals("Russell")){
            resultPerson = person1;
        }
        if(firstName.equals("Abigail")){
            resultPerson = person2;
        }
        model.addAttribute("allPersons", allpersons);
        model.addAttribute("resultPerson", resultPerson);
        return "currtime";
    }

    @GetMapping("/getPerson/{firstName}") 
    //search using path variable
    //http://localhost:8080/demo/getPerson/Russell
    public String getPerson(@PathVariable(name="firstName") String firstName, Model model){
        Person resultPerson = null;
        Person person1 = new Person();
        person1.setId(1);
        person1.setGender('M');
        person1.setFirstName("Russell");
        person1.setLastName("Lim");

        Person person2 = new Person();
        person2.setId(2);
        person2.setGender('F');
        person2.setFirstName("Abigail");
        person2.setLastName("Chieng");

        if(firstName.equals("Russell")){
            resultPerson = person1;
        }
        if(firstName.equals("Abigail")){
            resultPerson = person2;
        }
        model.addAttribute("resultPerson", resultPerson);
        return "currtime";
    }
}
