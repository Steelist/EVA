package fi.tamk.tiko;

import javax.persistence.Entity;

/**
 * Makes the keyboard object that extends shoppingItem.
 *
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
 */
@Entity
public class Keyboard extends ShoppingItem {

    public String name;
    public double price;
    public double weight;
    public int memory;
    public boolean wireless;
    public String picture;

    /**
     * Empty constructor
     *
     */
    public Keyboard() {

    }

    /**
     * Constructor with all the parameters
     *
     * @param name String name
     * @param price double price
     * @param weight double weight
     * @param memory int memory
     * @param wireless boolean wireless
     * @param picture String picture
     * @param quantity int quantity
     * @param tags String tags
     */
    public Keyboard(String name, double price, double weight, int memory, boolean wireless, String picture, int quantity, String tags) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.memory = memory;
        this.wireless = wireless;
        this.picture = picture;
        setQuantity(quantity);
        setTags(tags);
    }

    /**
     * Returns the keyboard object as JSON string.
     *
     * @return keyboard as JSON
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "Audio{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", weight=" + weight
                + ", memory=" + memory
                + ", wireless=" + wireless
                + ", picture='" + picture + '\''
                + '}';
    }

    /**
     * Gets the name of the keyboard.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the keyboard.
     *
     * @param name string name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the keyboard.
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the keyboard.
     *
     * @param price double price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the weight of the keyboard.
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the Weight of the keyboard.
     *
     * @param weight double weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * gets the memory of the keyboard.
     *
     * @return memory
     */
    public int getMemory() {
        return memory;
    }

    /**
     * Sets the memory of the keyboard.
     *
     * @param memory int memory.
     */
    public void setMemory(int memory) {
        this.memory = memory;
    }

    /**
     * Gets the boolean wireless.
     *
     * @return wireless
     */
    public boolean isWireless() {
        return wireless;
    }

    /**
     * Sets the boolean wireless.
     *
     * @param wireless boolean wireless
     */
    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    /**
     * Gets the URL of the picture.
     *
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets the URL of the picture.
     *
     * @param picture string picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
