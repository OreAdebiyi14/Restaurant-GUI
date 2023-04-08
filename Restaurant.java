package CA3_1;

import java.util.ArrayList;

public class Restaurant 
{
	/*
 * This restaurant class has 3 instance variables 
 * - arraylist called orders to store orders
 * - 2 objects of type chef and waiter which 
 * represent the chef and waiter in the restaurant
 * 
 * The constructor initializes the orders arraylist and creates 
 * a new instance of chef and waiter  waiter while 
 * passing the restaurant object as a parameter.
 * 
 * the addOrder method adds an Order object to the orders Arraylist
 * 
 * the getOrder method removes the first order in the Order array list 
 * and returns it. If the arrayList is empty it will return null
 * 
 * the start method calls the start method of both the chef and waiter objects
 * which will start their threads
 * 
 * the main method creates a restaurant object and add several Order 
 * objects to it. Then calls the start method on the restaurant object
 * which starts the chef and waiter threads to begin processing the 
 * orders
 * 
 * 
 * 
 */

	private ArrayList<Order> orders;//to store orders and the methods to add and get orders
	private Chef chef;//chef instance
    private Waiter waiter;//waiter instance
	
	public Restaurant()
	{
		orders = new ArrayList<Order>();
		chef = new Chef(this);
		waiter = new Waiter(this);
	}
	
	public void addOrder(Order order)
	{
		try 
		{
			orders.add(order);
		} catch (Exception e) 
		{
			System.out.println("An error occurred while adding the order: " + e.getMessage());
		}
	}
	
	public Order getOrder()
	{
		if(!orders.isEmpty())
		{
			return orders.remove(0);
		}
		return null;
	}
	
	public void start()
	{
		chef.start();
		waiter.start();
	}
	
	public static void main(String[] args) 
	{
		/*
		 * created a restaurant object and added some orders to it
		 * them call the start method of the restaurant object to start
		 * both chef and waiter threads
		 */
		Restaurant restaurant = new Restaurant();
		
		restaurant.addOrder(new Order("Pasta...\n"));
		restaurant.addOrder(new Order("Burger...\n"));
		restaurant.addOrder(new Order("Salad...\n"));
		restaurant.addOrder(new Order("Soup...\n"));
		
		restaurant.start();

	}

}
