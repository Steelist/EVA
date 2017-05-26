package fi.tamk.tiko;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Makes the shoppingItem object.
 * 
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
 */
@Entity
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tags;
    private int quantity;

    /**
     * Empty constructor.
     * 
     */
    public ShoppingItem() {

    }

    /**
     * Constructor for the ShoppingItem with tags and quantity.
     * 
     * @param tags string tags
     * @param quantity int quantity
     */
    public ShoppingItem(String tags, int quantity) {
        this.tags = tags;
        this.quantity = quantity;
    }

    /**
     * Constructor for the shoppingItem with tags.
     * 
     * @param tags string tags
     */
    public ShoppingItem(String tags) {
        this.tags = tags;
    }

    /**
     * Gets the id of the item.
     * 
     * @return item id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the quantity.
     * 
     * @return quantityt
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item.
     * 
     * @param quantity int quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the tags.
     * 
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * Sets the tags for the item.
     * 
     * @param tags string tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * Returns the shoppingItem object to string.
     * 
     * @return shoppingItem to string
     */
    @Override
    public String toString() {
        return "{" + "\"ID\": " + this.id + "\"tags\": " + this.tags
                + "\"quantity\": " + this.quantity+"}";
    }
}
