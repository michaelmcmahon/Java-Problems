/* mmcmahon_wk6_Assignment_Array1DHashSet.java
 * Re-write the program Array1D.java using a collection class derived from Set.
*/

import java.util.*; //import java.util package

public class Array1DHashSet {

	public static void main(String[] args) {

		int SetSize = 5; // Set the size  of the HashSet
		int ValidNums = 0; // number of valid numbers entered
		int num = 0; // user number variable
		boolean valid = false; // Set boolean valid to false

		Scanner scan = new Scanner(System.in); // Create a new Scanner object 
		Set<Integer> set = new HashSet<Integer>(5); // Declare the Integer Set 
		
		System.out.print("\nEnter five integers between 10 and 100"); //Instructions to user

		while (!valid) {
			//loop while the number of valid numbers is less that array length
			while (ValidNums < SetSize) {
				int Remaining = (SetSize - ValidNums); // number of user entries remaining
				System.out.print("\nYou have " + Remaining + " integers left - enter a number: "); //User enter a integer

				//block of statements to try
				try {
					num = scan.nextInt(); //Set user entered Integer variable
					
					//validate that integer is between 10 and 100
					if (num >= 10 && num <= 100) {
					valid = true; // set valid boolean to True
					ValidNums++; // increase count of valid numbers
					set.add(num); //Add the Integer to the Set

					//Display the complete set of unique values input
					System.out.println("Unique values are: ");
					for (Integer i : set) {
						System.out.printf(" %d", i); // output the set
					}
				} 
					else {
						// else number is not between 10 and 100 (inclusive)
						System.out.println("Out of range. Try again"); 
					}
				}
				// Catch-User entry is not an integer number
				catch (InputMismatchException e) {
					System.out.println("Not a valid integer. Try again"); 
					scan.next();
				}
			}
			// Tell user that the application is finished
			System.out.print("\nFive valid integers have now been entered! ");
			scan.close(); // close the scanner
			System.exit(0); // exit

		}
	}
}