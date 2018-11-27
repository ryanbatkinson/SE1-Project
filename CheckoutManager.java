import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class CheckoutManager
{
	//ArrayList<Item> cart;
	ArrayList<Item> stock;
	Customer customer;
	Cashier cashier;

    public CheckoutManager(Customer c)
    {
    	customer = c;
    }
    
    public void CheckOutMenu() {
		System.out.println("Welcome to Pseudocode Masters Mart.");
		
		//This would be a new transaction that will either be added to the Array list of instructions or it will be discarded if they decide to cancel transaction/get declined.
		//new Transaction;
		
		Scanner inp = new Scanner(System.in);
		int inp1, itemNum;
		String itm;
		Item curItem;
		boolean existingItem = false;
		boolean validNum = true;
		
		boolean menubool = true;
		while(menubool == true) {
			System.out.println("Please select one of the following options.");
			System.out.println("1 - Scan item.");
			System.out.println("2 - Total.");
			
			inp1 = inp.nextInt();
			
			if(imp1 == 1) {
				//we need to get the item/quantity and add that to their running total in their Transaction.
				
				while(existingItem == false) {
					System.out.println("Enter the name of the item that you wish to add to cart.");
					itm = inp.next();
				
					for(int i = 0; i < stock.size(); i++) {
						if (((stock.get(i)).getName()).equals(itm)) {
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
				
				
				if (curItem.ageRestricted == false) {
					while(validNum == true) {
						System.out.println("Enter the number that you have in your cart.");
						itemNum = inp.nextInt();
					
						if (curItem.getQuantity() >= itemNum) {
							// here we need to add the item(s) to the cart and keep the updated stock to save after the transaction is done.
							System.out.println("The items were added to your cart.");
						}
					}
				}
				else {
					//Here is the part were the employee must enter their ID to give the person permition to buy the item.
					if (/*permision == true*/) {
						while(validNum == true) {
							System.out.println("Enter the number that you have in your cart.");
							itemNum = inp.nextInt();
						
							if (curItem.getQuantity() >= itemNum) {
								// here we need to add the item(s) to the cart and keep the updated stock to save after the transaction is done.
								System.out.println("The items were added to your cart.");
							}
						}
					}
					else {
						System.out.println("The item was not added becuase you are not of age to purchase this item.");
					}
				}
				
			}
			
			else if (num == 2) {
				//Here we need to go into the .checkout() method.
			}
			
			else {
				System.out.println("That is not a valid input, please try again.");
				menubool = true;
			}
		}
	}
    
    public void printReciept() {
    	
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

    public void payCard() {
	
    }
    
    public void payCash() {
    	
    }
    
    //give items a bool for alcohol or not. 
    public void getAuthorization() {
    	
    }
    
    public void transactionReport() {
    	
    }
    
    public void promptPayment() {
    	
    }
    
    public void takeCash() {
    	
    }
    
	public void endTransaction() {
    	
    }
    
}