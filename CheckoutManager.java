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

    public CheckoutManager(StockManager s)
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
			System.out.println("3 - Checkout.");
						
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
    
    public double printSubtotal()
    {
    	double total = 0.0;
    	for (int i = 0; i < transactions.get(transactions.size()-1); i++)
    	{
    		total += transaction.get(transactios.size()-1).get(i).getPrice() * transaction.get(transactios.size()-1).get(i).getQuantity();
    	}
    	System.out.printf("Your current total is $f.2.", total);
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
			System.out.println("1 - Pay using Card.");
			System.out.println("2 - Pay using Cash.");
			System.out.println("3 - Cancel Transaction.");
			num = inp.nextInt();
			switch (num)
			{
				case 1:
					payCash(total);
					break;
				case 2:
					payCard(total);
					break;
				case 3:
					endTransaction();
					break;
				default:
					System.out.println("Please input valid option.");
			} while (num != 3);
		}
    }

    public void payCard(double t) {
		boolean paySuccess = false;
		for(int i = 0; i < 3; i++){
			
			if (customer.debit == true){
				paySuccess = AuthorizationCenter.checkDebit(customer.cardNum, customer.PIN);
			}
			else{
				paySuccess = AuthorizationCenter.checkCredit(customer.cardNum);
			}
			
			if (paySuccess == true){
				System.out.println("Payment Approved");
				return;
			}
			else{
				System.out.println("Payment Declined");
				if(i == 2){
					endTransaction();
				}
				
			}
		}
		
		
    }
    
    public void payCash(double t) {
    	boolean cancel = false;
		double moneyIn = 0;
		
		System.out.println("---Enter -1 at anytime to cancel---");
		while( (t > 0) && (cancel == false) ){
			System.out.printf("Insert cash: ");
			moneyIn = inp.nextDouble();
			if(moneyIn == -1){
				cancel = true;
			}
			else{
				t -= moneyIn;
			}
		}
		if (cancel == true){
			endTransaction();
		}
		else{
			System.out.println("Outputting change: %f.2", t)
		}
		
			
    }
    
    public void getAuthorization() {
    	
    }
    
    public void printReceipt()
    {
    	double receiptTotal = 0;

        // Retrieves last transaction in ArrayList transactions
        Transaction lastTrans = transactions.get(transactions.size()-1);
        for (int i = 0; i < size(lastTrans.items); i++)
        {
            double itemTotal = (lastTrans.items[i].quantity * lastTrans.items[i].price);
            System.out.printf("%15s %14s %8s", "Item", "Amount Bought", "Item Total");
            System.out.printf("%15s %14s %8.2f", lastTrans.items[i].name, lastTrans.items[i].quantity, itemTotal);

            receiptTotal += itemTotal;
        }
        System.out.println("Transaction Total: " + receiptTotal);
    }
    
    public void transactionReport()
    {
        double transTotal = 0;

        // Loops through all transactions in ArrayList transactions
        for (int i = 0; i < size(transactions); i++)
        {
            // Loops through all items in a single transaction
            for (int j = 0; j < size(transactions[i].items); j++)
            {
                double receiptTotal = (transactions[i].items[j].quantity * transactions[i].items[j].price);

                System.out.println("Item Name: " + transactions[i].items[j].name);
                System.out.println("Amount Bought: " + transactions[i].items[j].quantity);

                transTotal += receiptTotal;
            }
        }
        System.out.println("Total from All Transactions: " + transTotal);
    }
    
    public void promptPayment() {
    	
    }
    
    public void takeCash() {
    	
    }
    
	public void endTransaction() 
	{
    	
    }
    
    public void printCatalogue()
    {
    	sm.viewInventory();
    }
    
}