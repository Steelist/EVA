package fi.tamk.tiko;

import javax.persistence.Entity;

@Entity
public class Keyboard extends ShoppingItem {

    public String name;
    public double price;
    public double weight;
    public int memory;
    public boolean wireless;
    public String picture;

    public Keyboard() {

    }

    public Keyboard(String name, double price, double weight, int memory, boolean wireless, String picture) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.memory = memory;
        this.wireless = wireless;
        this.picture = picture;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Audio{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", memory=" + memory +
                ", wireless=" + wireless +
                ", picture='" + picture + '\'' +
                '}';
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}