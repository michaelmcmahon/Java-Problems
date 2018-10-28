/* mmcmahon_wk7_Assignment_OneBall.java
 * Write an Applet that bounces a ball inside its graphics area. 
 * 
 * <html>
 * <applet code = "OneBall.class" width = "400" height = "400">
 * </applet>
 * </html>
 */

import java.util.*;
import java.awt.*;
import java.applet.*;
import java.util.Random;

public class OneBall extends Applet
{
	private static final long serialVersionUID = -1623236972156601802L;
	ABall ball;
    Timer timer; //timer for animation
    TimerTask task;
    Image image; //
	Graphics offscreen; //Graphics offscreen 
    private final Random generator = new Random();
    Dimension d; //Window dimensions
 
    @Override
	public void init()
    {	
		int x = generator.nextInt(400); // Set the initial horizontal position of the ball.
		int y = generator.nextInt(400); // Set the initial vertical position of the ball.
		int dx = generator.nextInt(5)+1; // The ball moves dx pixels vertically
		int dy = generator.nextInt(5)+1; // The ball moves dy pixels vertically
		int radius = 15; // Set the radius of the ball
		Color color = Color.red; //Set the color of the ball

		ball=new ABall(x,y,radius,dx,dy,color); //Create a new ball object

        timer= new Timer(); //create timer
    }

	public void start()
    {   
        //timer run() every timer.schedule interval
        task= new TimerTask() {
			public void run() {
                move();
            }
        };

        // timer start and run every .10 secs
        timer.schedule( task , 0, 10); 
    }

    public void move()
    {
    	
    	 // bounce ball off the boundry walls 
	    if ((ball.getX() < ball.getRadius()) || (ball.getX() > 400 - ball.getRadius())){
            ball.setDX(ball.getDX()*-1);
        }
        if ((ball.getY() < ball.getRadius()) || (ball.getY() > 400 - ball.getRadius())){
            ball.setDY(ball.getDY()*-1);
        }

        
        //move ball
        ball.setX(ball.getX()+ball.getDX());
        ball.setY(ball.getY()+ball.getDY());
       
        repaint();
    }

    @Override
	public void update(Graphics g)
    {
    	super.paint(g);
    	 // create off-screen image buffer
	    if (image == null) {
	      image = createImage(400, 400);
	      offscreen = image.getGraphics();
	    }
        //clear background
        offscreen.setColor(Color.BLACK);
        offscreen.fillRect(0,0,400, 400);
        //draw ball
        offscreen.setColor(ball.getBallColor());
        offscreen.fillOval(ball.getX()-ball.getRadius(), ball.getY()-ball.getRadius(), ball.getRadius()*2, ball.getRadius()*2);      
     // copy the off-screen image to the screen
	    g.drawImage(image, 0, 0, this);
    }
    
      //repaint the window background
	  public void paint(Graphics g) {		  
	    update(g);
	  }
}
