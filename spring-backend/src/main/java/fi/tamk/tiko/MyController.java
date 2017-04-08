package fi.tamk.tiko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

// This class acts as a controller.
// Usually when using @Controller, you will use also @RequestMapping
@RestController
public class MyController {
    @Autowired
    ShoppingItemRepository database;
    
	public MyController() {
    }
	
	// curl -H "Content-type: application/json" -X POST -d '{some json here...}' http://localhost:8080/items
    @RequestMapping(value = "/items",  method=RequestMethod.POST)
    public void saveLocation(@RequestBody ShoppingItem c) {
        database.save(c);
    }
	
	@RequestMapping(value = "/items",  method=RequestMethod.GET)
    public Iterable<ShoppingItem> fetchLocation() {
        return database.findAll();
    }
	
	@RequestMapping(value = "/items/{itemId}",  method=RequestMethod.GET)
    public ShoppingItem fetchLocation(@PathVariable long itemId) {
        for(ShoppingItem c : database.findAll()) {
            if(c.getId() == itemId) {
                return c;
            }
        }
        return null;
    }
	// When HTTP GET, POST, PUT or OTHER request happens
    // to http://localhost:8080/helloworld
    // invoke this method
    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello World";
    }
}
