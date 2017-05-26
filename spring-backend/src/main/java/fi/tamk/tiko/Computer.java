package fi.tamk.tiko;

import javax.persistence.Entity;

/**
 * Makes the computer object that extends shoppingItem.
 *
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
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

    /*
    Gets the tags of the computer.

    @return Tags.
     */
    public String getTags() {
        return tags;
    }

    /*
    Sets the tags for the computer.

    @param tags Tags for the computer.
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /*
    Gets the quantity of the computer.

    @return Quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /*
    Sets the quantity for the computer.

    @param quantity Quantity for the computer.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*
    Gets the name of the computer.

    @return Name.
     */
    public String getName() {
        return name;
    }

    /*
    Sets the name for the computer.

    @param name Name for the computer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
    Gets the price of the computer.

    @return Price.
     */
    public double getPrice() {
        return price;
    }

    /*
    Sets the price for the computer.

    @param tags Price for the computer.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
    Gets the cpu of the computer.

    @return Cpu.
     */
    public String getCpu() {
        return cpu;
    }

    /*
    Sets the cpu for the computer.

    @param cpu Cpu for the computer.
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /*
    Gets the gpu of the computer.

    @return Gpu.
     */
    public String getGpu() {
        return gpu;
    }

    /*
    Sets the gpu for the computer.

    @param gpu Gpu for the computer.
     */
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    /*
    Gets the psu of the computer.

    @return Psu.
     */
    public String getPsu() {
        return psu;
    }

    /*
    Sets the psu for the computer.

    @param psu Psu for the computer.
     */
    public void setPsu(String psu) {
        this.psu = psu;
    }

    /*
    Gets the ram of the computer.

    @return Ram.
     */
    public String getRam() {
        return ram;
    }

    /*
    Sets the ram for the computer.

    @param ram Ram for the computer.
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /*
    Gets the hdd of the computer.

    @return Hdd.
     */
    public String getHdd() {
        return hdd;
    }

    /*
    Sets the hdd for the computer.

    @param hdd Hdd for the computer.
     */
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    /*
    Gets the motherBoard of the computer.

    @return MotherBoard.
     */
    public String getMotherBoard() {
        return motherBoard;
    }

    /*
    Sets the motherBoard for the computer.

    @param motherBoard MotherBoard for the computer.
     */
    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    /*
    Gets the weight of the computer.

    @return Weight.
     */
    public double getWeight() {
        return weight;
    }

    /*
    Sets the weight for the computer.

    @param weight Weight for the computer.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*
    Gets the os of the computer.

    @return Os.
     */
    public String getOs() {
        return os;
    }

    /*
    Sets the os for the computer.

    @param os Os for the computer.
     */
    public void setOs(String os) {
        this.os = os;
    }

    /*
    Gets the picture of the computer.

    @return Picture.
     */
    public String getPicture() {
        return picture;
    }

    /*
    Sets the picture for the computer.

    @param picture Picture for the computer.
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /*
    Initializes the values for the computer.
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

    /*
    Constructs an empty computer.
     */
    public Computer() {

    }

    /*
    Returns the computer item in the wanted format.

    @return Computer item.
     */
    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", psu=" + psu +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", motherBoard=" + motherBoard +
                ", weight=" + weight +
                ", os=" + os +
                ", picture='" + picture + '\'' +
                '}';
    }
}