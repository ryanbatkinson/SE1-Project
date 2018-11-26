import java.util.ArrayList;
import java.util.Random;

public class Transaction {
	
	int tNum; //transaction number
	ArrayList<Items> items;
	double total

    public Transaction(ArrayList<Items>cart, double t) {
    	items = cart;
    	total = t;
    }
    
    
}