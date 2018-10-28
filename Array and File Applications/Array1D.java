/* mmcmahon_wk6_Assignment_Array1D.java
 * 1-D array to asks the user to input five numbers between 10 and 100 (inclusive) and display the complete 
 * set of unique values input after the user inputs each new value.
 */

import java.util.*; //import java.util package

public class Array1D {

	public static void main(String[] args) {

		int[] NumArray = new int[5]; // Declare a NumArry of length 5 integers
		int ValidNums = 0; // number of valid integers entered
		int num = 0; // user number variable
		boolean valid = false; // Set boolean valid to false


		Scanner scan = new Scanner(System.in); // Create a new Scanner object 
		
		System.out.print("\nEnter five integers between 10 and 100"); //Instructions to user

		while (!valid) { 
			//loop while the number of valid numbers is less that array length
			while (ValidNums < NumArray.length) {
				
				boolean containsNumber = false; //set the duplicate flag to false
				
				int Remaining = (NumArray.length - ValidNums); // number of user entries remaining
				System.out.print("\nYou have " +Remaining+ " integers left - enter a number: "); //User enter a integer
				
				//block of statements to try
				try { 
					num = scan.nextInt(); //Set user number variable
					
					//validate that integer is between 10 and 100
					if (num >= 10 && num <= 100) {	
						//validates that the integer is not a duplicate
						for (int i = 0; i < NumArray.length; i++) {
							if (num == NumArray[i]) {
								containsNumber = true; //set the duplicate flag to true
//								ValidNums++; // increase count of valid numbers
								System.out.print("You have entered a duplicate! Try again.");
							}						
						}

						if (!containsNumber) { // if no duplicate exist continue
						NumArray[ValidNums] = num; //Enter the number in the Array
						valid = true; // set valid boolean to True
						ValidNums++; // increase count of valid numbers
						
						//Display the complete set of unique values input
						System.out.print("Unique values are: ");
						for (int i = 0; i < ValidNums; i++) {
							System.out.print(NumArray[i] + " ");
						}
						System.out
								.print("\n");
						}
						

					} // else number is not between 10 and 100 (inclusive)
					else {
						System.out.println("Out of range. Try again"); 
					}
				// Catch-User entry is not an integer number
				} catch (InputMismatchException e) {
					System.out.println("Not a valid integer. Try again"); 
					scan.next();
				}
			}
			// Tell user that the application is finished
			System.out.print("\nFive valid integers have now been entered! ");
		}
		scan.close(); // close the scanner
		System.exit(0); // exit
	}
}
