package fi.tamk.tiko;

@Entity
public class Computer extends ShoppingItem {
    public String name;
    public double price;
    public String cpu;
    public String gpu;
    public String psu;
    public String ram;
    public String hdd;
    public String motherBoard;
    public double weight;
    public String os;
    public String picture;
    
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

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getPsu() {
        return psu;
    }

    public void setPsu(String psu) {
        this.psu = psu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Computer(String name, double price, String cpu, String gpu, String psu, String ram, String hdd, String motherBoard, double weight, String os, String picture) {
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
    }




    public Computer() {

    }

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