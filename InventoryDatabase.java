import java.util.Scanner;
import java.lang.Exception.*;
import java.util.ArrayList;
import java.io.File;

public class InventoryDatabase 
{
    public static ArrayList<Item> getDatabase() 
    {
    	ArrayList<Item>inventory = new ArrayList<Item>();
    	Scanner in; 
    	String name;
    	int id, quantity;
    	double price;
    	try
    	{	
    		in = new Scanner(new File("inventory.dat"));
    		while(in.hasNextLine())
    		{
    			name = in.nextLine();
    			quantity = in.nextInt();
    			price = in.nextDouble();
    			id = in.nextInt();
    			inventory.add(new Item(name, id, quantity, price));
    		}
    		return inventory;		
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return inventory;
    	}
    }   
}