// Name: Katelyn Peterson
// Class: CIS 2571-001 Fall 2015
// Instructor: Mohammad Morovati
// Date: Dec. 11th, 2015
// Prologue:  This class holds tableNum and waiter.

package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * <h1> Table </h1> 
 * The Table class includes the Table Number and Waiter Name.
 * 
 * @author Katelyn Peterson
 * @version 1.0
 * @since 12-11-2015 
 *
 */

public class Table 
{
	// Private Variables
	private IntegerProperty tableNum = new SimpleIntegerProperty();
	private StringProperty waiter = new SimpleStringProperty();
	
	// Constructors
	// Default
	// Function: public Table()
	// Parameters:  none - default
	// Returns:		 Constructor
					
	/**
	  * This is the default constructor for the Table class.
	  */
	public Table()
	{
		setTableNum(1);
		setWaiter(" ");
	}
	
	// All Information
	// Function: public Table(int tableNumber, String waiterName)
	// Parameters:  tableNumber - number of the Table
	//						 waiterName - waiter assigned to the Table
	// Returns:		 Constructor
						
	/**
	  * This is the full constructor for the Table class.
	  * @param tableNumber  This is the number of the Table.
	  * @param waiterName  This is the name of the waiter assigned to the Table. 
	  */
	public Table(int tableNumber, String waiterName)
	{
		setTableNum(tableNumber);
		setWaiter(waiterName);
	}
	
	// Partial Constructors
	// Function: public Table(int tableNumber)
	// Parameters:  tableNumber - number of the Table
	// Returns:		 Constructor
						
	/**
	  * This is a partial constructor for the Table class.
	  * @param tableNumber  This is the number of the Table.
	  */
	public Table(int tableNumber)
	{
		setTableNum(tableNumber);
		setWaiter(" ");
	}
	
	// Getters
	// Function: public int getTableNum()
	// Parameters:  none
	// Returns:		 tableNumber - number of the Table
								
	/**
	  * This function retrieves the Table's number.
	  * @return tableNum - This is the number of the Table.
	  */
	public int getTableNum()
	{
		return tableNum.get();
	}
	
	// Function: public String getWaiter()
	// Parameters:  none
	// Returns:		 waiterName - waiter assigned to the Table
								
	/**
	  * This function retrieves the name of the Table's waiter.
	  * @return waiter - This is the name of the waiter assigned to the Table.
	  */
	public String getWaiter()
	{
		return waiter.get();
	}	
	
	// Setters
	// Function: public void setTableNum(int tableNumber)
	// Parameters:  tableNumber - number of the Table
	// Returns:		 zero
									
	/**
	  * This function sets the Table's number.
	  * @param tableNumber  This is the number of the Table.
	  */
	public void setTableNum(int tableNumber)
	{
		if (tableNumber > 0)
		{
			tableNum.set(tableNumber);
		}
		else
		{
			tableNum.set(1);
		}
	}
	
	// Function: public void setWaiter(String waiterName)
	// Parameters:  waiterName - waiter assigned to the Table
	// Returns:		 zero
									
	/**
	  * This function sets the name of the Table's waiter.
	  * @param waiterName  This is the name of the waiter assigned to the Table. 
	  */
	public void setWaiter(String waiterName)
	{
		waiter.set(waiterName);
	}
	
	// Properties
	// Function: public IntegerProperty tableNumProperty()
	// Parameters:  none
	// Returns:		 tableNum - number of the Table
									
	/**
	  * This function retrieves the Property for the Table's number.
	  * @return tableNum - This is the number of the Table.
	  */
	public IntegerProperty tableNumProperty()
	{
		return tableNum;
	}
	
	// Function: public StringProperty waiterProperty()
	// Parameters:  none
	// Returns:		 waiter - waiter assigned to the Table
									
	/**
	  * This function retrieves the Property for the name of the Table's waiter.
	  * @return waiter - This is the name of the waiter assigned to the Table.
	  */
	public StringProperty waiterProperty()
	{
		return waiter;
	}
	
	// Other Functions
	// equals()
	// Function: public boolean equals(Object x)
	// Parameters:  x - the object being compared to the calling Table
	// Returns:		 true or false
						
	/**
	  * This is the override of Object's equals() function.
	  * @param x  This is the Object being compared to the calling Table.
	  * @return true - This tells the calling Table that the Object is equal to it.
	  * @return false - This tells the calling Table that the Object is not equal to it.
	  */
	public boolean equals(Object x)
	{
		if (x instanceof Table)
		{
			if (tableNum == ((Table)x).tableNum &
					waiter == ((Table)x).waiter)
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
	  * @return String - This is the printout of all of the calling Table's values.
	  */
	public String toString()
	{					
		return "Table Number: " + tableNum.get() + "\n" + 
				"Waiter: " + waiter.get();
	}
}