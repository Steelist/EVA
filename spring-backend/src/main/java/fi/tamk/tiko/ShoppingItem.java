package fi.tamk.tiko;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShoppingItem{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String tags;
    
    private int quantity;

	public ShoppingItem(){
		
	}
	public ShoppingItem(String tags, int quantity){
		this.tags=tags;
                this.quantity=quantity;
	}
        public ShoppingItem(String tags){
		this.tags=tags;
	}
	public long getId(){
		return id;
	}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

      
        
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    @Override
    public String toString() {
        return "{"+"\"ID\": "+this.id+"}";
    }
}