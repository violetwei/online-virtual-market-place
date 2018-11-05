
public class Test2 {
	static Egg egg = new Egg("GoodEgg",30,200);
	static Jam CherryJam = new Jam("Cherry Jam",10,500);
	static Jam BerryJam = new Jam("Berry Jam",10,500);
	static Fruit Apple = new Fruit("Apple",1.25,530);
	static Fruit Pear = new Fruit("Pear",15,165);
	static Fruit Peach = new Fruit("Peach",15,185);
	static SeasonalFruit Durian = new SeasonalFruit("Durian",15,200);
	static SeasonalFruit Banana = new SeasonalFruit("Banana",15,140);
	static Fruit BadFruit = new Fruit("Bad Fruit",100,0);
	static Customer Fiona = new Customer("Fiona",1000);
	static Customer Stephy = new Customer("Stephy",800);
	
	public static void main(String[] args) {
		Fiona.addFunds(100000000);
		//Stephy.addFunds(-20);
		
		System.out.println(Fiona.getName()+" "+Fiona.getBalance());
		System.out.println(Stephy.getName()+" "+Stephy.getBalance());
		System.out.println(" ");
		
		Fiona.addToBasket(egg);
		Fiona.addToBasket(Apple);
		Fiona.addToBasket(Durian);
		Fiona.addToBasket(Banana);
		Fiona.addToBasket(CherryJam);
		Fiona.addToBasket(BerryJam);
		Fiona.addToBasket(Peach);
		Fiona.removeFromBasket(Apple);
		Fiona.addToBasket(Pear);
		Fiona.addToBasket(BadFruit);
		
		System.out.println(Fiona.getBasket().getSubTotal());
		System.out.println(Fiona.getBasket().getTotalCost());
		//System.out.println(Fiona.removeFromBasket(BerryJam));
		//System.out.println(Fiona.removeFromBasket(Apple));
		System.out.println(Fiona.checkOut());
	}

}
