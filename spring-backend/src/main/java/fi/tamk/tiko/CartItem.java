package fi.tamk.tiko;

public class CartItem{
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CartItem(long id) {
        this.id = id;
    }
    public CartItem(){

    }
}