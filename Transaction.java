import java.util.ArrayList;
import java.util.Random;

public class Transaction {
	
	int tNum; //transaction number
	ArrayList<Item> items;
	double total;
	
	public Transaction()
	{
		items = new ArrayList<Item>();
	}

    public Transaction(ArrayList<Item> cart, double t) {
    	items = new ArrayList<Item>();
    	items = cart;
    	total = t;
    }
   
}