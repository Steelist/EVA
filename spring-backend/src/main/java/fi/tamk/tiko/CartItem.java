package fi.tamk.tiko;

/**
 * Makes the CartItem object.
 * 
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
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
     * Empty constructor.
     * 
     */
    public CartItem() {

    }
}
