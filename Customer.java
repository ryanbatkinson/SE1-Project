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
	
	ArrayList<Item> getCart()
	{
		return
	}
}