
/* mmcmahon_wk3_assignments_Question1
 * 
 * Develop (including designing, coding and testing) an applet that displays a dartboard pattern like the one shown here, 
 * with equally spaced concentric circles and radial lines. The applet must check the available width and height, so that the 
 * pattern is drawn as large as possible. There should always be three equally spaced circles, but the number of lines must be 
 * specified by a parameter in the HTML file. The number of lines should be between 2 and 30, and should default to 20 if outside 
 * of these limits.
 * References 
 * Draw a circle with a radius and points around the edge. (2016). Stackoverflow.com. Retrieved 11 September 2016, from 
 * http://stackoverflow.com/questions/2508704 
 * JavaFX - JavaFX - Dartboard with Shapes. (2013). Hameister.org. Retrieved 11 September 2016, from 
 * http://www.hameister.org/JavaFX_Dartboard.html
 */

import java.applet.Applet;	//import Applet package
import java.awt.*; 			//import Abstract Windowing Toolkit (AWT) package

public class DartsBoard extends Applet {

    public int center_x,  center_y;		//Variables for the center x, y coordinates
    public int no_Segment = 20;			//Set default number of radial lines
    public int r, r2, r3;				//Radius values

    
    /* initialization takes the no_Segment as the number of radial lines from the HTML parameter */
    public void init (int no_Segment) {
        setVisible(true);								//Set to visible
    } 

    /*Applet paints itself in the browser*/
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 			// Construct a new Graphics2D object.
        
        int center_x = getWidth() / 2;  			//Get Width and find center point for X								
        int center_y = getHeight() / 2;				//Get Height and find center point for Y		
        int middle = Math.min(center_x, center_y);	//Set center point value pair (x,y)
        int r = 4 * middle / 4;						//Set circle radius based on center point so that the pattern is drawn as large as possible.
        int r2 = r / 2;								//Set second concentric circle 
        int r3 = r / 5;								//Set third concentric circle
        g2d.setColor(Color.black);					//Set the line colours to black
               
        	g2d.drawOval(center_x - r, center_y - r, 2 * r, 2 * r);		//Draw the main circle
        	g2d.drawOval(center_x - r2, center_y - r2, 2 * r2, 2 * r2);	//Draw the second circle
        	g2d.drawOval(center_x - r3, center_y - r3, 2 * r3, 2 * r3);	//Draw the third circle
        	
        	//Validate if the number of radials is under 2 or over 30 and set to 20 if it is
        	 if(no_Segment < 2 || no_Segment > 30){
             	this.no_Segment = 20;
        		}
        	 
	    //Loop no_segment times to create radial lines using angle x on the circle with coordinates cos(x), sin(y).      
        for (int i = 0; i < no_Segment; i++) {
            double t = 2 * Math.PI * i / no_Segment;
            int x = (int) Math.round(center_x + r * Math.cos(t));
            int y = (int) Math.round(center_y + r * Math.sin(t));
            g2d.drawLine(center_x, center_y, x, y);
        }
    }
} 