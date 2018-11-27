import java.util.HashMap;

public class AuthorizationCenter {
	
	HashMap<String, Integer> debitCards;
	HashMap<String, Integer> creditCards;

    public AuthorizationCenter() 
    {
    	cards = new HashMap<String, Integer>();
    }
    
    public void addDebitCard(String cN, int pin)
    {
    	debitCards.put(cN, pin);
    }
    
    public void addCreditCard(String cN, int pin)
    {
    	creditCards.put(cN, pin);
    }
    
}