import java.util.ArrayList;
import java.util.Scanner;

class CheckoutManager
{
	Customer customer;
	AuthorizationCenter aC;
	StockManager sm;
	Scanner inp;
	ArrayList<Transaction> transactions;
	int lastTransactionNum;

    public CheckoutManager(StockManager s, AuthorizationCenter ac)
    {
    	lastTransactionNum = 0;
    	sm = s;
    	aC = ac;
    	transactions = new ArrayList<Transaction>();
    	customer = new Customer();
    }
    
    public void setCustomer(Customer c)
    {
    	customer = c;
    }
    
    public void CheckOutMenu(Customer c) {
    	setCustomer(c);
    	int option;
		System.out.println("Welcome to Pseudocode Masters Mart.");
		
		//This would be a new transaction that will either be added to the Array list of instructions or it will be discarded if they decide to cancel transaction/get declined.
		//new Transaction;
		
		transactions.add(new Transaction());
		
		inp = new Scanner(System.in);
		
		boolean menubool = true;
		while(menubool == true) {
			System.out.println("Please select one of the following options.");
			System.out.println("1 - Scan item.");
			System.out.println("2 - Total.");
			System.out.println("3 - Checkout.");
						
			option = inp.nextInt();
			
			switch(option)
			{
			case 1: 
				scanItem();
				break;	
			case 2:
				printSubtotal();
				break;
			case 3:
				checkout();
				menubool = false;
				break;			
			default:
				System.out.println("That is not a valid input, please try again.");
			}
		}
		System.out.println("Thanks for shopping with us!");
	}
    
    public void scanItem()
    {
    	int itemNum;
		Item curItem = new Item();
		boolean existingItem = false;
		boolean validNum = true;
    	while(existingItem == false) { //find an item to purchase
			System.out.println("Enter the number of the item that you wish to add to cart.");
			printCatalogue();
			itemNum = inp.nextInt();
					
			for(int i = 0; i < sm.getStock().size(); i++) {
				if ((sm.getStock().get(i).getID()) == itemNum) {
					curItem = sm.getStock().get(i);
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
		boolean notRestricted = true;
		if (curItem.getAgeRestricted()) //determine if the item is age restricted and then check the customer's ID
			notRestricted = scanID();
			
		if (!notRestricted)
		{
			System.out.println("You are not old enough to buy this item.");
			return;
		}
		else
			System.out.println("You are approved to buy this item.");
		int q;
		do
		{
			System.out.println("Please input how many of that item that you want.");
			q = inp.nextInt();
			q = Math.abs(q);
			if (q > curItem.getQuantity())
				System.out.println("We do not have that many in stock.");
			else
			{
				Item temp = new Item(curItem);
				temp.quantity = q;
				//System.out.println("stock item q " + curItem.getQuantity());
				transactions.get(transactions.size()-1).items.add(temp);
				System.out.println("The item has been added to you cart.");
				break;
			}
		} while (q <= curItem.getQuantity());				
    }
    
    public double printSubtotal()
    {
    	double total = 0.0;
    	for (int i = 0; i < transactions.get(transactions.size()-1).items.size(); i++)
    	{
    		total += transactions.get(transactions.size()-1).items.get(i).getPrice() * transactions.get(transactions.size()-1).items.get(i).getQuantity();
    	}
    	System.out.printf("Your current total is $%.2f.\n", total);
    	return total;
    }
    
    public boolean scanID()
    {
    	return customer.getOver21();
    }
    
    public void checkout() {
    	double total = printSubtotal();
    	int num = 0;
		do
		{
			System.out.println("\n1 - Pay using Cash.");
			System.out.println("2 - Pay using Card.");
			System.out.println("3 - Cancel Transaction.");
			num = inp.nextInt();
			String temp;
			switch (num)
			{
				case 1:
					payCash(total);
					num = 3;
					break;
				case 2:
					payCard(total);
					num = 3;
					break;
				case 3:
					System.out.println("Are you sure you want to cancel this transaction? Yes or no?");
					temp = inp.next();
					temp.toLowerCase();
					if (temp.equals("yes"))
					endTransaction();
					return;
				default:
					System.out.println("Please input valid option.");
			}
		} while (num != 3);
		lastTransactionNum += 1;
		transactions.get(transactions.size()-1).tNum = lastTransactionNum;
		printReceipt();
		updateStock();
    }

    public void payCard(double t) {
		boolean paySuccess = false;
		if (customer.getCardNum() == "")
		{
			System.out.println("You don't seem to have a card on you.");
		}	
		for (int i = 0; i < 3; i++) {
			
			if (customer.debit == true) {
				System.out.println("Please input your PIN.");
				int pin = inp.nextInt();
				paySuccess = aC.checkDebit(customer.getCardNum(), pin);
			}
			else {
				paySuccess = aC.checkCredit(customer.getCardNum());
			}
			
			if (paySuccess == true) {
				System.out.println("Payment Approved");
				return;
			}
			else {
				System.out.println("Payment Declined");
				if(i == 2) {
					endTransaction();
				}	
			}
		}		
    }
    
    public void payCash(double t) {
    	boolean cancel = false;
		double moneyIn = 0;
		System.out.println("---Please insert your cash now-----");
		System.out.println("---Enter -1 at anytime to cancel---\n");
		while( (t > 0) && (cancel == false) && (customer.getcashAmount() > 0.0) ) {
			System.out.print("Insert cash: ");
			moneyIn = inp.nextDouble();
			if(moneyIn == -1) {
				cancel = true;
			}
			else {
				t -= moneyIn;
				customer.cashAmount -= moneyIn;
			}
		}
		if(!(customer.getcashAmount() > 0.0) || cancel == true)
		{
			System.out.println("You have not paid enough cash for this transaction.\nWould you like to pay the rest with a card? Yes or no?");
			String temp = inp.next();
			temp.toLowerCase();
			if (temp.equals("yes"))
				payCard(t);
			else
				endTransaction();
		}
		else {
			System.out.printf("Outputting change: $%.2f\n", Math.abs(t));
			customer.cashAmount += t;
		}
    }
    
    public void printReceipt()
    {
    	double receiptTotal = 0;

        // Retrieves last transaction in ArrayList transactions
        Transaction lastTrans = transactions.get(transactions.size()-1);
        System.out.printf("%-15s %8s %8s\n", "Item", "Quantity", "Item Total");
        for (int i = 0; i < lastTrans.items.size(); i++)
        {
            double itemTotal = (lastTrans.items.get(i).getQuantity() * lastTrans.items.get(i).getPrice());
            System.out.printf("%-15s %8s $%8.2f\n", lastTrans.items.get(i).getName(), lastTrans.items.get(i).getQuantity(), itemTotal);
            receiptTotal += itemTotal;
        }
        System.out.printf("\nTransaction Total: $%.2f\n", receiptTotal);
    }
    
    public void transactionReport()
    {
        double transTotal = 0;

        // Loops through all transactions in ArrayList transactions
        for (int i = 0; i < transactions.size(); i++)
        {
            // Loops through all items in a single transaction
            for (int j = 0; j < transactions.get(i).items.size(); j++)
            {
                double receiptTotal = (transactions.get(i).items.get(j).getQuantity() * transactions.get(i).items.get(j).getPrice());

                System.out.println("Item Name: " + transactions.get(i).items.get(j).getName());
                System.out.println("Amount Bought: " + transactions.get(i).items.get(j).getQuantity());

                transTotal += receiptTotal;
            }
        }
        System.out.printf("Total from All Transactions: $%.2f\n", transTotal);
    }
    
	public void endTransaction() 
	{
    	transactions.remove(transactions.size()-1);
    	System.out.println("The transaction has been ended.");
    }
    
    public void updateStock()
    {
    	Transaction lastTrans = transactions.get(transactions.size()-1);
    	ArrayList<Item> stock = sm.getStock();
    	for (int i = 0; i < stock.size(); i++)
    	{
			for (int j = 0; j < lastTrans.items.size(); j++)
			{
				if (stock.get(i).getID() == lastTrans.items.get(j).getID())
				{
					//System.out.println("Subtracting " + lastTrans.items.get(j).getQuantity() + "from stock " + stock.get(i).quantity);
					stock.get(i).quantity -= lastTrans.items.get(j).getQuantity();
				}
			}
		}
    }
    
    public void printCatalogue()
    {
    	sm.viewInventory();
    }
    
}