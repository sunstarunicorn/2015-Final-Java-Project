// Name: Katelyn Peterson
// Class: CIS 2571-001 Fall 2015
// Instructor: Mohammad Morovati
// Date: Dec. 9th, 2015
// Prologue:  This class controls the Java application for running the restaurant ordering system.

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * <h1> OrderController </h1> 
 * The OrderController class controls the Java application that runs Last Chance Diner's order system.
 * 
 * @author Katelyn Peterson
 * @version 1.0
 * @since 12-9-2015 
 *
 */

public class OrderController 
{
	// Private Variables
	private Table [] tables = new Table[10];
	private Food [] drinks = new Food[6];
	private Food [] starters = new Food[7];
	private Food [] meals = new Food[9];
	private Food [] treats = new Food[5];
	private Bill orderBill;
	
	// FXML Variables
    @FXML // fx:id="waiterSelect"
    private TextField waiterSelect; // Value injected by FXMLLoader
    @FXML // fx:id="allTreats"
    private ListView<String> allTreats; // Value injected by FXMLLoader
    @FXML // fx:id="totalBill"
    private TextField totalBill; // Value injected by FXMLLoader
    @FXML // fx:id="allMeals"
    private ListView<String> allMeals; // Value injected by FXMLLoader
    @FXML // fx:id="startersChoice"
    private ComboBox<String> startersChoice; // Value injected by FXMLLoader
    @FXML // fx:id="treatChoice"
    private ComboBox<String> treatsChoice; // Value injected by FXMLLoader
    @FXML // fx:id="taxTotal"
    private TextField taxTotal; // Value injected by FXMLLoader
    @FXML // fx:id="waiterName"
    private TextField waiterName; // Value injected by FXMLLoader
    @FXML // fx:id="dinerLogo"
    private ImageView dinerLogo; // Value injected by FXMLLoader
    @FXML // fx:id="clearBillButton"
    private Button clearBillButton; // Value injected by FXMLLoader
    @FXML // fx:id="tableNumber"
    private TextField tableNumber; // Value injected by FXMLLoader
    @FXML // fx:id="drinksChoice"
    private ComboBox<String> drinksChoice; // Value injected by FXMLLoader
    @FXML // fx:id="allDrinks"
    private ListView<String> allDrinks; // Value injected by FXMLLoader
    @FXML // fx:id="tableSelect"
    private TextField tableSelect; // Value injected by FXMLLoader
    @FXML // fx:id="subtotal"
    private TextField subtotal; // Value injected by FXMLLoader
    @FXML // fx:id="allStarters"
    private ListView<String> allStarters; // Value injected by FXMLLoader
    @FXML // fx:id="mealChoice"
    private ComboBox<String> mealsChoice; // Value injected by FXMLLoader
    
    // Controller Functions
    // Function: private void changeTable(ActionEvent event)
    // Parameters:  event - Enter key
    // Returns:		 zero
 									
    /**
      * This function controls the Table Number textfield.
      * @param event - This is the action when the Enter key is pressed for Table Number.
      */
    @FXML
    private void changeTable(ActionEvent event) 
    {
    	// 1. Variables
    	int tableNum;    	
    	
    	// 2. Input    	
    	// Reset Bill
    	clearBill(event);
    	
    	// Table select
    	try
    	{
    		tableNum = Integer.parseInt(tableSelect.getText());
    		
    		tableNum = tableNum - 1;
    		
    		if (tableNum >= 0 && tableNum < 10)
    		{
    			// 3. Calculation
    			if (tables[tableNum].getWaiter() == " ")
    			{
    				// 4. Output
    				waiterSelect.setDisable(false);
    				drinksChoice.setDisable(true);
    				startersChoice.setDisable(true);
    				mealsChoice.setDisable(true);
    				treatsChoice.setDisable(true);
    				subtotal.setDisable(true);
    				taxTotal.setDisable(true);
    				totalBill.setDisable(true);
    				waiterName.setDisable(true);
    				tableNumber.setDisable(false);
    				clearBillButton.setDisable(true);
    				allDrinks.setDisable(true);
    				allStarters.setDisable(true);
    				allMeals.setDisable(true);
    				allTreats.setDisable(true);
    				
    				waiterSelect.setText(null);
    				tableNumber.setText(Integer.toString((tableNum + 1)));
    				waiterName.setText(tables[tableNum].getWaiter());
    				subtotal.setText(null);
    				taxTotal.setText(null);
    				totalBill.setText(null);
    			}
    			else
    			{
    				waiterSelect.setDisable(false);
    				drinksChoice.setDisable(false);
    				startersChoice.setDisable(false);
    				mealsChoice.setDisable(false);
    				treatsChoice.setDisable(false);
    				subtotal.setDisable(false);
    				taxTotal.setDisable(false);
    				totalBill.setDisable(false);
    				waiterName.setDisable(false);
    				tableNumber.setDisable(false);
    				clearBillButton.setDisable(false);
    				allDrinks.setDisable(false);
    				allStarters.setDisable(false);
    				allMeals.setDisable(false);
    				allTreats.setDisable(false);
    				
    				waiterSelect.setText(tables[tableNum].getWaiter());
    				tableNumber.setText(Integer.toString((tableNum + 1)));
    				waiterName.setText(tables[tableNum].getWaiter());
    				subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
    				taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
    				totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
    			}
    		}
    		else
    		{
    			tableSelect.setText(null);
    			
        		waiterSelect.setDisable(true);
    			drinksChoice.setDisable(true);
    			startersChoice.setDisable(true);
    			mealsChoice.setDisable(true);
    			treatsChoice.setDisable(true);
    			subtotal.setDisable(true);
    			taxTotal.setDisable(true);
    			totalBill.setDisable(true);
    			waiterName.setDisable(true);
    			tableNumber.setDisable(true);
    			clearBillButton.setDisable(true);
    			allDrinks.setDisable(true);
    			allStarters.setDisable(true);
    			allMeals.setDisable(true);
    			allTreats.setDisable(true);
    			
    			waiterSelect.setText(null);
    			tableNumber.setText(null);
    			waiterName.setText(null);
    			subtotal.setText(null);
    			taxTotal.setText(null);
    			totalBill.setText(null);
    		}    		
    	}
    	catch (Exception e)
    	{
    		tableSelect.setText(null);
    		
    		waiterSelect.setDisable(true);
			drinksChoice.setDisable(true);
			startersChoice.setDisable(true);
			mealsChoice.setDisable(true);
			treatsChoice.setDisable(true);
			subtotal.setDisable(true);
			taxTotal.setDisable(true);
			totalBill.setDisable(true);
			waiterName.setDisable(true);
			tableNumber.setDisable(true);
			clearBillButton.setDisable(true);
			allDrinks.setDisable(true);
			allStarters.setDisable(true);
			allMeals.setDisable(true);
			allTreats.setDisable(true);
			
			waiterSelect.setText(null);
			tableNumber.setText(null);
			waiterName.setText(null);
			subtotal.setText(null);
			taxTotal.setText(null);
			totalBill.setText(null);
    	}    	
    }
    
    // Function: private void changeWaiter(ActionEvent event)
    // Parameters:  event - Enter key
    // Returns:		 zero
 									
    /**
      * This function controls the Waiter's Name textfield.
      * @param event - This is the action when the Enter key is pressed for Waiter's Name.
      */
    @FXML
    private void changeWaiter(ActionEvent event) 
    {
    	// 1. Variables
    	int tableNum;
    	
    	// 2. Input
    	tableNum = Integer.parseInt(tableSelect.getText());
    	
    	tableNum = tableNum - 1;
    	
		if (tableNum >= 0 && tableNum < 10)
		{
			// 3. Calculation
			tables[tableNum].setWaiter(waiterSelect.getText());
									
			// 4. Output
			drinksChoice.setDisable(false);
			startersChoice.setDisable(false);
			mealsChoice.setDisable(false);
			treatsChoice.setDisable(false);
			subtotal.setDisable(false);
			taxTotal.setDisable(false);
			totalBill.setDisable(false);
			waiterName.setDisable(false);
			clearBillButton.setDisable(false);
			allDrinks.setDisable(false);
			allStarters.setDisable(false);
			allMeals.setDisable(false);
			allTreats.setDisable(false);
			
			waiterName.setText(tables[tableNum].getWaiter());
			subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
			taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
			totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
		}
    }
    
    // Function: private void chooseDrink(ActionEvent event)
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Drinks combo-box.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Drinks combo-box.
      */
    @FXML
    private void chooseDrink(ActionEvent event) 
    {
    	// 1. Variables
    	String choice;
    	
    	// 2. Input
    	choice = drinksChoice.getValue();
    	
    	// 3. Calculation 
    	for (int x = 0; x < drinks.length; x++)
    	{
    		if (choice == drinks[x].getName())
    		{
    			allDrinks.getItems().add(drinks[x].getName());
    			orderBill.credit(drinks[x].getCharge());
    			
    			// 4. Output
    			subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
    			taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
    			totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
    		}
    	}    	
    	
    	//drinksChoice.setValue(drinksChoice.getPromptText());
    }
    
    // Function: private void chooseStarters(ActionEvent event)
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Starters combo-box.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Starters combo-box.
      */
    @FXML
    private void chooseStarters(ActionEvent event) 
    {
    	// 1. Variables
    	String choice;
    	
    	// 2. Input
    	choice = startersChoice.getValue();
    	
    	// 3. Calculation 
    	for (int x = 0; x < starters.length; x++)
    	{
    		if (choice == starters[x].getName())
    		{
    			allStarters.getItems().add(starters[x].getName());
    			orderBill.credit(starters[x].getCharge());
    			
    			// 4. Output
    			subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
    			taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
    			totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
    		}
    	}
    }
    
    // Function: private void chooseMeal(ActionEvent event) 
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Meals combo-box.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Meals combo-box.
      */
    @FXML
    private void chooseMeal(ActionEvent event) 
    {
    	// 1. Variables
    	String choice;
    	
    	// 2. Input
    	choice = mealsChoice.getValue();
    	
    	// 3. Calculation 
    	for (int x = 0; x < meals.length; x++)
    	{
    		if (choice == meals[x].getName())
    		{
    			allMeals.getItems().add(meals[x].getName());
    			orderBill.credit(meals[x].getCharge());
    			
    			// 4. Output
    			subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
    			taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
    			totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
    		}
    	}
    }
    
    // Function: private void chooseTreat(ActionEvent event)
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Treats combo-box.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Treats combo-box.
      */
    @FXML
    private void chooseTreat(ActionEvent event) 
    {
    	// 1. Variables
    	String choice;
    	
    	// 2. Input
    	choice = treatsChoice.getValue();
    	
    	// 3. Calculation 
    	for (int x = 0; x < treats.length; x++)
    	{
    		if (choice == treats[x].getName())
    		{
    			allTreats.getItems().add(treats[x].getName());
    			orderBill.credit(treats[x].getCharge());
    			
    			// 4. Output
    			subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
    			taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
    			totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
    		}
    	}
    }
    
    // Function: private void clearBill(ActionEvent event) 
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Clear Bill button.
      * @param event - This is the action when the Left Mouse Button is clicked on the Clear Bill button.
      */
    @FXML
    private void clearBill(ActionEvent event) 
    {
    	// 1. Variables - none for this function
    	
    	// 2. Input - none for this function
    	
    	// 3. Calculation & 4. Output
    	allDrinks.getItems().clear();
    	allStarters.getItems().clear();
    	allMeals.getItems().clear();
    	allTreats.getItems().clear();    	
    	
    	orderBill.debit(orderBill.getSubtotal());
    	subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
		taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
		totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
    }
    
    // Function: private void removeDrink(MouseEvent event) 
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Beverages Ordered List View.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Beverages Ordered List View box.
      */
    @FXML
    private void removeDrink(MouseEvent event) 
    {
    	// 1. Variables
    	String choice;
    	int remove;
    	
    	if (!allDrinks.getItems().isEmpty()) 
    	{
			// 2. Input
			remove = allDrinks.getSelectionModel().getSelectedIndex();
			// TEST
			//System.out.println("Testing remove");
			// TEST
			choice = allDrinks.getItems().get(remove);
			// TEST
			//System.out.println("Testing choice");
			// TEST

			// 3. Calculation
			for (int x = 0; x < drinks.length; x++)
			{
				if (choice == drinks[x].getName())
				{
					allDrinks.getItems().remove(remove);
					orderBill.debit(drinks[x].getCharge());
					
					// 4. Output
					subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
					taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
					totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
				}
			}
		}  	
    }
    
    // Function: private void removeStarter(MouseEvent event) 
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Appetizers Ordered List View.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Appetizers Ordered List View box.
      */
    @FXML
    private void removeStarter(MouseEvent event) 
    {
    	// 1. Variables
    	String choice;
    	int remove;
    	
    	if (!allStarters.getItems().isEmpty()) 
    	{
			// 2. Input
			remove = allStarters.getSelectionModel().getSelectedIndex();
			// TEST
			//System.out.println("Testing remove");
			// TEST
			choice = allStarters.getItems().get(remove);
			// TEST
			//System.out.println("Testing choice");
			// TEST

			// 3. Calculation
			for (int x = 0; x < starters.length; x++)
			{
				if (choice == starters[x].getName())
				{
					allStarters.getItems().remove(remove);
					orderBill.debit(starters[x].getCharge());
					
					// 4. Output
					subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
					taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
					totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
				}
			}
		}
    }
    
    // Function: private void removeMeal(MouseEvent event)
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Main Courses Ordered List View.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Main Courses Ordered List View box.
      */
    @FXML
    private void removeMeal(MouseEvent event) 
    {
    	// 1. Variables
    	String choice;
    	int remove;
    	
    	if (!allMeals.getItems().isEmpty()) 
    	{
			// 2. Input
			remove = allMeals.getSelectionModel().getSelectedIndex();
			// TEST
			//System.out.println("Testing remove");
			// TEST
			choice = allMeals.getItems().get(remove);
			// TEST
			//System.out.println("Testing choice");
			// TEST

			// 3. Calculation
			for (int x = 0; x < meals.length; x++)
			{
				if (choice == meals[x].getName())
				{
					allMeals.getItems().remove(remove);
					orderBill.debit(meals[x].getCharge());
					
					// 4. Output
					subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
					taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
					totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
				}
			}
		}
    }
    
    // Function: private void removeTreat(MouseEvent event)
    // Parameters:  event - Left Mouse Button
    // Returns:		 zero
 									
    /**
      * This function controls the Desserts Ordered List View.
      * @param event - This is the action when the Left Mouse Button is clicked on an item in the Desserts Ordered List View box.
      */
    @FXML
    private void removeTreat(MouseEvent event) 
    {
    	// 1. Variables
    	String choice;
    	int remove;
    	
    	if (!allTreats.getItems().isEmpty()) 
    	{
			// 2. Input
			remove = allTreats.getSelectionModel().getSelectedIndex();
			// TEST
			//System.out.println("Testing remove");
			// TEST
			choice = allTreats.getItems().get(remove);
			// TEST
			//System.out.println("Testing choice");
			// TEST

			// 3. Calculation
			for (int x = 0; x < treats.length; x++)
			{
				if (choice == treats[x].getName())
				{
					allTreats.getItems().remove(remove);
					orderBill.debit(treats[x].getCharge());
					
					// 4. Output
					subtotal.setText(String.format("$%1$,.2f", orderBill.getSubtotal()));
					taxTotal.setText(String.format("$%1$,.2f", orderBill.getTax()));
					totalBill.setText(String.format("$%1$,.2f", orderBill.getTotal()));
				}
			}
		}
    }
    
    // Initialization
    // Function: public void initialize()
    // Parameters:  none
    // Returns:		 zero
  									
    /**
      * This function initializes the Tables, Foods, and the Bill for the application.
      */
    public void initialize()
     {  
    	// Drinks    	
    	drinksChoice.getItems().addAll("Soda", "Tea", "Coffee", "Mineral Water", "Juice", "Milk");
    	drinks[0] = new Food("Soda", 1.95);
    	drinks[1] = new Food("Tea", 1.50);
    	drinks[2] = new Food("Coffee", 1.25);
    	drinks[3] = new Food("Mineral Water", 2.95);
    	drinks[4] = new Food("Juice", 2.50);
    	drinks[5] = new Food("Milk", 1.50);
    	
    	// Starters
    	startersChoice.getItems().addAll("Buffalo Wings", "Buffalo Fingers", "Potato Skins", "Nacjos", "Mushroom Caps", "Shrimp Cocktail",
    			"Chips and Salsa");
    	starters[0] = new Food("Buffalo Wings", 5.95);
    	starters[1] = new Food("Buffalo Fingers", 6.95);
    	starters[2] = new Food("Potato Skins", 8.95);
    	starters[3] = new Food("Nacjos", 8.95);
    	starters[4] = new Food("Mushroom Caps", 10.95);
    	starters[5] = new Food("Shrimp Cocktail", 12.95);
    	starters[6] = new Food("Chips and Salsa", 6.95);
    	
    	// Meal
    	mealsChoice.getItems().addAll("Seafood Alfredo", "Chicken Alfredo", "Chicken Picatta", "Turkey Club", "Lobster Pie", 
    			"Prime Rib", "Shrimp Scampi", "Turkey Dinner", "Stuffed Chicken");
    	meals[0] = new Food("Seafood Alfredo", 15.95);
    	meals[1] = new Food("Chicken Alfredo", 13.95);
    	meals[2] = new Food("Chicken Picatta", 13.95);
    	meals[3] = new Food("Turkey Club", 11.95);
    	meals[4] = new Food("Lobster Pie", 19.95);
    	meals[5] = new Food("Prime Rib", 20.95);
    	meals[6] = new Food("Shrimp Scampi", 18.95);
    	meals[7] = new Food("Turkey Dinner", 13.95);
    	meals[8] = new Food("Stuffed Chicken", 14.95);
    	
    	// Treats
    	treatsChoice.getItems().addAll("Apple Pie", "Sundae", "Carrot Cake", "Mud Pie", "Apple Crisp");
    	treats[0] = new Food("Apple Pie", 5.95);
    	treats[1] = new Food("Sundae", 3.95);
    	treats[2] = new Food("Carrot Cake", 5.95);
    	treats[3] = new Food("Mud Pie", 4.95);
    	treats[4] = new Food("Apple Crisp", 5.95);
    	
    	// Bill
    	orderBill = new Bill(5.00);
    	
    	// Table
    	for (int x = 0; x < 10; x++)
    	{
    		tables[x] = new Table((x + 1));
    	} 
     }
}