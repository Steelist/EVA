package fi.tamk.tiko;

import javax.persistence.Entity;

@Entity
public class TV extends ShoppingItem {
    public String name;
    public double price;
    public String resolution;
    public int refreshRate;
    public String size;
    public String type;
    public String aspectRatio;
    public String connections;
    public double weight;
    public String picture;

    public TV(){

    }

    public TV(String name, double price, String resolution, int refreshRate, String size, String type, String aspectRatio, String connections, double weight, String picture) {
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