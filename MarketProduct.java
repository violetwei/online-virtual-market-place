/*
 * Write an abstract class MarketProduct which has the following private field: • A String name
 * The class must also have the following public methods:
 * A constructor that takes a String as input indicating the name of product and uses it to initialize the corresponding attribute.
 * A final getName() method to retrieve the name of this MarketProduct.
 * An abstract method getCost() which takes no input and returns an int. 
 *     This method should be abstract (thus, not implemented) because how to determine the cost depends on the type of product.
 * An abstract method equals() which takes an Object as an input and returns a boolean. 
 *     This method should be abstract as well, since depending on the type of product different conditions should be met in order for two products to be considered equal.
 */
public abstract class MarketProduct {
	
	private String name;
	
	// constructor  initialize corresponding attribute
	public MarketProduct(String name){
		this.name = name;	
	}
	
	//method to retrieve the name of the MarketProduct
	public final String getName() {
		return name;
	}
	
	//A method without body (no implementation) known as abstract method, only have method signature.
	// this method takes no input and returns an int.
	public abstract int getCost();
	
	public abstract boolean equals(MarketProduct m);

}
