import java.util.ArrayList;
import java.util.Scanner;

public class StockManager 
{
	ArrayList<Item> stock;

    public StockManager() 
    {
    	stock = InventoryDatabase.getDatabase();
    }
    
}