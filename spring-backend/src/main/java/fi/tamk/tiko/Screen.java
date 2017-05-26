package fi.tamk.tiko;

import java.text.DecimalFormat;
import javax.persistence.Column;
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
public class Screen extends ShoppingItem {

    private double screenSize;
    private String packageSize;
    private String name;
    private double price;
    private String resolution;
    private int refreshRate;
    private double wasteTime;
    private double viewingAngle;
    private String type;
    private String aspectRatio;
    private String connections;
    private double weight;
    private String picture;

    /**
     * Empty constructor
     *
     */
    public Screen() {

    }

    /**
     * Constructor for the screen object with all the parameters.
     *
     * @param screenSize double screenSize
     * @param packageSize String packageSize
     * @param name String name
     * @param price double price
     * @param resolution string resolution
     * @param refreshRate int refreshRate
     * @param wasteTime double wasteTime
     * @param viewingAngle double viewingAngle
     * @param type String type
     * @param aspectRatio String aspectRatio
     * @param connections String connections
     * @param weight double weight
     * @param picture String picture
     * @param tags String tags
     * @param quantity int quantity
     */
    public Screen(double screenSize, String packageSize, String name,
            double price, String resolution, int refreshRate, double wasteTime,
            double viewingAngle, String type, String aspectRatio,
            String connections, double weight, String picture, String tags,
            int quantity) {
        this.screenSize = screenSize;
        this.packageSize = packageSize;
        this.name = name;
        this.price = price;
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.wasteTime = wasteTime;
        this.viewingAngle = viewingAngle;
        this.type = type;
        this.aspectRatio = aspectRatio;
        this.connections = connections;
        this.weight = weight;
        this.picture = picture;
        setTags(tags);
        setQuantity(quantity);
    }

    /**
     * Returns the screen as JSON string.
     *
     * @return screen object as JSON
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "Screen{"
                + "screenSize=" + screenSize
                + ", packageSize='" + packageSize + '\''
                + ", name='" + name + '\''
                + ", price=" + price
                + ", resolution='" + resolution + '\''
                + ", refreshRate=" + refreshRate
                + ", wasteTime=" + wasteTime
                + ", viewingAngle=" + viewingAngle
                + ", type='" + type + '\''
                + ", aspectRatio='" + aspectRatio + '\''
                + ", connections='" + connections + '\''
                + ", weight=" + weight
                + ", picture='" + picture + '\''
                + '}';
    }

    /**
     * Gets the screen size.
     *
     * @return size
     */
    public double getScreenSize() {
        return screenSize;
    }

    /**
     * Sets the size of the screen.
     *
     * @param screenSize double size
     */
    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    /**
     * Gets the screen package size.
     *
     * @return screen package size
     */
    public String getPackageSize() {
        return packageSize;
    }

    /**
     * Sets the package size.
     *
     * @param packageSize string packageSize
     */
    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    /**
     * Gets the name of the screen.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the screen.
     *
     * @param name string name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the screen.
     *
     * @return price
     */
    public double getPrice() {

        return price;
    }

    /**
     * Sets the price of the screen.
     *
     * @param price double price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the resolution of the screen.
     *
     * @return resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the resolution for the screen.
     *
     * @param resolution string resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * Gets the refresRate.
     *
     * @return refresRate
     */
    public int getRefreshRate() {
        return refreshRate;
    }

    /**
     * Sets the refresRate.
     *
     * @param refreshRate int refreshRate
     */
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    /**
     * Gets the wasteTime.
     *
     * @return wasteTime
     */
    public double getWasteTime() {
        return wasteTime;
    }

    /**
     * Sets the wasteTime.
     *
     * @param wasteTime double wasteTime
     */
    public void setWasteTime(double wasteTime) {
        this.wasteTime = wasteTime;
    }

    /**
     * Gets the view Angle.
     *
     * @return viewingAngle
     */
    public double getViewingAngle() {
        return viewingAngle;
    }

    /**
     * Sets the viewingAngle.
     *
     * @param viewingAngle double viewingAngle
     */
    public void setViewingAngle(double viewingAngle) {
        this.viewingAngle = viewingAngle;
    }

    /**
     * Gets the type of the screen.
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the screen.
     *
     * @param type String type
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
     * Sets the aspectRatio for the screen.
     *
     * @param aspectRatio String aspectRatio
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
     * Sets the connections for the screen.
     *
     * @param connections string connections
     */
    public void setConnections(String connections) {
        this.connections = connections;
    }

    /**
     * Gets the weight of the screen.
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the screen.
     *
     * @param weight double weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the URL of the picture.
     *
     * @return picture URL
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets the URL for the picture.
     *
     * @param picture string URL
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
