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
	public ShoppingItem(){
		
	}
	
	public long getId(){
		return id;
	}

    @Override
    public String toString() {
        return "{"+"\"ID\": "+this.id+"}";
    }
}