import java.util.ArrayList;
import java.util.Random;

class Customer {
	String cardNum;
	ArrayList<Item> cart;
	int PIN;
	double cashAmount;
	boolean debit;
	
	public Customer(String cN, ArrayList<Item> c, int PIN, double cA, boolean d)
	{
		cardNum = cN;
		cart = c;
		PIN = null;
		cashAmount = cA;
		debit = d;
	}
	
	public String getCardNum(){
		if((this.cardNum).equals(null)){
			return null;
		}
		else{
			return this.cardNum;
		}
	}
	
	public int getPIN(){
		return this.PIN;
	}
	
	public double getcashAmount(){
		return this.cashAmount;
	}
	
	public boolean getDebit(){
		return this.debit;
	}
	
	public Customer(ArrayList<Item> c, double cA) //no card contructor
	{
		cardNum = null;
		cart = c;
		PIN = null;
		cashAmount = cA;
		debit = false;
	}
	
	public Customer(String cN, int PIN, double cA, boolean d) //contructor for random cart
	{
		cardNum = cN;
		//cart = genCart();
		PIN = null;
		cashAmount = cA;
		debit = d;
	}
	
<<<<<<< HEAD
	public ArrayList<Item> genCart()
=======
	public ArrayList<Item> getCart()
>>>>>>> baaeef34933b2868a98c7a763008fb7401306470
	{
		return this.cart;
	}
}