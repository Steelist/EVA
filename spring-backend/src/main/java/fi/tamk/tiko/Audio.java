package fi.tamk.tiko;

import javax.persistence.Entity;

@Entity
public class Audio extends ShoppingItem {

    public String name;
    public double price;
    public double power;
    public double subwooferPower;
    public int channels;
    public String picture;

    public Audio() {

    }

    public Audio(String name, double price, double power, double subwooferPower, int channels, String picture, int quantity) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.subwooferPower = subwooferPower;
        this.channels = channels;
        this.picture = picture;
        setQuantity(quantity);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Audio{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", power=" + power +
                ", subwooferPower=" + subwooferPower +
                ", channels=" + channels +
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

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getSubwooferPower() {
        return subwooferPower;
    }

    public void setSubwooferPower(double subwooferPower) {
        this.subwooferPower = subwooferPower;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}