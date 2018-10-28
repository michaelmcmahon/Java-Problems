/*	mmcmahon_wk5_Assignment_PartsWorkerTest.java 
 * Provide a separate class to test the functionality of the PartsWorker class.
 */

public class PartsWorkerTest {

	public static void main(String[] args) {
		
		// create PartsWorker object without bonus
	      PartsWorker partsWorker1 = 
	         new PartsWorker( "John", "Doe", "111-11-1111", 5, 99, 100, 100 );
	      
	      System.out.printf( "%s\nWeekly Wage Earned: $%,.2f\n\n",
	    		  partsWorker1, partsWorker1.earnings() );

		
	      // create PartsWorker object with bonus
	      PartsWorker partsWorker2 = 
	         new PartsWorker( "Jane", "Doe", "222-22-2222", 5, 100, 100, 100 );

	      System.out.printf( "%s\nWeekly Wage Earned: $%,.2f\n\n",
	    		  partsWorker2, partsWorker2.earnings() );
	      
	   // create PartsWorker object with less than zero amounts
	      PartsWorker partsWorker3 = 
	         new PartsWorker( "John", "Doe", "222-22-2222", -5, -100, -100, -100 );

	      System.out.printf( "%s\nWeekly Wage Earned: $%,.2f\n\n",
	    		  partsWorker3, partsWorker3.earnings() );

	}

}
