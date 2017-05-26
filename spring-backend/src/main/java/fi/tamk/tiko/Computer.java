package fi.tamk.tiko;

import javax.persistence.Entity;

/**
 *
 * @author Erqq
 */
@Entity
public class Computer extends ShoppingItem {

    private String name;
    private double price;
    private String cpu;
    private String gpu;
    private String psu;
    private String ram;
    private String hdd;
    private String motherBoard;
    private double weight;
    private String os;
    private String picture;
    private int quantity;
    private String tags;

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
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    public String getCpu() {
        return cpu;
    }

    /**
     *
     * @param cpu
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     *
     * @return
     */
    public String getGpu() {
        return gpu;
    }

    /**
     *
     * @param gpu
     */
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    /**
     *
     * @return
     */
    public String getPsu() {
        return psu;
    }

    /**
     *
     * @param psu
     */
    public void setPsu(String psu) {
        this.psu = psu;
    }

    /**
     *
     * @return
     */
    public String getRam() {
        return ram;
    }

    /**
     *
     * @param ram
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     *
     * @return
     */
    public String getHdd() {
        return hdd;
    }

    /**
     *
     * @param hdd
     */
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    /**
     *
     * @return
     */
    public String getMotherBoard() {
        return motherBoard;
    }

    /**
     *
     * @param motherBoard
     */
    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
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
    public String getOs() {
        return os;
    }

    /**
     *
     * @param os
     */
    public void setOs(String os) {
        this.os = os;
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

    /**
     *
     * @param name
     * @param price
     * @param cpu
     * @param gpu
     * @param psu
     * @param ram
     * @param hdd
     * @param motherBoard
     * @param weight
     * @param os
     * @param picture
     * @param quantity
     * @param tags
     */
    public Computer(String name, double price, String cpu, String gpu, String psu, String ram, String hdd, String motherBoard, double weight, String os, String picture, int quantity, String tags) {
        this.name = name;
        this.price = price;
        this.cpu = cpu;
        this.gpu = gpu;
        this.psu = psu;
        this.ram = ram;
        this.hdd = hdd;
        this.motherBoard = motherBoard;
        this.weight = weight;
        this.os = os;
        this.picture = picture;
        this.quantity = quantity;
        this.tags = tags;
    }

    /**
     *
     */
    public Computer() {

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Computer{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", cpu=" + cpu
                + ", gpu=" + gpu
                + ", psu=" + psu
                + ", ram=" + ram
                + ", hdd=" + hdd
                + ", motherBoard=" + motherBoard
                + ", weight=" + weight
                + ", os=" + os
                + ", picture='" + picture + '\''
                + '}';
    }
}
