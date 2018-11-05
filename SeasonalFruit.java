/*
 * Write a class SeasonalFruit derived from the Fruit class. 
 * 
 * The SeasonalFruit class has no fields, but it has the following public methods:
 * A constructor that takes as input a String with the name of the product, a double indicating the weight in kg, 
 *     and an int indicating the price per kg of such product. The constructor uses the inputs to create a Fruit.
 *     
 * A getCost() method that takes no input and returns the cost of the product in cents. 
 * Since this type of Fruit is in season, its original cost should receive a 15% discount. For instance, 0.5 kgs of McIntosh apples at 480 cents per kg cost 204 cents.
 */
public class SeasonalFruit extends Fruit{
	
	//constructor
	public SeasonalFruit(String name_of_product, double weight, int price_per_kg) {
		super(name_of_product, weight, price_per_kg);
	}
	
	public int getCost() {
		double cost = super.getCost() * 0.85;
		return (int)cost;
	}	
		

}
