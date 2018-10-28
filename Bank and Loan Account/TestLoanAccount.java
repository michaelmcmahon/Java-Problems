/*mmcmahon_wk4_question2_TestLoanAccount.java
 * Testing the class with a program that does the following: Create a BankAccount objects, with a name and account number
 * Deposit money in the account and withdraw e money to test the overdraft facility including exceeding the facility and 
 * the interest rate.
 */

public class TestLoanAccount {
	
	public static void main(String[] args) {
	
	LoanAccount LoanAccount1 = new LoanAccount("Frank Smith", 12345, 1000); 
			System.out.println("\nDeposit €2000 in Account 2");
			LoanAccount1.deposit(2000);                           	//Deposit €2000 in the Account
			System.out.println(LoanAccount1.toString()+ "\n");		//Display a message with the name and balance (use toString)		
			System.out.println("\nWithdraw €2500 from Account 2");
			LoanAccount1.withdraw(2500);                           	//Withdraw €2500 from Account to test overdraft
			System.out.println(LoanAccount1.toString()+ "\n");		//Display a message with the account details (use toString)
			System.out.println("\nWithdraw €500 from Account 2");
			LoanAccount1.withdraw(500);                           	//Withdraw €1500 from Account to test exceeding overdraft limit
			System.out.println(LoanAccount1.toString()+ "\n");		//Display a message with the account details (use toString)
			System.out.println("\nWithdraw €200 from Account 2");
			LoanAccount1.withdraw(200);                           	//Withdraw €200 from Account to test exceeding overdraft limit
			System.out.println(LoanAccount1.toString()+ "\n");		//Display a message with the account details (use toString)
	
	}

}
