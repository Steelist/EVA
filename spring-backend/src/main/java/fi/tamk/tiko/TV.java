package fi.tamk.tiko;

import javax.persistence.Entity;

/**
 *
 * @author Erqq
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

    public TV() {

    }

    /**
     *
     * @param name
     * @param price
     * @param resolution
     * @param refreshRate
     * @param size
     * @param type
     * @param aspectRatio
     * @param connections
     * @param weight
     * @param picture
     * @param tags
     * @param quantity
     */
    public TV(String name, double price, String resolution, int refreshRate, String size, String type, String aspectRatio, String connections, double weight, String picture, String tags, int quantity) {
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
     *
     * @return
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getResolution() {
        return resolution;
    }

    /**
     *
     * @param resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     *
     * @return
     */
    public int getRefreshRate() {
        return refreshRate;
    }

    /**
     *
     * @param refreshRate
     */
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    /**
     *
     * @return
     */
    public String getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     *
     * @param aspectRatio
     */
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     *
     * @return
     */
    public String getConnections() {
        return connections;
    }

    /**
     *
     * @param connections
     */
    public void setConnections(String connections) {
        this.connections = connections;
    }

    /**
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public String getPicture() {
        return picture;
    }

    /**
     *
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

}
