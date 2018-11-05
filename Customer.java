/*
 * Write a class Customer which has the following private fields:
 * A String name
 * An int representing the balance (in cents) of the customer
 * A Basket containing the products the customer would like to buy.
 * 
 * The class must also have the following public methods.
 */

public class Customer {
	
	private String name;
	private int balance;
	private Basket basket_products;
	
	/* A constructor that takes as input a String indicating the name of the customer, and an int representing their initial balance. 
        * The constructor uses its inputs and creates an empty Basket to initialize the corresponding fields.*/
	public Customer(String name_of_customer, int initial_balance) {
		this.name=name_of_customer;
		this.balance = initial_balance;
		this.basket_products= new Basket();	
	}
	
	// A getName() and a getBalance() method which return the name and balance (in cents) of the customer respectively.
	public String getName(){
		return name;	
	}
	
	public int getBalance() {
		return balance;
	}
	
	// A getBasket() method which returns the reference to the Basket of this Customer (no copy of the Basket is needed).
	public Basket getBasket() {
		return basket_products;	
	}
	
	/*
	 * An addFunds() method which takes an int as input representing the amount of cents to be added to the balance of this Customer. 
        * If the input received is negative, the method should throw an IllegalArgumentException with an appropriate message. 
        * Otherwise, the method will simply update the balance and return the new balance in cents.
	 */
	public int addFunds(int amount_added_balance) {
		if(amount_added_balance >= 0) {
			balance = getBalance()+amount_added_balance;
			return balance;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	/*
	 * An addToBasket() method which takes a MarketProduct as input and adds it to the basket of this Customer. This method should not return anything.
	 */
	public void addToBasket(MarketProduct m) {
		basket_products.add(m);	
	}
	
	/*
	 * A removeFromBasket() method which takes a MarketProduct as input and removes it from the basket of this Customer. 
         * The method returns a boolean indicating whether of not the operation was successful.
	 */
	public boolean removeFromBasket(MarketProduct p) {
		if(basket_products.remove(p)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 *  A checkOut() method which takes no input and returns the receipt for the customer as a String. 
         * If this Customer’s balance is not enough to cover the total cost of their basket, then the method throws an IllegalStateException. 
         * Otherwise, this Customer is charged the total cost of the basket, the basket is cleared, and a receipt is returned.
	 */
	public String checkOut() {
		String receipt="";
		
		if(basket_products.getTotalCost() > balance) {
			throw new IllegalStateException();			
		}else {
			receipt=basket_products.toString();
			basket_products.clear();
			return receipt;
		}
		
	}

}
