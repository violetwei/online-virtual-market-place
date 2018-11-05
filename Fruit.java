/*
 * Write a class Fruit derived from the MarketProduct class. 
 * 
 * The Fruit class has the following private fields:
 * A double indicating the weight in kg.
 * An int indicating the price per kg in cents.
 * 
 * The Fruit class has also the following public methods:
 * A constructor that takes as input a String with the name of the product, a double indicating the weight in kg, 
 *     and an int indicating the price per kg of such product. 
 * The constructor uses the inputs to create a MarketProduct and initialize the corresponding fields.
 * 
 * A getCost() method that takes no input and returns the cost of the product in cents.
 *    The cost is computed based on the weight and the price per kilogram. For instance, 1.25 kgs of asian pears at 530 cents per kg cost 662 cents.
 *    
 * An equals() method just like the Egg class, which matches type, name, weight and cost.
 * 
 */
public class Fruit extends MarketProduct{
	
    private double weight;
    private int price_per_kg;
    
    //constructor
    public Fruit(String name_of_product, double weight, int price) {
    	    super(name_of_product);
    	    this.weight=weight;
    	    this.price_per_kg=price;    	
    }
	
	public int getCost() {
		double cost=weight * (double)price_per_kg;
		return (int)cost;
	}
	
	public boolean equals(MarketProduct m) {
		
		boolean check_obj = m instanceof Fruit;
		
	    if(check_obj) {
		    boolean check_name = ((Fruit) m).getName().equals(this.getName());
		    boolean check_number = ((Fruit) m).weight == (this.weight);
		    boolean check_cost = ((Fruit) m).getCost() == (this.getCost());
		    boolean check_result = check_name && check_number && check_cost;
		    return check_result;
	    }else {
		    return false;
	    }
	}   
		
	

}
