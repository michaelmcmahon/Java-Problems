/* mmcmahon_Final_Exam_Q1_Guitar.java
 * Guitar object representing the automated conveyer belt system behaviour. Guitars approach 
 * the painting line in a first in first out queue. There is space for 40 guitars to wait in 
 * the queue at a time. 
*/


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Guitar implements Runnable{

    protected BlockingQueue queue = null;

    public Guitar(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
    		int count = 0;
    		while ( true ) {
    			try {
    				Thread.sleep(0); // no sleep
    				queue.put(count);
    				count++;
    			} // end try
    				// if sleeping thread interrupted, print stack trace
    			catch (InterruptedException exception) {
    				exception.printStackTrace();
    			} // end catch
    		} // end for
    	}
}
