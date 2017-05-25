package fi.tamk.tiko;

import javax.persistence.Entity;

/**
 *
 * @author Erqq
 */
@Entity
public class Audio extends ShoppingItem {

    public String name;
    public double price;
    public double power;
    public double subwooferPower;
    public int channels;
    public String picture;

    /**
     *
     */
    public Audio() {

    }

    /**
     *
     * @param name
     * @param price
     * @param power
     * @param subwooferPower
     * @param channels
     * @param picture
     * @param quantity
     * @param tags
     */
    public Audio(String name, double price, double power, double subwooferPower, int channels, String picture, int quantity, String tags) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.subwooferPower = subwooferPower;
        this.channels = channels;
        this.picture = picture;
        setQuantity(quantity);
        setTags(tags);
    }

    /**
     *
     * @return
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "Audio{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", power=" + power
                + ", subwooferPower=" + subwooferPower
                + ", channels=" + channels
                + ", picture='" + picture + '\''
                + '}';
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
    public double getPower() {
        return power;
    }

    /**
     *
     * @param power
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     *
     * @return
     */
    public double getSubwooferPower() {
        return subwooferPower;
    }

    /**
     *
     * @param subwooferPower
     */
    public void setSubwooferPower(double subwooferPower) {
        this.subwooferPower = subwooferPower;
    }

    /**
     *
     * @return
     */
    public int getChannels() {
        return channels;
    }

    /**
     *
     * @param channels
     */
    public void setChannels(int channels) {
        this.channels = channels;
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
