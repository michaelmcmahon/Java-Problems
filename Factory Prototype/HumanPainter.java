/* mmcmahon_Final_Exam_Q1_HumanPainter.java
 * Represents an employees in the painting department painting on average 48 guitars in an 8 hour working day.
 * A paint worker or paint spraying robot can only spray one guitar at a time. A guitar takes between 7 and 13 minutes 
 * to be sprayed in a manual booth.
*/

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class HumanPainter implements Runnable{

    protected BlockingQueue queue = null;

    public HumanPainter(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
    		long painterT = Thread.currentThread().getId();
    		int count = 0;
    		int sprayTime = 0;
    		int totalTime = 0;
    		double Salery = 40000;
    		double WorkDays = (52*5);
    		double DailyRate = (Salery/WorkDays);
    		int WorkMinutes = (8 * 60) * 10;
    		
    		do {
    			try {
    				Random generator = new Random(); // Create a random generator
    				int max = 130; // Max 13 minutes for manual spray
    				int min = 70; // Min 7 minutes for manual spray
    				sprayTime = (generator.nextInt((max - min) + 1) + min);
    				Thread.sleep(sprayTime); //Random Sleep
    				totalTime += sprayTime;
    				Integer value = (Integer) queue.take(); // Take next guitar in queue
    				System.out.println("Painter ID " + painterT
    						+ " is spraying guitar number: " + value 
    						+ "\nSpray time was " + sprayTime
    						+ "\nCumulative work minutes: " + totalTime  
    						+ "\nCumulative guitars painted: " + count
    						+ "\nCurrent queue size is: "+ queue.size() + "\n");
    				count++;
    			} // end try
    				// if sleeping thread interrupted, print stack trace
    			catch (InterruptedException exception) {
    				exception.printStackTrace();
    			} // end catch	     
    		} while (totalTime <= WorkMinutes);
    		System.out.println("Painter ID " + painterT + " painted " + count + " guitars in " + (totalTime/10) + " minutes at a cost of $" + DailyRate +" per day\n");	
    } // end method run
    }

