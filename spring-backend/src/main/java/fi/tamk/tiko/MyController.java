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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Controls the back end. Manages the databases.
 *
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
 */
@RestController
public class MyController {

    @Autowired
    ShoppingItemRepository database;
    List<ShoppingItem> shoppingCart;

    /**
     * Constructor for the MyController.
     *
     */
    public MyController() {

    }

    /**
     * Gets the URL for the home page.
     *
     * @param model
     * @return the URL for the home page.
     */
    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        return "index2.html";
    }

    /**
     *
     *
     * @param c
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public void saveItem(@RequestBody ShoppingItem c) {
        database.save(c);
    }

    /**
     * Saves a new computer to the database.
     *
     * @param c computer object as JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/computer", method = RequestMethod.POST, headers
            = {"content-type=application/json"})
    public void saveComputer(@RequestBody Computer c) {
        database.save(c);
    }

    /**
     * Saves a new mouse to the database.
     *
     * @param c mouse object as JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/mouse", method = RequestMethod.POST, headers
            = {"content-type=application/json"})
    public void saveMouse(@RequestBody Mouse c) {
        database.save(c);
    }

    /**
     * Saves a new audio to the database.
     *
     * @param c audio object as JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/audio", method = RequestMethod.POST, headers
            = {"content-type=application/json"})
    public void saveAudio(@RequestBody Audio c) {
        database.save(c);
    }

    /**
     * Saves a new keyboard to the database.
     *
     * @param c keyboard object as JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/keyboard", method = RequestMethod.POST, headers
            = {"content-type=application/json"})
    public void saveKeyboard(@RequestBody Keyboard c) {
        database.save(c);
    }

    /**
     * Saves a new console to the database.
     *
     * @param c console object as JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/console", method = RequestMethod.POST, headers
            = {"content-type=application/json"})
    public void saveConsole(@RequestBody Console c) {
        database.save(c);
    }

    /**
     * Saves a new tv to the database.
     *
     * @param c tv object as JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/tv", method = RequestMethod.POST, headers
            = {"content-type=application/json"})
    public void saveTV(@RequestBody TV c) {
        database.save(c);
    }

    /**
     * Saves a new screen to the database.
     *
     * @param c screen object as JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/screen", method = RequestMethod.POST, headers
            = {"content-type=application/json"})
    public void saveScreen(@RequestBody Screen c) {
        database.save(c);
    }

    /**
     * Gets all items from the database.
     *
     * @return all items
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public Iterable<ShoppingItem> fetchLocation() {

        return database.findAll();
    }

    /**
     * Gets the items that are in the shopping cart
     *
     * @return shopping cart items
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/showShoppingCart", method = RequestMethod.GET)
    public Iterable<ShoppingItem> getCart() {

        return shoppingCart;
    }

    /**
     * Returns the items that are in the user's shopping cart.
     *
     * @param list string list
     * @return the items that are in the cart
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/showShoppingCartWithItems/{list}", method
            = RequestMethod.GET)
    public List<ShoppingItem> getCartWithItems(@PathVariable String list) {
        List<String> items = Arrays.asList(list.split("\\s*,\\s*"));
        List<Integer> intList = new ArrayList();
        List<ShoppingItem> shoppingList = new ArrayList();
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).equals("")) {
                intList.add(Integer.parseInt(items.get(i)));
            }
        }
        for (int i = 0; i < intList.size(); i++) {
            shoppingList.add(database.findOne((long) intList.get(i)));
        }

        return shoppingList;
    }

    /**
     * Reduces the quantity of the items in the shopping cart by 1
     *
     * @param list string list
     * @return items in the shopping cart
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/checkOutItems/{list}", method = RequestMethod.GET)
    public List<ShoppingItem> checkOutItems(@PathVariable String list) {
        List<String> items = Arrays.asList(list.split("\\s*,\\s*"));
        List<Integer> intList = new ArrayList();
        List<ShoppingItem> shoppingList = new ArrayList();
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).equals("")) {
                intList.add(Integer.parseInt(items.get(i)));

            }
        }
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(database.findOne((long) intList.get(i))
                    .getQuantity());
            database.updateCount((long) intList.get(i), database.findOne((long) intList.get(i)).getQuantity() - 1);
        }

        return shoppingList;
    }

    /**
     * Gets the item with the given id.
     *
     * @param itemId items id number.
     * @return the item.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.GET)
    public ShoppingItem fetchItem(@PathVariable long itemId) {

        return database.findOne(itemId);
    }

    /**
     * Search items from the database with the given string.
     *
     * @param c the string which is used to search
     * @return searched items
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/itemsSearch", method = RequestMethod.POST)
    public List<ShoppingItem> searchItems(@RequestBody ShoppingItem c) {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (!c.getTags().equals("")) {
                if (data.get(i).getTags().toLowerCase().replace(" ", "")
                        .contains(c.getTags().toLowerCase().replace(" ", ""))) {
                    temp.add(data.get(i));
                }
            }
        }

        System.out.println(c.getTags());

        return temp;
    }

    /**
     * Gets all the computers from the database.
     *
     * @return computers
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    public List<ShoppingItem> getComputers() {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Computer) {
                temp.add(data.get(i));
            }

        }
        return temp;
    }

    /**
     * Gets all the screens from the database.
     *
     * @return screens
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/screen", method = RequestMethod.GET)
    public List<ShoppingItem> getScreens() {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Screen) {
                temp.add(data.get(i));
            }

        }
        return temp;
    }

    /**
     * Gets all the tvs from the database.
     *
     * @return tvs
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/tv", method = RequestMethod.GET)
    public List<ShoppingItem> getTV() {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof TV) {
                temp.add(data.get(i));
            }

        }
        return temp;
    }

    /**
     * Gets all the consoles from the database.
     *
     * @return consoles
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    public List<ShoppingItem> getConsole() {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Console) {
                temp.add(data.get(i));
            }

        }
        return temp;
    }

    /**
     * Gets all the mouses from the database.
     *
     * @return mouses
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/mouse", method = RequestMethod.GET)
    public List<ShoppingItem> getMouse() {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Mouse) {
                temp.add(data.get(i));
            }

        }
        return temp;
    }

    /**
     * Gets all the keyboards from the database.
     *
     * @return keyboards
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
    public List<ShoppingItem> getKeyboard() {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Keyboard) {
                temp.add(data.get(i));
            }

        }
        return temp;
    }

    /**
     * Gets all the audio devices from the database.
     *
     * @return audio devices
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/audio", method = RequestMethod.GET)
    public List<ShoppingItem> getAudio() {
        List<ShoppingItem> data = database.findAll();
        List<ShoppingItem> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Audio) {
                temp.add(data.get(i));
            }

        }
        return temp;
    }

    /**
     * Updates the cart. Adds new item to the cart database.
     *
     * @param c item which is added to the cart
     * @return the shopping cart list.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/updateCart", method = RequestMethod.POST)
    public List<ShoppingItem> updateCart(@RequestBody CartItem c) {
        System.out.println(c.getId());
        shoppingCart.add(database.findOne(c.getId()));
        return shoppingCart;
    }

    /**
     * Fills the database with dumb data and prints the backends urls to
     * console.
     *
     */
    public void fillWithTestdata() {

        database.save(new TV("Samsung 65\" Ultra HD Smart", 1199.90, "3840 × 2160 Ultra HD", 0, " 1458,1 x 841,4 x 54,9 mm", "LED", "16:9", "Liitännät: 3 x HDMI, 2 x USB, komponentti-/komposiitti, digitaalinen audio ulos (optinen), Ethernet (LAN)\n"
                + "Anynet+ (HDMI-CEC)\n"
                + "HDMI 2.0a", 26.8, "images/tv2.jpg", "Samsung UE65KU6405 65\" Ultra HD Smart LED 16:9 3840 × 2160 Ultra HD ", 10));
        database.save(new TV("Sony 100\" Smart 4K Ultra HD", 74999.90, "3840 × 2160 Ultra HD", 1200, "225,8 x 130,3 x 9,8 cm", "LED", "16:9", "Liitännät: 4 x HDMI, 3 x USB, SCART, Ethernet, komposiittivideotulo, analoginen äänitulo, digitaalinen äänilähtö, kuulokeliitäntä\n"
                + "HDCP 2.2\n"
                + "BRAVIA Sync (HDMI-CEC)\n"
                + "HDMI ARC (Audio Return Channel)\n", 145, "https://cdn-b.verkkokauppa.com/images/43/2_364055-1024x768.jpeg", "Sony KD100ZD9 100\" Smart Android 4K Ultra HD LED 3840 × 2160 Ultra HD 225,8 x 130,3 x 9,8 cm 16:9 ", 10));
        database.save(new Screen(24, "570 x 222 x 431 mm", "BenQ Zowie 24\" LED", 299.90, "1920 x 1080", 144, 1, 170, "LED", "16:9", "D-SUB (VGA), DVI-DL, 1 x HDMI, 3.5 mm audio in/out", 6.1, "https://cdn-b.verkkokauppa.com/images/41/2_344675-699x650.jpg", "570 x 222 x 431 mm BenQ Zowie XL2411 24\" LED 1920 x 1080 16:9 D-SUB (VGA), DVI-DL, 1 x HDMI, 3.5 mm audio in/out", 10));
        database.save(new Screen(24, " 56,5 x 40,1 x 17,9 cm", "Acer 24\" 144 Hz", 279.90, "1920 x 1080", 144, 1, 176, "TN", "16:9", "Liitäntöinä VGA, DVI sekä HDMI", 3.52, "https://cdn-b.verkkokauppa.com/images/94/2_176306-825x591.jpg", "56,5 x 40,1 x 17,9 cm Acer GN246HL 24\" 144 Hz TN VGA, DVI sekä HDMI", 10));
        database.save(new Computer("Asus ROG G20BM ‐tietokone", 799.00, "AMD FX 770K Quad-Core 3,5 GHz", "AMD Radeon R9 380 2 Gt", null, "8 Gt DDR3 SO-DIMM", "1 Tt SATAIII 7200 RPM, jossa 8 Gt:n SSD-cache", "null", 0, "Windows", "https://cdn-a.verkkokauppa.com/1920/images/97/2_328712-2864x4000.jpg", 1, "\"Asus ROG G20BM ‐tietokone AMD FX 770K Quad-Core 3,5 GHz AMD Radeon R9 380 2 Gt 8 Gt DDR3 SO-DIMM 1 Tt SATAIII 7200 RPM, jossa 8 Gt:n SSD-cache"));
        database.save(new Computer("Acer Predator G3-710", 1249.90, "Intel Core i5-6400 Quad-Core 2.7 GHz", "NVIDIA GeForce GTX 1060 6 Gt", "500 W", "8 Gt (1 x 8 Gt) DDR4 2133 MHz", "256 Gt M.2 SATA SSD -levy + 1 Tt 7200 RPM SATA", null, 0, "Windows", "https://cdn-c.verkkokauppa.com/images/54/2_344297-800x1071.jpeg", 1, "cer Predator G3-710 Intel Core i5-6400 Quad-Core 2.7 GHz NVIDIA GeForce GTX 1060 6 Gt 500 W 8 Gt (1 x 8 Gt) DDR4 2133 MHz 256 Gt M.2 SATA SSD -levy + 1 Tt 7200 RPM SATA"));
        database.save(new Audio("Philips SHK1030", 13.90, 0, 0, 0, "images/kuuloke1.jpeg", 6, "Philips SHK1030 Audio"));
        database.save(new Audio("Sennheiser HD 800 S", 2999.90, 0, 0, 0, "images/kuuloke2.jpeg", 15, "Sennheiser HD 800 S Audio"));
        database.save(new Keyboard("Deltaco TB-121", 10.90, 0.098, 0, false, "images/nappis1.jpeg", 11, "Deltaco TB-121 Keyboard"));
        database.save(new Keyboard("Asus ROG Claymore", 239.90, 0.943, 0, false, "images/nappis2.jpg", 13, "Asus ROG Claymore Keyboard"));
        database.save(new Console("Sony PlayStation 4 500 Gt", 299.90, 2.1, 500, "images/ps4.jpg", 20, "Sony PlayStation 4 500 Gt Console"));
        database.save(new Console("Nintendo Switch", 349.90, 0.398, 32, "images/switch.jpeg", 1, "Nintendo Switch Console"));
        database.save(new Mouse("Fuj:tech Optical Mouse", 4.90, 0, 3, false, "images/hiiri1.jpeg", 20, "Fuj:tech Optical Mouse"));
        database.save(new Mouse("3Dconnexion SpaceMouse", 459.90, 0, 15, true, "images/hiiri2.jpg", 5, "3Dconnexion SpaceMouse"));

        System.out.println("Url path GET \"localhost:8080/items\" shows all items currently in database");
        System.out.println("Url path GET \"localhost:8080/items/{itemId}\" shows specific item with matching id in database");
        System.out.println("Url path GET \"localhost:8080/index.html\" shows homepage where all items are shown");
        System.out.println("Url path GET \"localhost:8080/addComputer.html\" shows form that with a new computer can be added");
        System.out.println("Url path GET \"localhost:8080/addTV.html\" shows form that with a new TV can be added");
        System.out.println("Url path GET \"localhost:8080/addScreen.html\" shows form that with a new screen can be added");
        System.out.println("Url path POST \"localhost:8080/computer\" adds new computer with given json data");
        System.out.println("Url path POST \"localhost:8080/tv\" adds new TV with given json data");
        System.out.println("Url path POST \"localhost:8080/screen\" adds new screen with given json data");
        System.out.println("Url path POST \"localhost:8080/audio\" adds new audio with given json data");
        System.out.println("Url path POST \"localhost:8080/keyboard\" adds new keyboard with given json data");
        System.out.println("Url path POST \"localhost:8080/mouse\" adds new mouse with given json data");
        System.out.println("Url path POST \"localhost:8080/console\" adds new console with given json data");
        System.out.println("Url path GET \"localhost:8080/audio\" shows audio items currently in database");
        System.out.println("Url path GET \"localhost:8080/computer\" shows computer items currently in database");
        System.out.println("Url path GET \"localhost:8080/console\" shows console items currently in database");
        System.out.println("Url path GET \"localhost:8080/keyboard\" shows keyboard items currently in database");
        System.out.println("Url path GET \"localhost:8080/mouse\" shows mouse items currently in database");
        System.out.println("Url path GET \"localhost:8080/screen\" shows screen items currently in database");
        System.out.println("Url path GET \"localhost:8080/tv\" shows tv items currently in database");
        System.out.println("Url path POST \"localhost:8080/updateCart\" updates the shopping cart");
        shoppingCart = new ArrayList();
    }
}
