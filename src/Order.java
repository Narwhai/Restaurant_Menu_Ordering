import java.util.ArrayList;
public class Order extends MenuItem{
	
	//An ArrayList of their completed order 
	private ArrayList<MenuItem> order = new ArrayList<MenuItem>();
	
	public Order(){}

	//Gets a specific item from the ArrayList
	public MenuItem getItem(int index)
	{
		return order.get(index);
	}
	
	//Returns ArrayList Size 
	public int getSize(){return order.size();}
	
	//Adds an item to the ArrayList
	public void addItem(MenuItem item){order.add(item);}
	
	//Displays the full order 
	public String toString()
	{
		String str = "";
		for(int i = 0; i < order.size(); i++)
		{
			str += order.get(i).toString() + "\n";
		}
		return str;
	}
	

}
