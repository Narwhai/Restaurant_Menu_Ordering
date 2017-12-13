import java.text.NumberFormat;
public class MenuItem {

	//Variables
	private double price;
	private String name; 
	NumberFormat numForm = NumberFormat.getCurrencyInstance();
	
	//Default constructor 
	public MenuItem(){	}
	
	//Constructor 
	public MenuItem(String name, double price)
	{
		this.name = name;
		this.price = price;	
	}
	
	//Assessors and mutators
	public double getPrice(){return price;}
	public void setPrice(double price){ this.price = price;}
	public String getName(){ return name;}
	public void setName(String name){this.name = name;}

	public String toString(){
		return name + "\t" + numForm.format(price);
	}
	
}

	