import java.text.NumberFormat;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Register {
	
	//Variables
	private static final double TAX = .0825;
	private double subtotal;
	private double total;
	private NumberFormat numForm = NumberFormat.getCurrencyInstance();
	Order order = new Order();

	//Constructor
	public Register(Order order)
	{
		this.order = order;
	}
	
	
	//Assessors
	public double getSubtotal()
	{
		return subtotal;
	}
	
	public double getTotal()
	{
		return total;
	}
	
	//Calculations
	//Calculates the order subtotal 
	public double calcSubtotal()
	{
		for(int i = 0; i < order.getSize(); i++)
		{
			MenuItem item = order.getItem(i);
			subtotal += item.getPrice();
		}
		return subtotal;
	}
	
	//calculates how much tax will be chaarged 
	public double calcTax()
	{
		return subtotal*TAX;
	}
	
	//Calculates the total after tax
	public double calcTotal()
	{
		total = subtotal + calcTax();
		return total;
	}
	
	//Outputs the users receipt 
	public String toString()
	{
		String str = "\t------RECEIPT------\n";
		str+= order.toString()
		+ "\nSubtotal:\t\t" + numForm.format(calcSubtotal())
		+ "\nTax:\t\t\t" + numForm.format(calcTax())
		+"\nTotal:\t\t\t" + numForm.format(calcTotal());
		return str;
		
	}
	
	//Input validation on the users payment. Returns a message telling them if they have paid enough, or if they are receiving change
	public String checkPayment (double payment)
	{
		Scanner input = new Scanner(System.in);
		//Loops so the user can continuously give input until it is valid 
		do{
		try
		{
			//If they don't pay enough, it asks them to pay more
			if(payment < total)
			{	
				System.out.println("There is still " + numForm.format(total-payment) + " remaining");
				System.out.println("Please enter how much more you would like to pay: ");
				payment = payment + input.nextDouble();
			}
			else if (payment > total)
			{
				return "Here is your change: " + numForm.format(payment - total);
			}
		}
		//If they input a non-integer, it displays this message 
		catch(InputMismatchException e)
		{
			System.out.println("Please enter a number");
		}
		}while(payment < total);
		input.close();
		//if they pay too much after not having paid enough, it displays what their change is
		if (payment > total)
		{
			return "Here is your change: " + numForm.format(payment - total);
		}
		return "Thank you for your business!";
	}
}


