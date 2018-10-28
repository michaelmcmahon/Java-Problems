/* mmcmahon_wk3_assignments_Question2
 * 
 * Write a Java applet that just displays a static picture or design (e.g. a smiley face, a sunburst pattern) 
 * made from ovals, lines, rectangles, and/or graphics commands you have found in your research. Consider using 
 * loops, etc., for repeated patterns. Submit up a screen-grab of your applet along with the code. Be original!
 * 
 */

import java.applet.*; 
import java.awt.*;  

public class BreakingBad extends Applet{
		
	public void init(){
		setSize(300, 300); //set default size
        setVisible(true); //set to visable
	}
	
	public void paint(Graphics g){
		
		g.drawString("HEISENBERG", 107, 75); //Create text above the image 
		
		g.setColor(Color.black); // Set the fill colour 
		g.fillRect(112, 85, 75, 25);   //create a rectangle for the Hat 
		g.drawLine(90,110,210,110); //create a line for thd Hat brim
		
		g.drawOval(105,90,90,115); //draw the Face
		
		g.drawLine(135,115,165,115); //add a Forehead Line 1
		g.drawLine(130,120,170,120); //add a Forehead Line 2
		
		g.fillOval(115,125,30,20);  //create the Left Eye glass 
		g.drawLine(135,135,165,135); // nose bridge of glasses
		g.fillOval(155,125,30,20);  //crate the Right Eye glass
		
		// Draw a Nose on the face
		g.drawLine(145,165,150,140); 
		g.drawLine(155,165,150,140);
		g.drawLine(145,165,155,165);
		
		//loop through a line to create a moustache
		int mwidth = 132;
		for(int i = 0; i < 34; i++){
			mwidth = mwidth + 2;
			g.drawLine(mwidth,170,mwidth,178); //moustache
			i++;
		}
		
		//add a line for the Mouth
		g.drawLine(135,182,165,182); //Mouth
		
		//Write a text line under the face
		g.drawString("I AM THE ONE WHO KNOCKS!", 70, 225);
		
	}

	
}