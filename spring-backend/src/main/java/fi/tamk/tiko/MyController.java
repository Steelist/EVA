package fi.tamk.tiko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


// This class acts as a controller.
// Usually when using @Controller, you will use also @RequestMapping
@RestController
public class MyController {
    @Autowired
    ShoppingItemRepository database;


    public MyController() {

    }

    public void fillWithTestdata(){
        database.save(new TV("asd",200,"asd",2,"asd","asd","asd","asd",20,"asd"));
        database.save(new TV("asd",200,"asd",2,"asd","asd","asd","asd",20,"asd"));
        database.save(new TV("asd",200,"asd",2,"asd","asd","asd","asd",20,"asd"));
        database.save(new TV("asd",200,"asd",2,"asd","asd","asd","asd",20,"asd"));
        database.save(new TV("asd",200,"asd",2,"asd","asd","asd","asd",20,"asd"));
        System.out.println("Url path GET \"localhost:8080/items\" shows all items currently in database");
        System.out.println("Url path GET \"localhost:8080/items/{itemId}\" shows specific item with matching id in database");
        System.out.println("Url path GET \"localhost:8080/index.html\" shows homepage where all items are shown");
        System.out.println("Url path GET \"localhost:8080/addComputer.html\" shows form that with a new computer can be added");
        System.out.println("Url path GET \"localhost:8080/addTV.html\" shows form that with a new TV can be added");
        System.out.println("Url path GET \"localhost:8080/addScreen.html\" shows form that with a new screen can be added");
        System.out.println("Url path POST \"localhost:8080/computer\" adds new computer with given json data");
        System.out.println("Url path POST \"localhost:8080/tv\" adds new TV with given json data");
        System.out.println("Url path POST \"localhost:8080/screen\" adds new screen with given json data");
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model) {
        return "/index.html";
    }


	// curl -H "Content-type: application/json" -X POST -d '{some json here...}' http://localhost:8080/items
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/items",  method=RequestMethod.POST)
    public void saveItem(@RequestBody ShoppingItem c) {
        database.save(c);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/computer",  method=RequestMethod.POST, headers = {"content-type=application/json"})
    public void saveComputer(@RequestBody Computer c) {
        database.save(c);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/tv",  method=RequestMethod.POST, headers = {"content-type=application/json"})
    public void saveTV(@RequestBody TV c) {
        database.save(c);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/screen",  method=RequestMethod.POST, headers = {"content-type=application/json"})
    public void saveScreen(@RequestBody Screen c) {
        database.save(c);
    }

    @CrossOrigin(origins = "*")
	@RequestMapping(value = "/items",  method=RequestMethod.GET)
    public Iterable<ShoppingItem> fetchLocation() {

        return database.findAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/items/{itemId}",  method=RequestMethod.GET)
    public ShoppingItem fetchItem(@PathVariable long itemId) {

        return database.findOne(itemId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/item/{itemId}",  method=RequestMethod.GET)
    public void updateItem(@PathVariable long itemId) {
        
        database.updateTitle(itemId, 400.00);
       
    }

	// When HTTP GET, POST, PUT or OTHER request happens
    // to http://localhost:8080/helloworld
    // invoke this method
    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello World";
    }
}
