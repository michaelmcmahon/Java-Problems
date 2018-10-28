/*mmcmahon_wk4_question2_LoanAccount.java
 * Develop a new class called LoanAccount, based on BankAccount. This class has an overdraft facility, so that the user 
 * can withdraw money up to the overdraft limit. The class must store an overdraft limit for the account. It must also 
 * store the current interest rate, but this is the same for all accounts (it is not part of any one account).
 * The constructor will require a name and account number to be specified, and will invoke the constructor of the BankAccount 
 * class and also set the overdraft limit to 0. Also, the withdraw method from BankAccount will have to be overridden in this 
 * class, so that a negative balance is permitted. You will need to add a protected setBalance method to BankAccount, that 
 * changes the balance without checking it, since BankAccount does not normally allow negative balances.
 * 
 * The public interface must also include the following additional methods:
 * set/get the overdraft limit
 * calculate projected interest (0 if the balance is positive, otherwise multiply current balance by current interest rate)
 * 
 * References
 * http://java.about.com/od/workingwithobjects/a/useinheirtance.htm
*/

public class LoanAccount extends BankAccount {
	
	private double interestRate = 5;	//declare interestRate
	private double overdraft = 0;		//declare overdraft
	private double interest;		//declare interest
	
	/*Constructor will require a name and account number to be specified, and will invoke the constructor of the BankAccount 
	 * class and also set the overdraft limit to 0.*/
	public LoanAccount(String name, int accountNumber, double overdraft)
	{
		super (name, accountNumber);
		this.overdraft = overdraft;
	}
	
	//set method for the Overdraft
	public void setOverdraft(double overdraftLimit)
	{
		this.overdraft = overdraftLimit;
	} // end set method Overdraft
	
	//get method for the Interest Rate
	public double getInterestRate()
	{
		return this.interestRate;
	} // end get method InterestRate
	
	//get method for the Overdraft
	public double getOverdraft()
	{
		return this.overdraft;
	} // end get method Overdraft
	
	//get method for calculation of available funds
	public double getAvailableFunds()   
	{     
		return super.getBalance() + this.overdraft;   
	}
	
	//get method for calculation of interest
	public double getInterest()
	{
		return this.interest = Math.abs(super.balance * this.interestRate / 100);
	}
	
	/*The withdraw method from BankAccount is overridden so that a negative balance is permitted*/
	@Override
	public void withdraw( double amount )
	{	
		if (getAvailableFunds() - (amount + getInterest()) > 0) 
		{
			if (balance - amount < 0) // only charge fee if account is overdrawn
			{	
				
			    super.balance = balance - (amount + getInterest());
			}
		 else {
				super.balance -= amount;
		 }
		}
		else
		{
			System.out.println("Insufficient available funds for transaction - Try a smaller amount"); //Throw exception
		} // end else
	} 
	
	// Return a string with the account details in format like "John Smith: Balance = €1000" 
		public String toString()
		{
			return "Account Name: " + super.getName() + 
					"\nAccount Balance = €" + super.getBalance() + 
					"\nAvailable Funds: " + getAvailableFunds() + 
					"\nOverdraft: " + getOverdraft() + 
					"\nInterest Rate: " + getInterestRate()  + 
					"\nInterest: " + getInterest(); 
		} // end toString method	
}

