package fi.tamk.tiko;

import javax.persistence.Entity;

/**
 * 
 * 
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
 */
@Entity
public class TV extends ShoppingItem {

    private String name;
    private double price;
    private String resolution;
    private int refreshRate;
    private String size;
    private String type;
    private String aspectRatio;
    private String connections;
    private double weight;
    private String picture;
    private String tags;

    /**
     * Empty constructor for the tv object
     *
     */
    public TV() {

    }

    /**
     * Constructor for the tv object
     *
     * @param name String name
     * @param price double price
     * @param resolution String resolution
     * @param refreshRate int refreshRate
     * @param size String size
     * @param type String type
     * @param aspectRatio String aspectRatio
     * @param connections String connections
     * @param weight double weight
     * @param picture String picture
     * @param tags String tags
     * @param quantity int quantity
     */
    public TV(String name, double price, String resolution, int refreshRate,
            String size, String type, String aspectRatio, String connections,
            double weight, String picture, String tags, int quantity) {
        this.name = name;
        this.price = price;
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.size = size;
        this.type = type;
        this.aspectRatio = aspectRatio;
        this.connections = connections;
        this.weight = weight;
        this.picture = picture;
        this.tags = tags;
        setQuantity(quantity);
    }

    /**
     * Returns the tv as JSON string.
     *
     * @return tv object as JSON
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "TV{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", resolution='" + resolution + '\''
                + ", refreshRate=" + refreshRate
                + ", size='" + size + '\''
                + ", type='" + type + '\''
                + ", aspectRatio='" + aspectRatio + '\''
                + ", connections='" + connections + '\''
                + ", weight=" + weight
                + ", picture='" + picture + '\''
                + '}';
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
     * Sets the tags for the tv.
     *
     * @param tags string tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * Gets the name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the tv.
     *
     * @param name string name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price.
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the tv.
     *
     * @param price double price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the resolution.
     *
     * @return resolution.
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the resolution of the tv.
     *
     * @param resolution string resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * gets the refreshRate.
     *
     * @return refreshRate
     */
    public int getRefreshRate() {
        return refreshRate;
    }

    /**
     * Sets the refreshRate.
     *
     * @param refreshRate int refreshRate
     */
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    /**
     * Gets the size.
     *
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the tv.
     *
     * @param size string size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets the type.
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the tv.
     *
     * @param type string type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the aspectRatio
     *
     * @return aspectRatio
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * Sets the aspectRatio.
     *
     * @param aspectRatio string aspectRatio
     */
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * Gets the connections.
     *
     * @return connections
     */
    public String getConnections() {
        return connections;
    }

    /**
     * Sets the connections.
     *
     * @param connections string connections
     */
    public void setConnections(String connections) {
        this.connections = connections;
    }

    /**
     * Gets the weight.
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight.
     *
     * @param weight double weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the URL for the picture.
     *
     * @return URL for the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets the picture URL.
     *
     * @param picture URL for the picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

}
