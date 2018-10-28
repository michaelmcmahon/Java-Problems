/*mmcmahon_Final_Exam_Q1_RobotPainter.java
 * Represents an spraying robot in the painting department. A paint spraying robot costs $2,000 in running costs 
 * each week based on 40 hours of operation. There is an annual maintenance cost for each paint-spraying robot of 
 * $10,000. A paint spraying robot can only spray one guitar at a time. A guitar will take a fixed amount of time 
 * to be sprayed in a robot booth, to be tested in this simulation.
*/

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class RobotPainter implements Runnable{

    protected BlockingQueue queue = null;

    public RobotPainter(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
    		long machineT = Thread.currentThread().getId();
    		int count = 0;
    		int sprayTime = 0;
    		int totalTime = 0;
    		double annualMaintaince = 10000;
    		double weeklyRunCosts = 2000;
    		double WorkDays = (52*5);
    		double DailyRate = ((annualMaintaince/WorkDays) + (weeklyRunCosts/5));
    		int WorkMinutes = (8 * 60) * 10;
    		
    		do {
    			try {
    				sprayTime = (30);
    				Thread.sleep(sprayTime); //Random Sleep
    				totalTime += sprayTime;
    				Integer value = (Integer) queue.take(); // Take next guitar in queue
    				System.out.println("Machine ID " + machineT
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
    		System.out.println("Machine ID " + machineT + " painted " + count + " guitars in " + (totalTime/10) + " minutes at a cost of $" + DailyRate +" per day\n");
    	} // end method run
}