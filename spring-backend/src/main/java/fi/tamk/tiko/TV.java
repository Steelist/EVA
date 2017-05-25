package fi.tamk.tiko;

import javax.persistence.Entity;

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

    public TV(){

    }

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

    @java.lang.Override
    public java.lang.String toString() {
        return "TV{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", resolution='" + resolution + '\'' +
                ", refreshRate=" + refreshRate +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", aspectRatio='" + aspectRatio + '\'' +
                ", connections='" + connections + '\'' +
                ", weight=" + weight +
                ", picture='" + picture + '\'' +
                '}';
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}