/*mmcmahon_wk4_question1_BankAccount.java
 * Develop a class called BankAccount that stores a name, account number and balance. The constructor for the class must 
 * allow the name and account number to be specified, and set the initial balance to 0. The public interface for the class 
 * must include methods to perform the following tasks:
 * 
 * 1. get name, get account number, get balance
 * 2. deposit (specify an amount to add to balance)
 * 3. withdraw (specify an amount to subtract from balance) -- note that the maximum withdrawal is the current balance, 
 *     as the balance cannot go below 0
 * 4. an implementation of toString(), that will return a string with the account details, in a format like 
 *     "John Smith: Balance = €1000"

None of these methods should display information on screen -- the display should all happen from the test program
Ensure that all class member variables and methods are defined to be public or private as appropriate.

References:
 * http://java.about.com/od/workingwithobjects/a/useinheirtance.htm
 */

public class BankAccount {

	private String name; 			// declare account name 
	private int accountNumber; 		// declare account number
	protected double balance; 		// declare the balance

	
	// Account constructor allows the name and account number to be specified
	public BankAccount( String theName, int theAccountNumber)
	{
		name = theName;
		accountNumber = theAccountNumber;
		balance = 0;
		} // end Account constructor
	
	// Get returns the account name
	public String getName()
	{
		return name;
	} // end method getName
		
	// Get returns the account number
	public int getAccountNumber()
	{
		return accountNumber;
	} // end method getAccountNumber
	
	// Get returns the total balance
	public double getBalance()
	{
		return balance;
	} // end method getTotalBalance
	
	protected void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	// deposit an amount to the account
	public void deposit(double amount)
	{
		balance += amount; // add to balance
	} // end method deposit
	
	// withdraw an amount from the account
	public void withdraw( double amount )
	{
		if ( amount <= balance) // verify if there is sufficient available funds
			{
			balance -= amount; // subtract amount from balance
			} // end if
		else 
			{
			System.out.println("Insufficient available funds for transaction - Try a smaller amount"); //Throw exception
			} // end else
		
	} // end method withdraw
	
	// Return a string with the account details in format like "John Smith: Balance = €1000" 
	public String toString()
	{
		return "Account Name: " + this.name + 
				"\nAccount Number " + this.accountNumber + 
				"\nAccount Balance = €" + this.balance; 
	} // end toString method				
	
} // end class BankAccount