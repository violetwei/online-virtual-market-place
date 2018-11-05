public class Basket{
	
	//Write a class Basket which has the following private field: An array of MarketProducts.
	private MarketProduct[] products;
	
	//A constructor that takes no inputs and initialize the field with an empty array.
	public Basket() {
		this.products=new MarketProduct[0];	
	}
	
	/*A getProducts() method which takes no inputs and returns a shallow copy of the array 
	 * (NOT a copy of the reference!) of MarketProducts of this Basket (with the elements in the same order).
	 */  
	public MarketProduct[] getProducts() {
		MarketProduct[] shallow_copy = new MarketProduct[this.products.length];
		for(int i=0; i<this.products.length; i++) {
			shallow_copy[i]=this.products[i];
		}
		return shallow_copy;
	}
	
	// An add() method which takes as input a MarketProduct and does not return any value. 
	// The method adds the MarketProduct at the end of the list of products of this Basket.
	public void add(MarketProduct m) {
		
		if(this.products.length == 0) {
			this.products = new MarketProduct[1];
			this.products[0] = m;
		}else {
			MarketProduct[] newProducts = new MarketProduct[this.products.length + 1];
			
			for(int i = 0; i < this.products.length; i++) {
				newProducts[i] = this.products[i];
			}
			
			newProducts[this.products.length] = m;
			this.products = newProducts;
		}

	}
	
	/* A remove() method which takes as input a MarketProduct and returns a boolean. 
	 * The method removes the first occurrence of the specified element from the array of products of this Basket. 
     * If no such product exists, then the method returns false, otherwise, after removing it, the method returns true. 
     * Note that this method removes a product from the list if and only if such product is equal to the input received. 
     * For example, it is not possible to remove 0.25 Kg of McIntosh apples for a 0.5 Kg McIntosh apples MarketProduct. 
     * After the product has been remove from the array, the subsequent elements should be shifted down by one position, leaving no empty slot in the array. 
	 */ 
	public boolean remove(MarketProduct p) {
		int i;
		for(i=0; i < getNumOfProducts(); i++) {
			if(products[i].equals(p)) {
				//products[i]=products[i+1];
				MarketProduct[] newProducts = new MarketProduct[this.products.length - 1];
				for(int j=0; j < i; j++) {
					newProducts[j] = this.products[j];
				}
				while(i < (getNumOfProducts()-1)) {
					newProducts[i]=products[i+1];
					i++;
				}
				this.products=newProducts;
				return true;
			}else {
				
			}
		}
		return false;	
	}	
	
	// A clear() method which takes no inputs, returns no values, and empties the array of products of this Basket.
	public void clear() {
		products = new MarketProduct[0];
	}
	
	//A getNumOfProducts() method that takes no inputs and returns the number of products present in this Basket.
	public int getNumOfProducts() {
		int counter=0;
		for(int i=0; i<products.length; i++) {
			if(products[i].equals(null)) {
				break;
			}else {
				counter++;
			}
		}
		return counter;
	}
	
	// A getSubTotal() method that takes no inputs and returns the cost (in cents) of all the products in this Basket.
	public int getSubTotal() {
		
		int i = getNumOfProducts();
		int total_cost=0;
		
		for(int j=0; j<i; j++) {
			total_cost += products[j].getCost();	
		}
		
		return total_cost;
	}
	
   /* A getTotalTax() method that takes no inputs and returns the tax amount (in cents) to be paid based on the product in this Basket. 
    * Since we are in Quebec, you can use a tax rate of 15%. The tax amount should be rounded down to the nearest cent. 
	* Note that Egg and Fruit are tax free, so taxes should be paid only for Jam.
	*/
	public int getTotalTax() {
		double tax_amount = 0;
		for(int i=0; i<getNumOfProducts(); i++) {
			if( products[i] instanceof Jam ) {
				tax_amount += products[i].getCost() * 0.15;			
			}else {
				tax_amount += 0;		
          	}
		}
		return (int)tax_amount;
	}
	
	// A getTotalCost() method that takes no inputs and returns the total cost (in cents and after tax) of the products in this Basket.
	public int getTotalCost() {
		return getSubTotal() + getTotalTax();
	}
	
	/*A toString() method that returns a String representing a receipt for this Basket. 
	 * The receipt should contain a product per line. On each line the name of the product should appear, followed by its price separated by a tab character. 
	 * After all the products have been listed, the following information should appear on each line:
     * An empty line
     * The subtotal cost 
     * The total tax
     * An empty line
     * The total cost
     * 
     * Note that all the integer number of cents should be transformed into a String formatted in dollars and cents (you can write a helper method to do so if you’d like). 
     * If the number of cents is represented by an int that is less than or equal to 0, then it should be transformed into a String containing only the hyphen character ("-"). 
     * An example of a receipt is as follows:
         Quail eggs  4.00
         McIntosh apples 6.12
         Asian Pears 4.24
         Blueberry Jam 4.75
         
         Subtotal    23.86
         Total Tax   0.71
         
         Total Cost 24.57 
     */
	
	// this is a helper method to transform integer input to a string formatted number with 2 decimal points.
	private String formatted(int input_num) {
		int integer_part = input_num/100;
		int decimal_part = input_num - 100*integer_part;
		if(decimal_part<10) {
			return integer_part + ".0" + decimal_part;
		}else {
			return integer_part + "." +decimal_part;
		}
		
	}
	public String toString() {
		String receipt="";
		for(int i=0; i<getNumOfProducts(); i++) {
			receipt+=products[i].getName() + " " + formatted(products[i].getCost()) + "\n";
		}
		receipt += "\nSubtotal " + formatted(getSubTotal()) + "\n" + "Total Tax " + formatted(getTotalTax()) + "\n";
		receipt += "\nTotal Cost " + formatted(getTotalCost());
		
		return receipt;
	}

}
