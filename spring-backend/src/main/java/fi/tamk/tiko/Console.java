package fi.tamk.tiko;

import javax.persistence.Entity;
/**
 * Makes the console object that extends shoppingItem.
 *
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
 */
@Entity
public class Console extends ShoppingItem {

    public String name;
    public double price;
    public double weight;
    public int memory;
    public String picture;
    /**
     * Empty constructor.
     * 
     */
    public Console() {

    }
/**
 * Constructor for the console with all parameters.
 * 
 * @param name String name
 * @param price double price
 * @param weight double weight
 * @param memory int memory
 * @param picture  String picture
 * @param quantity int quantity
 * @param tags  String tags
 */
    public Console(String name, double price, double weight, int memory,
            String picture, int quantity, String tags) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.memory = memory;
        this.picture = picture;
        setQuantity(quantity);
        setTags(tags);
    }
/**
 * Returns the console object as JSON string.
 * 
 * @return console as JSON
 */
    @java.lang.Override
    public java.lang.String toString() {
        return "Audio{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", memory=" + memory +
                ", picture='" + picture + '\'' +
                '}';
    }
/**
 * Gets the name of the console
 * 
 * @return name
 */
    public String getName() {
        return name;
    }
/**
 * Sets the name of the console.
 * 
 * @param name string name 
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * Gets the price of the console.
 * 
 * @return price 
 */
    public double getPrice() {
        return price;
    }
/**
 * Sets the price of the console.
 * 
 * @param price double price
 */
    public void setPrice(double price) {
        this.price = price;
    }
/**
 * Gets the weight of the console.
 * 
 * @return weight
 */
    public double getWeight() {
        return weight;
    }
/**
 * Sets the weight of the console.
 * 
 * @param weight double weight
 */
    public void setWeight(double weight) {
        this.weight = weight;
    }
/**
 * Gets the memory of the console.
 * 
 * @return memory
 */
    public int getMemory() {
        return memory;
    }
/**
 * Sets the memory of the console.
 * 
 * @param memory int memory
 */
    public void setMemory(int memory) {
        this.memory = memory;
    }
/**
 * Gets the url of the picture.
 * 
 * @return picture
 */
    public String getPicture() {
        return picture;
    }
/**
 * Sets the picture url for the console.
 * 
 * @param picture string picture.
 */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}