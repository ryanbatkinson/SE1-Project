

public class Cashier {

    public Cashier() {
    	
    }
    
    int EmplID;
	String Name;
	
	public Cashier(String name, int emplID) {
		Name = name;
		EmplID = emplID;
	}
	
	public int getEmplID(){
		
		return this.EmplID;
		
	}
	
	public String getName(){
		
		return this.Name;
		
	}
	
	
	public void startCheckout(Customer name) {
		
	}
	
	public void scanItem(String itemID) {
		
	}
	
	public void scanID(String StringID, int idNum) {
		
	}
	
	public void cancelCheckout(boolean end) {
		
	}
    
}