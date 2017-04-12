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
	// When HTTP GET, POST, PUT or OTHER request happens
    // to http://localhost:8080/helloworld
    // invoke this method
    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello World";
    }
}
