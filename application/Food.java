// Name: Katelyn Peterson
// Class: CIS 2571-001 Fall 2015
// Instructor: Mohammad Morovati
// Date: Dec. 11th, 2015
// Prologue:  This class holds foodName and charge.

package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * <h1> Food </h1> 
 * The Food class includes the food name and the cost of the food.
 * 
 * @author Katelyn Peterson
 * @version 1.0
 * @since 12-11-2015 
 *
 */

public class Food 
{
	// Private Variables
	private StringProperty foodName = new SimpleStringProperty();
	private DoubleProperty foodCharge = new SimpleDoubleProperty();
	
	// Constructors
	// Default
	// Function: public Food()
	// Parameters:  none - default
	// Returns:		 Constructor
					
	/**
	  * This is the default constructor for the Food class.
	  */
	public Food()
	{
		setName(" ");
		setCharge(0.00);
	}
	
	// All Information
	// Function: public Food(String foodNam, double foodCost)
	// Parameters:  foodNam - name of the Food
	//						 foodCost - cost of the Food
	// Returns:		 Constructor
						
	/**
	  * This is the full constructor for the Food class.
	  * @param foodNam  This is the name of the Food.
	  * @param foodCost  This is the cost of the Food.
	  */
	public Food(String foodNam, double foodCost)
	{
		setName(foodNam);
		setCharge(foodCost);
	}
	
	// Partial Constructors
	// Function: public Food(String foodNam)
	// Parameters:  foodNam - name of the Food
	// Returns:		 Constructor
						
	/**
	  * This is a partial constructor for the Food class.
	  * @param foodNam  This is the name of the Food.
	  */
	public Food(String foodNam)
	{
		setName(foodNam);
		setCharge(0.00);
	}
	
	// Getters
	// Function: public String getName()
	// Parameters:  none
	// Returns:		 foodName - name of the Food
								
	/**
	  * This function retrieves the Food's name.
	  * @return foodName - This is the name of the Food.
	  */
	public String getName()
	{
		return foodName.get();
	}
	
	// Function: public Double getCharge()
	// Parameters:  none
	// Returns:		 foodCharge - cost of the Food
								
	/**
	  * This function retrieves the Food's cost.
	  * @return foodCharge - This is the cost of the Food.
	  */
	public Double getCharge()
	{
		return foodCharge.get();
	}
	
	// Setters
	// Function: public void setName(String foodNam)
	// Parameters:  foodNam - name of the Food
	// Returns:		 zero
									
	/**
	  * This function sets the Food's name.
	  * @param foodNam  This is the name of the Food.
	  */
	public void setName(String foodNam)
	{
		foodName.set(foodNam);
	}
	
	// Function: public void setCharge(double foodCost)
	// Parameters:  foodCost - cost of the Food
	// Returns:		 zero
									
	/**
	  * This function sets the Food's cost.
	  * @param foodCost  This is the cost of the Food.
	  */
	public void setCharge(double foodCost)
	{
		if (foodCost > 0) 
		{
			foodCharge.set(foodCost);
		}
		else
		{
			foodCharge.set(0.00);
		}
	}
	
	// Properties
	// Function: public StringProperty foodNameProperty()
	// Parameters:  none
	// Returns:		 foodName - name of the Food
									
	/**
	  * This function retrieves the Property for the Food's name.
	  * @return foodName - This is the name of the Food.
	  */
	public StringProperty foodNameProperty()
	{
		return foodName;
	}
	
	// Function: public StringProperty foodNameProperty()
	// Parameters:  none
	// Returns:		 foodCharge - cost of the Food
									
	/**
	  * This function retrieves the Property for the Food's name.
	  * @return foodCharge - This is the cost of the Food.
	  */
	public DoubleProperty foodChargeProperty()
	{
		return foodCharge;
	}
	
	// Other Functions
	// equals()
	// Function: public boolean equals(Object x)
	// Parameters:  x - the object being compared to the calling Food
	// Returns:		 true or false
						
	/**
	  * This is the override of Object's equals() function.
	  * @param x  This is the Object being compared to the calling Food.
	  * @return true - This tells the calling Food that the Object is equal to it.
	  * @return false - This tells the calling Food that the Object is not equal to it.
	  */
	public boolean equals(Object x)
	{
		if (x instanceof Food)
		{
			if (foodName == ((Food)x).foodName &
					foodCharge == ((Food)x).foodCharge)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return this == x;
		}
	} 
	
	// toString
	// Function: public String toString()
	// Parameters:  none
	// Returns:		 String
						
	/**
	  * This is the override of Object's toString() function.
	  * @return String - This is the printout of all of the calling Food's values.
	  */
	public String toString()
	{					
		return "Food Name: " + foodName.get() + "\n" + 
				"Cost: " + String.format("$%1$,.2f", foodCharge.get());
	}
}
