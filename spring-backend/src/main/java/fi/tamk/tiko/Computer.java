package fi.tamk.tiko;

@Entity
public class Computer extends ShoppingItem {
    public String name;
    public double price;
    public CPU cpu;
    public GPU gpu;
    public PSU psu;

    public PSU getPsu() {
        return psu;
    }

    public void setPsu(PSU psu) {
        this.psu = psu;
    }

    public RAM ram;
    public HDD hdd;
    public MotherBoard motherBoard;
    public double weight;
    public OS os;
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

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Computer(String name, double price, CPU cpu, GPU gpu, PSU psu, RAM ram, HDD hdd, MotherBoard motherBoard, double weight, OS os, String picture) {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
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