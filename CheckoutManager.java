import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class CheckoutManager
{
	Customer customer;
	Cashier cashier;
	StockManager sm;
	Scanner inp;
	ArrayList<Transaction> transactions;
	int lastTransactionNum;

    public CheckoutManager(s)
    {
    	lastTransactionNum = 0;
    	sm = s;
    	transactions = new ArrayList<Transaction>();
    }
    
    public void setCustomer(Customer c)
    {
    	customer = c;
    }
    
    public void CheckOutMenu() {
		System.out.println("Welcome to Pseudocode Masters Mart.");
		
		//This would be a new transaction that will either be added to the Array list of instructions or it will be discarded if they decide to cancel transaction/get declined.
		//new Transaction;
		
		transaction.add(new Transaction());
		
		inp = new Scanner(System.in);
		
		boolean menubool = true;
		while(menubool == true) {
			System.out.println("Please select one of the following options.");
			System.out.println("1 - Scan item.");
			System.out.println("2 - Total.");
			System.out.println("3 - Pay.");
						
			inp1 = inp.nextInt();
			
			switch(inp1)
			{
				case 1: 
				scanItem();
				break;
		
			
			case 2:
				printSubtotal();
				break;
			
			case 3:
				checkout();
				break;			
			default:
				System.out.println("That is not a valid input, please try again.");
		
			}
		}
	}
    
    
  
    public void checkout() {
    	System.out.println("1 - Pay using Card.");
		System.out.println("2 - Pay using Cash.");
		System.out.println("3 - Cancel Transaction.");
		
		num = inp.nextInt();
		
		if(num == 1) {
			//We need to get the card from the customer, add that to their Customer class, and then prompt the bank to respond to their amount total.		
			}
		else if (num == 2) {
			//We will take the money that the user has, and if it is sufficient, we will give them their change and push the current transaction to the ArrayList of transactions.
			//If it is not sufficient, we will return their money and ask if they want to pay with a card. If not, we will delete the current transaction and exit the menu.
		}
		else if (num == 3) {
			
		}
    }
    
    public void scanItem()
    {
    	int inp1, itemNum;
		String itm;
		Item curItem;
		boolean existingItem = false;
		boolean validNum = true;
    	while(existingItem == false) {
		System.out.println("Enter the number of the item that you wish to add to cart.");
		printCatalogue();
		item = inp.nextInt();
				
		for(int i = 0; i < stock.size(); i++) {
			if ((stock.get(i).getID()) == item) {
				curItem = stock.get(i);
				existingItem = true;
			}
		}
			
		if (existingItem == true) {
			System.out.println("We found the item you are trying to purchase.");
		}
		else {
			System.out.println("There seems to be an issue finding the item that you entered. Please try again.");
		}
	}
	
		boolean notRestricted;
		if (curItem.getAgeRestircted())
			notRestricted = scanID();
			
		if (!notRestricted)
		{
			System.out.println("You are not old enough to buy this item.");
			return;
		}
		
		do
		{
			System.out.println("Please input how many of that item that you want.");
			int q = inp.nextInt();
			q = Math.abs(q);
			if (q > curItem.getQuantity())
				System.out.println("We do not have that many in stock");
			else
			{
				Item temp = curItem;
				temp.quantity = q;
				transaction.get(transaction.size()-1).add(temp);
				System.out.println("The item has been added to you cart.");
			}
		} while (q <= curItem.getQuantity());				
    }
    
    public boolean scanID()
    {
    	
    }

    public void payCard() {
	
    }
    
    public void payCash() {
    	
    }
    
    //give items a bool for alcohol or not. 
    public void getAuthorization() {
    	
    }
    
    public void printReciept() {
    	
    }
    
    public void transactionReport() {
    	
    }
    
    public void promptPayment() {
    	
    }
    
    public void takeCash() {
    	
    }
    
	public void endTransaction() {
    	
    }
    
    public void printCatalogue()
    {
    	sm.viewInventory();
    }
    
}