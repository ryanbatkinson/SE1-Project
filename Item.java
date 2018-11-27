//This is the class with the items. Each product will have a name, ID, price, and quantity. It will be put into the ArrayList.
//This way the system will keep track of the stock and how much to charge the customer for a specific item.

public class Item 
{
	String name;
	int ID, quantity;
	double price;
	boolean ageRestricted;
	
	public Item() {}

    public Item(String s, int id, int q, double p, boolean aR) 
    {
    	name = s;
    	ID = id;
    	quantity = q;
    	price = p;
    	ageRestricted = aR;
    }
	
	    public String getName() {
		
		return name;
		
	}
    
    public int getID() {
		
		return ID;
		
	}
    
    public int getQuantity() {
		
		return quantity;
		
	}
    
    public double getPrice() {
		
		return price;
		
	}
	
	public boolean getAgeRestricted()
	{
		return ageRestricted;
	}
	
	public int getWrittenAgeRestriction()
	{
		if (ageRestricted)
			return 1;
		else
			return 0;
	}
}