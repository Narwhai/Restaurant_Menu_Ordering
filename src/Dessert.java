import java.util.ArrayList;
public class Dessert extends MenuItem{
	
	private ArrayList<MenuItem> desserts = new ArrayList<MenuItem>();

	//Populates the ArrayList 
	public Dessert(){
		populateDessertMenu();
	}
	
	private void populateDessertMenu() {
		desserts.add(new MenuItem("Ice Cream\t\t", 2.00));
		desserts.add(new MenuItem("Cake\t\t\t", 4.00));
		desserts.add(new MenuItem("Brownie\t\t", 3.00));
		desserts.add(new MenuItem("Pie\t\t\t", 3.00));
		desserts.add(new MenuItem("Cheesecake\t\t", 4.00));
	}
	
	//Returns specific desserts
	public MenuItem getDessert(int index)
	{
		return desserts.get(index);
	}
	
	public int getdessertsSize()
	{
		return desserts.size();
	}
	
	//Return all desserts as a String 
	public String getAllDesserts()
	{
		String dMenu = "";
		dMenu += "Desserts: \n";
		for(int i = 0; i < desserts.size(); i++)
		{
			MenuItem a = desserts.get(i);
			dMenu += "D" + (i+1) + " " + a.toString() + "\n";
		}
		return dMenu;
	}
}
