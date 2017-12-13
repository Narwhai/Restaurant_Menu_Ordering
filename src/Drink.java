import java.util.ArrayList;
public class Drink extends MenuItem{
	
	private ArrayList<MenuItem> drinks = new ArrayList<MenuItem>();

	//Default constructor for the ArrayList
	public Drink(){
		populateDrinkMenu();
	}
	
	private void populateDrinkMenu() {
		//Water
		drinks.add(new MenuItem("Water\t\t", 1.00));
		//Soda Flavors
		drinks.add(new MenuItem("Dr. Pepper\t\t", 1.25));
		drinks.add(new MenuItem("Coke\t\t\t", 1.25));
		drinks.add(new MenuItem("Diet Coke\t\t", 1.25));
		drinks.add(new MenuItem("Sprite\t\t", 1.25));
		drinks.add(new MenuItem("Fanta Orange\t\t", 1.25));
	}
	
	//Returns specific drinks
	public MenuItem getDrink(int index)
	{
		return drinks.get(index);
	}
	
	public int getDrinksSize()
	{
		return drinks.size();
	}
	
	//Return all drinks as a String 
	public String getAllDrinks()
	{
		String dMenu = "";
		dMenu += "Drinks: \n";
		for(int i = 0; i < drinks.size(); i++)
		{
			MenuItem a = drinks.get(i);
			dMenu += "B" + (i+1) + " " + a.toString() + "\n";
		}
		return dMenu;
	}
}
