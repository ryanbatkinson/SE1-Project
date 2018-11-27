import java.util.HashMap;

public class AuthorizationCenter {
	
	HashMap<String, Integer> debitCards;
	HashMap<String, Integer> creditCards;

    public AuthorizationCenter() 
    {
    	debitCards = new HashMap<String, Integer>();
    	creditCards = new HashMap<String, Integer>();
    }
    
    public void addDebitCard(String cN, int pin)
    {
    	debitCards.put(cN, pin);
    }
    
    public void addCreditCard(String cN, int pin)
    {
    	creditCards.put(cN, pin);
    }
    
	
	public boolean checkDebit(String cN, int pin){
		
		if (debitCards.containsKey(cN)){
			if (debitCards.get(cN) == pin){
				return true;
			}
			else{
				System.out.println("Invalid PIN number");
				return false;
			}
		}
		else{
			System.out.println("Invalid Card Number");
			return false;
		}
		
	}
	
	public boolean checkCredit(String cN){
		
		if (creditCards.containsKey(cN)){
			return true;
		}
		else{
			System.out.println("Invalid Card Number");
			return false;
		}
		
	}
}