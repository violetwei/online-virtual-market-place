/*
 * Write a class Egg derived from the MarketProduct class. 
 * 
 * The Egg class has the following private fields:
 * An int indicating the number of eggs.
 * An int indicating the price per dozen of these eggs. 
 * Note that the all the prices (throughout the assignment) are indicated in cents. For instance, 450 represents the amount $4.50.
 * 
 * The Egg class has also the following public methods:
 * A constructor that takes as input a String with the name of the product, an int indicating the number required, 
 *     and an int indicating the price of such product by the dozen. 
 * The constructor uses the inputs to create a MarketProduct and initialize the corresponding fields. 
 */
public class Egg extends MarketProduct{
	private int number_of_eggs;
	private int price_per_dozen_eggs;
	
	public Egg(String name_of_product, int num_required, int price_by_dozen){
		super(name_of_product); //invoke the constructor of the superclass MarketProduct()
		this.number_of_eggs = num_required; //initialize the instance field number_of_eggs
		this.price_per_dozen_eggs = price_by_dozen;		
	}
	
   /* A getCost() method that takes no input and returns the cost of the product in cents.
	* The cost is computed base on the number required and the cost per dozen. For instance, 4 large brown eggs at 380 cents/dozen cost 126 cents
	* (the cost should be rounded down to the nearest cent). You may assume that cost of all MarketProducts fits within an int and therefore doesn’t cause overflow.
	*/ 
	public int getCost() {
		double result=(double)number_of_eggs * (double)((double)price_per_dozen_eggs/12);
		return (int)result;	
	}
	
	/* An equals() method which takes as input an Object and return true if input matches this in type, name, cost and number of eggs. 
     * Otherwise the method returns false.
	 */
	public boolean equals(MarketProduct m) {
		
		boolean check_obj = m instanceof Egg;
		
		if(check_obj) {
			boolean check_name = ((Egg) m).getName().equals(this.getName());
			boolean check_number = ((Egg) m).number_of_eggs == (this.number_of_eggs);
			boolean check_cost = ((Egg) m).getCost() == (this.getCost());
			boolean check_result = check_name && check_number && check_cost;
			return check_result;
		}else {
			return false;
		}
		
	}

}
