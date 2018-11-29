//This is the driving class of the application
//AutoCheckout project by Psuedocode Masters
import java.util.Scanner;
import java.util.ArrayList;

public class AutoCheckout
{
 	public static void main(String args[])
 	{
  		ArrayList<Customer> customers = new ArrayList<Customer>();
  		customers.add(new Customer("12345678", 7890, 100.00, true, true));
  		customers.add(new Customer("23456789", 8902, 0.00, true, false));
  		customers.add(new Customer("34567890", 9012, 120.00, false, true));
  		customers.add(new Customer("45678901", 0123, 0.00, false, false));
  		customers.add(new Customer("", -1, 40.00, false, false));
  		
		StockManager manageStock = new StockManager();
		AuthorizationCenter aC = new AuthorizationCenter();
		CheckoutManager checkOut = new CheckoutManager(manageStock, aC);
		Timer timer = new Timer(checkOut, manageStock);
		Scanner sc = new Scanner(System.in);
		boolean close = false;
		for (int c = 0; c < customers.size(); c++)
  			aC.addCard(customers.get(c));
  		int i = 0;
		
		while(close == false) {
			
			int menuChoice = 0;
  
			System.out.println("-----Grocery Story Main Menu-----");
			System.out.println("1) To enter self checkout mode");
			System.out.println("2) To enter the Stock Manager");
			System.out.println("3) To test Timer");
			System.out.println("4) To close program");
			menuChoice = sc.nextInt();
			
			switch(menuChoice) {
					
				case 1:
					if (customers.get(i) != null)
					{	
						checkOut.CheckOutMenu(customers.get(i));
						i++;
					}
					else
						System.out.println("There are no customers in line.");
					break;
					
				case 2:
					manageStock.logIn();
					break;
					
				case 3:
					timer.test();
					break;
					
				case 4:
					close = true;
					break;
					
				default:
					System.out.println("Please input a valid option.");
			
			}
			timer.timedEvents();
		}
		//update inventory database upon close
		InventoryDatabase.writeDatabase(manageStock.getStock());	
 	}
}
