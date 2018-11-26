import java.util.Scanner;
import java.lang.Exception.*;
import java.util.ArrayList;
import java.io.*;

public class InventoryDatabase 
{
    public static ArrayList<Item> getDatabase() 
    {
    	ArrayList<Item>inventory = new ArrayList<Item>();
    	BufferedReader in; 
    	String name, line;
    	int id, quantity;
    	double price;
    	boolean age;
    	try
    	{	
    		in = new BufferedReader(new FileReader(new File("inventory.dat")));
    		while((line = in.readLine()) != null)
    		{
    			System.out.println(line);
    			int temp = line.indexOf(" ");
    			name = line.substring(0,temp);
    			line = line.substring(temp+1, line.length());
    			temp = line.indexOf(" ");
    			quantity = Integer.parseInt(line.substring(0,temp));
    			line = line.substring(temp+1, line.length());
    			temp = line.indexOf(" ");
    			price = Double.parseDouble(line.substring(0,temp));
    			line = line.substring(temp+1, line.length());
    			temp = line.indexOf(" ");
    			id = Integer.parseInt(line.substring(0,temp));
    			line = line.substring(temp+1, line.length());
    			if (Integer.parseInt(line) == 1)
    				age = true;
    			else
    				age = false;
    			inventory.add(new Item(name, id, quantity, price, age));
    		}
    		return inventory;		
    	}
    	catch(Exception e)
    	{
    		System.out.println("An error occured reading the database.");
    		return inventory;
    	}
    }   
}