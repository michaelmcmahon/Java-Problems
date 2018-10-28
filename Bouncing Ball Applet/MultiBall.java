/* mmcmahon_wk7_Assignment_MultiBall.java
 *Applet bounces multiple balls as specified by a parameter in the HTML file and utilizes multiple colors. 
 * 
 * <html>
 * <applet code = "MultiBall.class" width = "400" height = "400">
 * <param name=numBalls value="10">
 * </applet>
 * </html>
 */

import java.awt.*;
import java.applet.*;
import java.util.Random;

public class MultiBall extends Applet implements Runnable{
	private static final long serialVersionUID = -4483729616618053641L;
	Thread thread  = null; // Declare the thread
	
	int numBalls = 10; //remove number when adding HTML
	
	ABall balls[]; //initialize an array for the balls
	//create an array of ball colours
	private Color Colors[] = {Color.GRAY, Color.BLUE, Color.ORANGE, Color.CYAN, Color.WHITE, Color.MAGENTA, Color.GREEN,  Color.PINK, Color.YELLOW, Color.RED};
	Color ballColor[];
	int c; // counter for the colors used
	
	Dimension d; //Window dimensions
	Graphics offscreen;
	Image image;
	
	private final Random generator = new Random(); // initilize the random generator
	
	 @Override
	public void init() {
		balls = new ABall[numBalls]; //New Ball
		ballColor = new Color[numBalls]; // New Ball colour

		// Loop to create each ball object up to numBalls
		for (int i = 0; i < numBalls; i++) {
			if (c >= 10) {
				c = 0;
			}// end if
			int x = generator.nextInt(400);
			int y = generator.nextInt(400);
			int dx = generator.nextInt(5)+1;
			int dy = generator.nextInt(5)+1;
			int radius = 15;
			Color color = Colors[c];
			balls[i] = new ABall(x,y,radius,dx,dy,color);
			c++;
		}// end for

	}
	 	 
	 public void start(){
			if(thread == null){
				thread = new Thread(this);
				thread.start();
			}// end if
		}// end method start
	 
	 @Override
		public void run(){
			while(true){
				for (int j=0; j<numBalls; j++){
					 // bounce ball off the boundry walls
					if (balls[j].getX() < balls[j].getRadius() || balls[j].getX() > 400- balls[j].getRadius()) {
						balls[j].setDX(balls[j].getDX()*-1);
					    }
					    if (balls[j].getY() < balls[j].getRadius() || balls[j].getY() > 400 - balls[j].getRadius()) {
					    	balls[j].setDY(balls[j].getDY()*-1);
					    }
					  //move ball
				        balls[j].setX(balls[j].getX()+balls[j].getDX());
				        balls[j].setY(balls[j].getY()+balls[j].getDY());
				}// end for		
				try{
					Thread.sleep(20);
				}// end try
				catch(InterruptedException except){
				}// end catch
				repaint();
			}// end while
		}// end method run


	    @Override
		public void update(Graphics g){
				 // create off-screen image buffer
			    if (image == null) {
			      image = createImage(400, 400);
			      offscreen = image.getGraphics();
			    }
		       //clear background
		       offscreen.setColor(Color.BLACK);
		       offscreen.fillRect(0,0,400,400);
		       for (int k=0; k<numBalls; k++){
		     //draw ball
		        offscreen.setColor(balls[k].getBallColor());
		        offscreen.fillOval(balls[k].getX()-balls[k].getRadius(), balls[k].getY()-balls[k].getRadius(), balls[k].getRadius()*2, balls[k].getRadius()*2);   

				g.drawImage(image, 0, 0, this);
			}// end for	
		}// end method paint

	// repaint the window background
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		update(g);
	}
}
