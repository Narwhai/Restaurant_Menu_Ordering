import java.util.ArrayList;
public class Entree extends MenuItem{
	
	private ArrayList<MenuItem> entrees = new ArrayList<MenuItem>();

	//ArrayList constructor 
	public Entree(){
		populateEntreeMenu();
	}
	
	private void populateEntreeMenu() {
		entrees.add(new MenuItem("Tacos\t\t", 6.00));
		entrees.add(new MenuItem("Burrito\t\t", 7.00));
		entrees.add(new MenuItem("Rice and Beans\t", 6.00));
		entrees.add(new MenuItem("Tamales\t\t", 9.00));
		entrees.add(new MenuItem("Enchiladas\t\t", 8.00));
		entrees.add(new MenuItem("Nachos\t\t", 7.00));
		entrees.add(new MenuItem("Sandwich\t\t", 8.00));
		entrees.add(new MenuItem("Pozole\t\t", 9.00));
	}
	
	//Returns specific entrees
	public MenuItem getEntree(int index)
	{
		return entrees.get(index);
	}
	
	public int getentreesSize()
	{
		return entrees.size();
	}
	
	//Return all entrees as a String 
	public String getAllEntrees()
	{
		String dMenu = "";
		dMenu += "Entrees: \n";
		for(int i = 0; i < entrees.size(); i++)
		{
			MenuItem a = entrees.get(i);
			dMenu += "E" + (i+1) + " " + a.toString() + "\n";
		}
		return dMenu;
	}
}
