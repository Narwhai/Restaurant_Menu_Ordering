
import java.util.InputMismatchException;
import java.util.Scanner;
public class Restaurant {

	public static void main(String[] args) {
		
		//Variables
		int menuChoice, choices, itemNum;
		String itemCode;
		char itemCategory;
		double amountPaid;
		Order order = new Order();	//Order is made 

		//Greeting and select which menu to display 
		Scanner input = new Scanner(System.in);
		System.out.println("Thanks for coming to my retaurant!");
		System.out.println("Would you like to view the full menu, or just a certain section of it?");
		System.out.println("1. Full Menu");
		System.out.println("2. Drinks");
		System.out.println("3. Entrees");
		System.out.println("4. Desserts");
		choices = 4;	//How many menu choices the user has 
		menuChoice = inputValidation(choices);	//Input validation function is called 
		
				
		//Displays the menu that the user chooses
		do{
		switch(menuChoice)
		{
		case 1:
		{
			displayFullMenu();
			break;
		}
		case 2:
		{
			displayDrinkMenu();
			break;
		}
		case 3:
		{
			displayEntreeMenu();
			break;
		}
		case 4:
		{
			displayDessertMenu();
			break;
		}
		case 5:
			break;
		}
		
		//Instructs the user on how to choose what they want to order 
		System.out.println("What would you like to order?");
		System.out.println("Enter the letter and number listed next to the item you would like to order: ");
		itemCode = input.next().toUpperCase();
		itemCategory = itemCode.charAt(0);
		itemNum = itemCode.charAt(1)-'0';
		
		//Reads the first character to see which item type they have selected and gets the item
		//from the corresponding ArrayList
		//The second character is the index in the ArrayList for that item
		if(itemCategory == 'B')
		{
			Drink userChoice = new Drink();
			order.addItem(userChoice.getDrink(itemNum-1));
		}
		else if(itemCategory == 'E')
		{
			Entree userChoice = new Entree();
			order.addItem(userChoice.getEntree(itemNum-1));
		}
		else if(itemCategory == 'D')
		{
			Dessert userChoice = new Dessert();
			order.addItem(userChoice.getDessert(itemNum-1));
		}
		
		//Prompts the user for input again 
		System.out.println("What would you like to order next?");
		System.out.println("1. Drinks");
		System.out.println("2. Entrees");
		System.out.println("3. Desserts");
		System.out.println("4. I'm done ordering");
		choices = 4;
		menuChoice = inputValidation(choices) +1; //+1 because now they can end their order, and the full menu isn't displayed again as an option 
		}while(menuChoice != 5);
		
		//Register class is used for checkout 
		Register CustomerOrder = new Register(order);
		
		//Prints out the users receipt and asks them for their payment method 
		System.out.println("Here is your receipt: \n" + CustomerOrder.toString());
		System.out.println("How would you like to pay?");
		System.out.println("1. Cash");
		System.out.println("2. Card");
		choices = 2;	//Only two choices for payment methods 
		menuChoice = inputValidation(choices); //input validation 
		amountPaid = paymentMethod(menuChoice, (CustomerOrder.getTotal()));
		System.out.println(CustomerOrder.checkPayment(amountPaid));
	
		System.out.println("\nThank you for visiting my restaurant!");
		System.out.println("Have a nice day!");
		input.close();
	}
	
	//Input validation function. The number of menu choices the user has is used as a parameter to check if they put in a valid option 
	public static int inputValidation(int choices)
	{
		Scanner inputScanner = new Scanner(System.in);
		int userChoice = 0;
		//Loops so that the user can give input until it is valid 
		do{
			//Prompts user for their choice number 
			System.out.println("Enter the number of your choice:");
			try
			{
				userChoice = inputScanner.nextInt();
				//Error message if they input a number that is not an answer choice 
				if(userChoice < 1 || userChoice > choices)
				{
					System.out.println("Not a valid choice, please enter one of the displayed choices: ");
				}
			}
			//If they input a non-integer, an error message is displayed 
			catch(InputMismatchException e)
			{
				System.out.println("Please enter an integer");
				inputScanner.next();		
			}
		}while(userChoice < 1 || userChoice > choices); 
		//Returns their choice 
		return userChoice;
	}

	//Displays the full menu
	public static void displayFullMenu()
	{
		Drink drinksMenu = new Drink();
		System.out.println(drinksMenu.getAllDrinks());
		Entree entreesMenu = new Entree();
		System.out.println(entreesMenu.getAllEntrees());
		Dessert dessertsMenu = new Dessert();
		System.out.println(dessertsMenu.getAllDesserts());
	}
	
	//Displays just the drink menu
	public static void displayDrinkMenu()
	{
		Drink drinksMenu = new Drink();
		System.out.println(drinksMenu.getAllDrinks());
	}
	
	//Displays just the Entree menu
	public static void displayEntreeMenu()
	{
		Entree entreesMenu = new Entree();
		System.out.println(entreesMenu.getAllEntrees());
	}
	
	//Displays just the Dessert menu
	public static void displayDessertMenu()
	{
		Dessert dessertsMenu = new Dessert();
		System.out.println(dessertsMenu.getAllDesserts());
	}
	
	//Asks the user how much cash they want to pay with, or if they want to pay card, the full balance of their order is used
	public static double paymentMethod(int menuChoice, double total)
	{	
		double amountPaid;
		if(menuChoice == 1)
		{	
			Scanner cashAmount = new Scanner(System.in);
			System.out.println("How much cash would you like to pay with?");
			amountPaid = cashAmount.nextDouble();
			return amountPaid;
		}
		//If they pay card, the full balance is charged 
		else if (menuChoice == 2)
		{
			amountPaid = total;
			return amountPaid;
		}
		return 0;
	}
}
	
	
	
	
	
	
