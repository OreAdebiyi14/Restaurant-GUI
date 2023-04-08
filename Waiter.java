package CA3_1;

public class Waiter extends Thread
{
/*
 * The Waiter class is a thread that represents a waiter at a restaurant. 
 * When the run() method is called, the Waiter thread continuously 
 * checks for orders in the Restaurant object's list of orders. 
 * 
 * If there is an order, the Waiter thread orders the meal by printing
 * a message. 
 * 
 * Then, it waits for the Chef thread to notify it that 
 * the meal is ready using the wait() method in a synchronized block.
 *  
 * When it receives the notification, it serves the meal by printing 
 * another message. 
 * 
 * The Waiter thread keeps looping until there are 
 * no more orders in the list.
 */

	private Restaurant restaurant;
	
	public Waiter(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	
	public void run()
	{
		/*
		 * This method loops through all orders in the Restaurant arrayList
		 * for each order
		 * - it orders the meal
		 * - then waits for the chef thread to notify that the meal is ready 
		 * using the wait() method in the synchronized block
		 * - after being notified it serves the meal
		 */
		while(true)
		{
			Order order = restaurant.getOrder();
			if (order == null)
			{
				break;
			}
			
			System.out.print("Ordering " + order.getName());
			
			synchronized (restaurant) {
                try {
                    restaurant.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Serving " + order.getName());
		}
	}
	
	
	
}

