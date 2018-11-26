import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class CheckoutManager
{
	static ArrayList<Transaction> transactions;
	static Customer customer;
	static Cashier cashier;

    public static boolean checkout(Customer c, Cashier ch, CheckoutManager cm)
    {
    	customer = c;
    	cashier = ch;
    	System.out.println("------------------------------------");
    	System.out.println("Hello! Welcome to the self checkout. \nYou may begin scanning items.");
    	for (int c = 0; c < customer.cart.size(); c++) //start scanning items from 
    	{
    		
    	}
    }
    
    public static void payCard(String cardNum, double amount, boolean debit)
    {
    	
    }
  
  	public static void payCash(double amount)
  	{
  		
  	}
  	
  	public static void takeCash()
  	{
  		
  	}
  	
  	public static promptPayment()
  	{
  		
  	}
  	
  	public void endTransaction() //print reciept and display total
  	{
  		
  	}
  	
  	public void printReciept()
    {
    	
    }
    
    public void transactionReport() //Use the classes attribute to make a report
    {
    	
    }
  
}