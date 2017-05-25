package fi.tamk.tiko;

/**
 *
 * @author Erqq
 */
public class CartItem {

    private long id;

    /**
     * Gets the id.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id long id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Constructor with id.
     * 
     * @param id long id
     */
    public CartItem(long id) {
        this.id = id;
    }

    /**
     * Constructor.
     * 
     */
    public CartItem() {

    }
}
