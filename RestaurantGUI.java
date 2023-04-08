package CA3_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RestaurantGUI extends JFrame
{
	private Restaurant restaurant;
	private JTextField dishField;
	private JButton orderButton;
	private JButton clearButton;
	
	public RestaurantGUI()
	{
		super("Restaurant");
		
		restaurant = new Restaurant();
		
		dishField = new JTextField(20);
		
		orderButton = new JButton("Order");
		
		clearButton = new JButton("Clear");

		JPanel input = new JPanel();
		JPanel clear = new JPanel();
		

		input.add(new JLabel("Please enter a dish"));
		input.add(dishField);
		input.add(orderButton);
		clear.add(clearButton);

		JTextArea outputA = new JTextArea(20,30);
		
		JScrollPane scrollPane = new JScrollPane(outputA);
		
		setLayout(new BorderLayout());
		
		add(input, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		
		orderButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
                String dish = dishField.getText();
                Order order = new Order(dish);
                
                restaurant.addOrder(order);
                
                outputA.append("Ordering " + dish + "...\n");
                
				Thread t = new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(10000); // Wait for 10 seconds to simulate the preparation time
							outputA.append(dish + " is ready!\n");
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				});
				t.start();

                dishField.setText("");
            }
        });
		
		clearButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) {
                outputA.setText("");
            }
        });

		add(clear, BorderLayout.SOUTH);

		pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

		
	}
	
	public static void main(String[] args) 
	{
		new RestaurantGUI();
	}

	/*
 * The RestaurantGUI program is a simple graphical user interface (GUI) 
 * for placing food orders at a restaurant. It consists of a text field
 * for entering a dish name and a button for submitting the order. 
 * 
 * When the user clicks the button, the dish name is added to a list 
 * of orders stored in a Restaurant object. 
 * 
 * The program also displays a text area that shows the order details. 
 * The user can continue toplace more orders until they close the 
 * program.
 */

}
