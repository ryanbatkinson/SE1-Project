 

public class Manager {

   	int EmplID;
	String Name;
	
	public Manager(String name, int emplID) {
		Name = name;
		EmplID = emplID;
	}
	
	public int getEmplID(){
		
		return this.emplID;
		
	}
	
	public String getName(){
		
		return this.Name;
		
	}
	
    
}