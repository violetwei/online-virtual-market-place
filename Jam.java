/*
 * Write a class Jam derived from the MarketProduct class. The Jam class has the following private fields:
 * An int indicating the number of jars.
 * An int indicating the price per jar in cents.
 * 
 * The Jam class has also the following public methods:
 * A constructor that takes as input a String with the name of the product, an int indicating the number of jars, 
 *     and an int indicating the price per jar of such product. 
 * The constructor uses the inputs to create a MarketProduct and initialize the corresponding fields.
 * 
 * A getCost() method that takes no input and returns the cost of the product in cents. 
 *    The cost is computed based on the number of jars and their price. For instance, 2 jars of Strawberry jam at 475 cents per jar cost 950 cents.
 *    
 * An equals() method like in the previous classes. which takes as input an Object and return true if input matches this in type, name, cost and number of eggs. 
 *    Otherwise the method returns false.
 * 
 */
public class Jam extends MarketProduct{
	
	private int num_of_jars;
	private int price_per_jar;
	
	public Jam(String name_of_product, int number_of_jars, int price_per_jar) {
		super(name_of_product);
		this.num_of_jars=number_of_jars;
		this.price_per_jar=price_per_jar;	
	}

	public int getCost() {
		return num_of_jars * price_per_jar;
	}

	public boolean equals(MarketProduct m) {
		
		boolean check_obj = m instanceof Jam;
		
		if(check_obj) {
			boolean check_name = ((Jam) m).getName().equals(this.getName());
			boolean check_number = ((Jam) m).num_of_jars == (this.num_of_jars);
			boolean check_cost = ((Jam) m).getCost() == (this.getCost());
			boolean check_result = check_name && check_number && check_cost;
			return check_result;
		}else {
			return false;
		}
		
	}

}
