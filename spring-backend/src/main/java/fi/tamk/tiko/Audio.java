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
     * Empty constructor.
     *
     */
    public Audio() {

    }

    /**
     * Constructor for the audio object with all parameters.
     *
     * @param name String name
     * @param price double price
     * @param power double power
     * @param subwooferPower double subwooferPower
     * @param channels int channels
     * @param picture String picture
     * @param quantity int quantity
     * @param tags String tags
     */
    public Audio(String name, double price, double power, double subwooferPower,
            int channels, String picture, int quantity, String tags) {
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
     * Returns the audio object as JSON string.
     *
     * @return audio as JSON
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
     * Gets the name of the audio device.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the audio device.
     *
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the audio device.
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the audio device.
     *
     * @param price double price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the power of the device.
     *
     * @return power
     */
    public double getPower() {
        return power;
    }

    /**
     * Sets the power of the device.
     *
     * @param power double power.
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * Gets the subWoofer power.
     *
     * @return subwooferPower
     */
    public double getSubwooferPower() {
        return subwooferPower;
    }

    /**
     * Sets the subwooferPower.
     *
     * @param subwooferPower double subwooferPower
     */
    public void setSubwooferPower(double subwooferPower) {
        this.subwooferPower = subwooferPower;
    }

    /**
     * Gets the channels of the device.
     *
     * @return channels
     */
    public int getChannels() {
        return channels;
    }

    /**
     * Sets the channels of the device.
     *
     * @param channels int channels
     */
    public void setChannels(int channels) {
        this.channels = channels;
    }

    /**
     * Gets the URL of the picture.
     *
     * @return picture.
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets the URL of the picture.
     *
     * @param picture string picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
