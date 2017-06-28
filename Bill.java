// Name: Katelyn Peterson
// Class: CIS 2571-001 Fall 2015
// Instructor: Mohammad Morovati
// Date: Dec. 11th, 2015
// Prologue:  This class holds subtotal, tax, and total.

package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * <h1> Bill </h1> 
 * The Bill class includes the subtotal, tax, and total.
 * 
 * @author Katelyn Peterson
 * @version 1.0
 * @since 12-11-2015 
 *
 */

public class Bill 
{
	// Private Variables
	private DoubleProperty subtotal = new SimpleDoubleProperty();
	private DoubleProperty tax = new SimpleDoubleProperty();
	private DoubleProperty total = new SimpleDoubleProperty();
	
	// Constructors
	// Default
	// Function: public Bill()
	// Parameters:  none - default
	// Returns:		 Constructor
					
	/**
	  * This is the default constructor for the Bill class.
	  */
	public Bill()
	{
		setSubtotal(0.00);
		setTax(0.00);
		setTotal();
	}
	
	// All Information
	// Function: public Bill(double sub, double taxRate)
	// Parameters:  sub - cost before tax
	//						 taxRate - tax
	// Returns:		 Constructor
						
	/**
	  * This is the full constructor for the Bill class.
	  * @param sub  This is the cost before tax amount of the Bill.
	  * @param taxRate  This is the tax rate being applied to the subtotal of the Bill.
	  */
	public Bill(double sub, double taxRate)
	{
		setSubtotal(sub);
		setTax(taxRate);
		setTotal();
	}
	
	// Partial Constructors
	// Function: public Bill(double taxRate)
	// Parameters:  taxRate - tax
	// Returns:		 Constructor
						
	/**
	  * This is the full constructor for the Bill class.
	  * @param taxRate  This is the tax rate being applied to the subtotal of the Bill.
	  */
	public Bill(double taxRate)
	{
		setSubtotal(0.00);
		setTax(taxRate);
		setTotal();
	}
	
	// Getters
	// Function: public double getSubtotal()
	// Parameters:  none
	// Returns:		 subtotal - cost before tax
								
	/**
	  * This function retrieves the Bill's subtotal.
	  * @return subtotal - This is the cost before tax amount of the Bill.
	  */
	public double getSubtotal()
	{
		return subtotal.get();
	}
	
	// Function: public double getTaxRate()
	// Parameters:  none
	// Returns:		 tax - tax rate
								
	/**
	  * This function retrieves the Bill's tax Rate.
	  * @return tax - This is the tax rate being applied to the subtotal of the Bill.
	  */
	public double getTaxRate()
	{
		return tax.get() * 100;
	}
	
	// Function: public double getTaxRate()
	// Parameters:  none
	// Returns:		 tax - tax on subtotal
								
	/**
	  * This function retrieves the Bill's tax.
	  * @return tax - This is the tax being added to the subtotal of the Bill.
	  */
	public double getTax()
	{
		return tax.get() * subtotal.get();
	}
	
	// Function: public double getTotal()
	// Parameters:  none
	// Returns:		 total - total amount charged
								
	/**
	  * This function retrieves the Bill's total.
	  * @return total - This is the total amount of the Bill.
	  */
	public double getTotal()
	{
		return total.get();
	}
	
	// Setters
	// Function: private void setSubtotal(double sub)
	// Parameters:  sub - cost before tax
	// Returns:		 zero
									
	/**
	  * This function sets the Bill's subtotal.
	  * @param sub  This is the cost before tax amount of the Bill.
	  */
	private void setSubtotal(double sub)
	{
		if (sub > 0)
		{
			subtotal.set(sub);
		}
		else
		{
			subtotal.set(0.00);
		}
	}
	
	// Function: public void setTax(double taxRate)
	// Parameters:  taxRate - tax
	// Returns:		 zero
									
	/**
	  * This function sets the Bill's tax rate.
	  * @param taxRate  This is the tax rate being applied to the subtotal of the Bill.
	  */
	public void setTax(double taxRate)
	{
		if (taxRate > 0)
		{
			taxRate = taxRate / 100;
			tax.set(taxRate);
		}
		else
		{
			tax.set(0.00);
		}
	}
	
	// Function: private void setTotal()
	// Parameters:  none
	// Returns:		 zero
									
	/**
	  * This function sets the Bill's total.
	  */
	private void setTotal()
	{
		double taxSubtotal;
		
		taxSubtotal = tax.get() * subtotal.get();
		
		total.set(subtotal.get() + taxSubtotal);
	}
	
	
	// Properties
	// Function: public DoubleProperty subtotalProperty()
	// Parameters:  none
	// Returns:		 subtotal - cost before tax
									
	/**
	  * This function retrieves the Property for the Bill's subtotal.
	  * @return subtotal - This is the cost before tax amount of the Bill.
	  */
	public DoubleProperty subtotalProperty()
	{
		return subtotal;
	}
	
	// Function: public DoubleProperty taxProperty()
	// Parameters:  none
	// Returns:		 tax - tax rate
									
	/**
	  * This function retrieves the Property for the Bill's tax.
	  * @return tax - This is the tax rate being applied to the subtotal of the Bill.
	  */
	public DoubleProperty taxProperty()
	{
		return tax;
	}
	
	// Function: public DoubleProperty taxProperty()
	// Parameters:  none
	// Returns:		 total - total amount charged
									
	/**
	  * This function retrieves the Property for the Bill's total.
	  * @return total - This is the total amount of the Bill.
	  */
	public DoubleProperty totalProperty()
	{
		return total;
	}
	
	// Other Functions
	// Credit
	// Function: public void credit(double billCredit)
	// Parameters:  billCredit - credit to add to Bill subtotal
	// Returns:		 zero
										
	/**
	  * This function credits money to the Bill's subtotal.
	  * @param billCredit - This is the credit to add to the Bill subtotal.
	  */
	public void credit(double billCredit)
	{
		if (billCredit > 0)
		{
			subtotal.set(subtotal.get() + billCredit);
			setTotal();
		}		
	}
	
	// Debit
	// Function: public void debit(double accountDebit)
	// Parameters:  accountDebit - debit to subtract from an Account
	// Returns:		 zero
									
	/**
	  * This function debits money from the Bill's subtotal if the subtotal is higher than the debit.  If the debit is greater,
	  * no action occurs.
	  * @param billDebit - This is the debit to subtract from the Bill subtotal.
	  */
	public void debit(double billDebit)
	{
		if (billDebit > 0)
		{
			if (billDebit <= subtotal.get())			
			{
				subtotal.set(subtotal.get() - billDebit);
				setTotal();
			}
		}
	}
	
	// equals()
	// Function: public boolean equals(Object x)
	// Parameters:  x - the object being compared to the calling Bill
	// Returns:		 true or false
						
	/**
	  * This is the override of Object's equals() function.
	  * @param x  This is the Object being compared to the calling Bill.
	  * @return true - This tells the calling Bill that the Object is equal to it.
	  * @return false - This tells the calling Bill that the Object is not equal to it.
	  */
	public boolean equals(Object x)
	{
		if (x instanceof Bill)
		{
			if (subtotal == ((Bill)x).subtotal &
					tax == ((Bill)x).tax &
					total == ((Bill)x).total)
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
	  * @return String - This is the printout of all of the calling Bill's values.
	  */
	public String toString()
	{					
		return "Subtotal: " + String.format("$%1$,.2f", subtotal.get()) + "\n" + 
				"Tax Rate: " + String.format("%,.3f%%", (tax.get() * 100)) + "\n" +
				"Tax: " + String.format("$%1$,.2f", getTax()) + "\n" +
				"Total: " + String.format("$%1$,.2f", total.get());
	}
}