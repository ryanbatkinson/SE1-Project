//This is the driving class of the application
import java.util.Scanner;

public class AutoCheckout
{
 	public static void main(String args[])
 	{
  
		StockManager manageStock = new StockManager();
		CheckoutManager checkOut = new CheckoutManager(manageStock);
		Scanner sc = new Scanner(System.in);
		boolean close = false;
		
		while(close == false){
			
			int menuChoice = 0;
  
			System.out.println("\n");
			System.out.println("-----Grocery Story Main Menu-----");
			System.out.println("1) To enter self checkout mode");
			System.out.println("2) To enter the Stock Manager");
			System.out.println("3) To close program");
			menuChoice = sc.nextInt();
			
			switch(menuChoice){
					
				case 1:
					checkOut.CheckOutMenu();
					break;
					
				case 2:
					manageStock.logIn();
					break;
					
				case 3:
					close = true;
					break;
			
			}
			
		}
		//update inventory database upon close
		InventoryDatabase.writeDatabase(manageStock.getStock());
		
 	}
}
