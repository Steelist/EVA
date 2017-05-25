package fi.tamk.tiko;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Erqq
 */
@Entity
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tags;
    private int quantity;

    /**
     *
     */
    public ShoppingItem() {

    }

    /**
     *
     * @param tags
     * @param quantity
     */
    public ShoppingItem(String tags, int quantity) {
        this.tags = tags;
        this.quantity = quantity;
    }

    /**
     *
     * @param tags
     */
    public ShoppingItem(String tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public String getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "{" + "\"ID\": " + this.id + "}";
    }
}
