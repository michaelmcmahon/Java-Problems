/*mmcmahon_wk4_question1_TestBankAccount.java
 * To test the class, write a program that does the following:
 * 
 * 1. Create two BankAccount objects, with a name and account number for each
 * 2. Deposit money in both accounts and withdraw some money from one
 * 3. For each account, display a message with the name and balance (use toString)
 * 
 */


public class TestBankAccount {

	public static void main(String[] args) {
		
		//First BankAccount Object with a name and account number 
		BankAccount_Dev1 BankAcount1 = new BankAccount_Dev1("John Smith", 12345);
		System.out.println("\nDeposit €1000 in Account 1"); 
		BankAcount1.deposit(1000);                          	//Deposit €1000 in the Account 
		System.out.println(BankAcount1.toString()+ "\n");		//Display a message with the name and balance (use toString)
		
		
		//First BankAccount Object with a name and account number 
		BankAccount_Dev1 BankAcount2 = new BankAccount_Dev1("John Doe", 67891);
		System.out.println("\nDeposit €2000 in Account 2");
		BankAcount2.deposit(2000);                           	//Deposit €2000 in the Account
		System.out.println(BankAcount2.toString()+ "\n");		//Display a message with the name and balance (use toString)		
		System.out.println("\nWithdraw €2500 from Account 2");
		BankAcount2.withdraw(2500);                           	//Withdraw €500 from Account
		System.out.println(BankAcount2.toString()+ "\n");		//Display a message with the name and balance (use toString)
		System.out.println("\nWithdraw €500 from Account 2");
		BankAcount2.withdraw(500);                           	//Withdraw €500 from Account
		System.out.println(BankAcount2.toString()+ "\n");		//Display a message with the name and balance (use toString)
	}

}
