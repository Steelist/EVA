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

        database.save(new TV("Samsung UE65KU6405 65\" Ultra HD Smart LED",1199.90,"3840 × 2160 Ultra HD",0," 1458,1 x 841,4 x 54,9 mm","LED","16:9","Liitännät: 3 x HDMI, 2 x USB, komponentti-/komposiitti, digitaalinen audio ulos (optinen), Ethernet (LAN)\n" +
"Anynet+ (HDMI-CEC)\n" +
"HDMI 2.0a",26.8,"https://cdn-c.verkkokauppa.com/1920/images/40/2_391265-3840x2480.jpg"));
        database.save(new TV("Sony KD100ZD9 100\" Smart Android 4K Ultra HD LED",74999.90,"3840 × 2160 Ultra HD", 1200,"225,8 x 130,3 x 9,8 cm","LED","16:9","Liitännät: 4 x HDMI, 3 x USB, SCART, Ethernet, komposiittivideotulo, analoginen äänitulo, digitaalinen äänilähtö, kuulokeliitäntä\n" +
"HDCP 2.2\n" +
"BRAVIA Sync (HDMI-CEC)\n" +
"HDMI ARC (Audio Return Channel)\n" 
,145,"https://cdn-b.verkkokauppa.com/images/43/2_364055-1024x768.jpeg"));
        database.save(new Screen(24, "570 x 222 x 431 mm", "BenQ Zowie XL2411 24\" LED", 299.90, "1920 x 1080",144,1,  170, "LED", "16:9", "D-SUB (VGA), DVI-DL, 1 x HDMI, 3.5 mm audio in/out",  6.1, "https://cdn-b.verkkokauppa.com/images/41/2_344675-699x650.jpg"));
        database.save(new Screen(24, " 56,5 x 40,1 x 17,9 cm", "Acer GN246HL 24\" 144 Hz", 279.90, "1920 x 1080",144,1,  176, "TN", "16:9", "Liitäntöinä VGA, DVI sekä HDMI",  3.52, "https://cdn-b.verkkokauppa.com/images/94/2_176306-825x591.jpg"));
        database.save(new Computer("Asus ROG G20BM ‐tietokone", 799.00, "AMD FX 770K Quad-Core 3,5 GHz", "AMD Radeon R9 380 2 Gt", null, "8 Gt DDR3 SO-DIMM","1 Tt SATAIII 7200 RPM, jossa 8 Gt:n SSD-cache", "null",0, "Windows", "https://cdn-a.verkkokauppa.com/1920/images/97/2_328712-2864x4000.jpg", 1));
       database.save(new Computer("cer Predator G3-710", 1249.90, "Intel Core i5-6400 Quad-Core 2.7 GHz", "NVIDIA GeForce GTX 1060 6 Gt", "500 W", "8 Gt (1 x 8 Gt) DDR4 2133 MHz","256 Gt M.2 SATA SSD -levy + 1 Tt 7200 RPM SATA", null,0, "Windows", "https://cdn-c.verkkokauppa.com/images/54/2_344297-800x1071.jpeg", 1));
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
