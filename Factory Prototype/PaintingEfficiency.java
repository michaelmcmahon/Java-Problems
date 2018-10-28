/* mmcmahon_Final_Exam_Q1_PaintingEfficiency.java
 * PaintingEfficiencyTests() class should contain a main method that initialises an
 * appropriate amount of HumanPainter() or RobotPainter() objects, the correct number of
 * Guitar() objects to fill the queue, and then runs the threads in simulations representing one
 * average day at the factory.
*/


import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PaintingEfficiency {
	
	//Create FIFO queue with size of 40 guitars 
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(
			40);
	
	  static Guitar Guitar = new Guitar(queue);
	  static HumanPainter HumanPainter = new HumanPainter(queue);
	  static RobotPainter RobotPainter = new RobotPainter(queue);
	  
	  static HashSet painterSet = new HashSet(); //Create a HashSet Collection
		
	
	// PaintingEfficiency main method
	public static void main(String[] args) {
		// Create the Guitar assembly line producer thread
		new Thread(Guitar).start();
		
		// Create 20 Human Painter object consumer threads
		for (int i = 1; i <= 20; i++) { 
		new Thread(HumanPainter).start();
		painterSet.add(Thread.currentThread().getId()); //Unfinished - collate results
		}
		
		
		for (int i = 1; i <= 6; i++) { 
			new Thread(RobotPainter).start();
			}
	}
}
