import java.util.ArrayList;
import java.util.Scanner;

public class StockManager 
{
	ArrayList<Item> Stock;

    public StockManager() 
    {
    	Stock = InventoryDatabase.getDatabase();
    }
	
	public void checkLowStock() {
		
		System.out.println("The following items have low stock:");
		for (int i = 0; i < Stock.size(); i++) {
			if ((Stock.get(i)).getQuantity() < 10) {
				
				System.out.printf((Stock.get(i)).getName() + "s: %d\n", (Stock.get(i)).getQuantity());
			}
		}
		System.out.println("----------");
	}
	
	
	public void viewInventory() {
		System.out.println("Entire Inventory:");
		System.out.printf("%4s %10s %10s %10s\n", "ID#", "ITEM", "QUANTITY", "PRICE" );
		for (int i = 0; i < Stock.size(); i++) {
			
			System.out.printf("%4d %10s %10d %10.2f\n", (Stock.get(i)).getID(), (Stock.get(i)).getName(), (Stock.get(i)).getQuantity(), (Stock.get(i)).getPrice() );

		}
		System.out.println("----------");
		
	}
	
	public void addNewStock(){
	
		Scanner intSc = new Scanner(System.in);
		Scanner dubSc = new Scanner(System.in);
		Scanner strSc = new Scanner(System.in);
		int tempID = 0;
		String tempName = "";
		double tempPrice = 0.00;
		tempQuantity = 0;
		System.out.println("\nEnter new item data below or Enter 999 for any value to cancel adding Stock");
		System.out.printf("Item Name: ");
		tempName = strSc.nextLine();
		System.out.printf("Item Price: ");
		tempPrice = dubSc.nextDouble();
		System.out.printf("Item Quantity: ");
		tempQuantity = intSc.nextInt();
		tempID = (Stock.size()) + 1;
		
		if (tempName == "999" || tempPrice == 999.00 || tempQuantity == 999){
			
			System.out.println("Add Stock Cancelled: Code 999");
			
			
		}
		else{
			Item tempItem = new Item( tempName, tempID, tempQuantity, tempPrice );
			Stock.add(tempItem);
			System.out.println("Item added successfully");
			System.out.println("Returning to Menu\n----------\n");
			
		}
		
	
	}
	
	public void stockMenu() {
		Boolean exit = false;
		Scanner sc = new Scanner(System.in);
		int actionChoice = 0;
		
		System.out.println("Stock Manager Menu");
		System.out.println("----------");
		while(exit == false) {

			System.out.println("Please Select an Action");
			System.out.println("1) View Inventory");
			System.out.println("2) Check Low Stock");
			System.out.println("3) Add New Item to Inventory");
			System.out.println("4) Exit Stock Manager");
			
			actionChoice = sc.nextInt();
			System.out.println("----------");
		
			switch(actionChoice)
			{

			case 1:
				this.viewInventory();
				break;
				
			case 2:
				this.checkLowStock();
				break;
				
			case 3:
				this.addNewStock();
				break;
				
			case 4:
				exit = true;
				System.out.println("Thank you for using the Stock Manager!");
				break;
				
			default: 
				System.out.println("Invalid Action --- Returning to Menu\n\n");
				break;
				
			}
		
		}
	}
	
	public void logIn() {
		Scanner logInSc = new Scanner(System.in);
		String userName = "stockMan";
		String passWord = "stockPass";
		String tempUName;
		String tempPWord;
		
		System.out.println("Please Enter Your Username and Password below:");
		System.out.println("Username: ");
		tempUName = logInSc.nextLine();
		System.out.println("Password: ");
		tempPWord = logInSc.nextLine();
		
		if (tempUName.equals(userName) && tempPWord.equals(passWord)) {
			System.out.println("Log In Successful\n\n");
			this.stockMenu();
		}
		else {
			System.out.println("Invalid Username or Password");
			System.out.println("Returning to Main Menu\n\n");
		}
	}
    
}