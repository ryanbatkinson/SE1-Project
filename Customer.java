import java.util.ArrayList;
import java.util.Random;

class Customer {
	String cardNum;
	ArrayList<Item> cart;
	int PIN;
	double cashAmount;
	boolean debit;
	
	public Customer(String cN, ArrayList<Item> c, int pin, double cA, boolean d)
	{
		cardNum = cN;
		cart = c;
		PIN = pin;
		cashAmount = cA;
		debit = d;
	}
	
	public Customer(ArrayList<Item> c, double cA) //no card contructor
	{
		cardNum = null;
		cart = c;
		PIN = -1;
		cashAmount = cA;
		debit = false;
	}
	
	public Customer(String cN, int PIN, double cA, boolean d) //contructor for random cart
	{
		cardNum = cN;
		//cart = genCart();
		PIN = -1;
		cashAmount = cA;
		debit = d;
	}
	
	public ArrayList<Item> makeRandomCart()
	{
		ArrayList<Item> rCart = new ArrayList<Item>();
		return rCart;
	}
}