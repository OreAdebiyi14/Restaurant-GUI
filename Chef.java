package CA3_1;

public class Chef extends Thread
{
	private Restaurant restaurant;
	
	public Chef(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	
	public void run()
	{
		/*
		 * this methid loops through all orders in the restaurant arraylist
		 * for each order
		 *  - gives a preparation time for the chef cooking the food
		 *  - then notifies the restaurant object theat the food is ready
		 *  - in the synchronized using the notify()
		 */
		while(true)
		{
			Order order = restaurant.getOrder();
			if(order == null)
			{
				break;
			}
			System.out.print("Preparing "+ order.getName());
			
			try {
                Thread.sleep(5000); // create a meal waiting time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (restaurant) {
                restaurant.notify();
            }
		}
	}
/*
 * this is the chef class that extends the thread class, used to 
 * simulate a chef working in a restaurant.
 * 
 * the constructor that takes an instance of the Restaurant class 
 * as a parameter. 
 * 
 * The run() method of the Chef class is the method that is executed 
 * when the thread starts running.
 * 
 * In the run() method, the Chef loops through all the orders in the 
 * restaurant's array list of orders, and for each order, the Chef 
 * prepares the meal by simulating a cooking time using the 
 * Thread.sleep() method.
 * 
 * After the meal is prepared, the Chef notifies the Restaurant object 
 * that the meal is ready using the notify() method in the 
 * synchronized block.
 */


}

