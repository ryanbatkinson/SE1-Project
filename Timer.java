import java.util.ArrayList;
import java.time.*;

public class Timer {
	
	LocalTime time;
	CheckoutManager cm;
	StockManager sm;

    public Timer(CheckoutManager c, StockManager m)
    {
    	time = LocalTime.now("CST");
    	cm = c;
    	sm = s;
    }
    
    public void getTime() {
		time = LocalTime.now("CST");
	}
	
	public boolean checkMidnight()
	{
		getTime();
		int hour = time.getHour();
		int minute;
		if (hour == 0)
		{
			minute = time.getMinute();
				if (minute <= 10) //if it is within 5 minutes of midnight
				return true;
		}
		else
			return false;
		return false;
	}
	
	public void timedEvents() {
		if (checkMidnight())
		{
			ArrayList<Item> allSold = cm.generateDailyReport();
			sm.updateStockFromReport(allSold);
			printInventoryReport();
		}
	}
	
	public void printInvertoryReport() { 
		sm.checkLowStock();
	} 
}