package fi.tamk.tiko;

import javax.persistence.Entity;

@Entity
public class Mouse extends ShoppingItem {

    public String name;
    public double price;
    public double weight;
    public int buttons;
    public boolean wireless;
    public String picture;

    public Mouse() {

    }

    public Mouse(String name, double price, double weight, int buttons, boolean wireless, String picture) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.buttons = buttons;
        this.wireless = wireless;
        this.picture = picture;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Audio{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", buttons=" + buttons +
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

    public int getButtons() {
        return buttons;
    }

    public void setButtons(int buttons) {
        this.buttons = buttons;
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