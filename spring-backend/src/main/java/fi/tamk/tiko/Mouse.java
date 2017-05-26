package fi.tamk.tiko;

import javax.persistence.Entity;

/**
 * Makes the screen object that extends shoppingItem.
 *
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
 */
@Entity
public class Mouse extends ShoppingItem {

    public String name;
    public double price;
    public double weight;
    public int buttons;
    public boolean wireless;
    public String picture;

    /**
     * Empty constructor.
     * 
     */
    public Mouse() {

    }

    /**
     * Constructor with all the parameters.
     *
     * @param name String name
     * @param price double price
     * @param weight double weight
     * @param buttons int buttons
     * @param wireless boolean wireless
     * @param picture String picture
     * @param quantity int quantity
     * @param tags String tags
     */
    public Mouse(String name, double price, double weight, int buttons,
            boolean wireless, String picture, int quantity, String tags) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.buttons = buttons;
        this.wireless = wireless;
        this.picture = picture;
        setQuantity(quantity);
        setTags(tags);
    }

    /**
     * Returns the mouse object as JSON string.
     *
     * @return mouse as JSON.
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "Audio{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", weight=" + weight
                + ", buttons=" + buttons
                + ", wireless=" + wireless
                + ", picture='" + picture + '\''
                + '}';
    }

    /**
     * Gets the name of the mouse.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the mouse.
     *
     * @param name string name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the mouse.
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the mouse.
     *
     * @param price double price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the weight of the mouse.
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the mouse.
     *
     * @param weight double weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the button count.
     *
     * @return buttons
     */
    public int getButtons() {
        return buttons;
    }

    /**
     * Sets how many buttons the mouse has.
     *
     * @param buttons int buttons
     */
    public void setButtons(int buttons) {
        this.buttons = buttons;
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
     * Sets the wireless boolean
     *
     * @param wireless boolean wireless
     */
    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    /**
     * Gets the picture URL.
     *
     * @return URL for the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets the URL of the picture for the mouse.
     *
     * @param picture string picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
