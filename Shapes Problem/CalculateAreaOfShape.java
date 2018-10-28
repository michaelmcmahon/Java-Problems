/* McMahonMichael_Wk1_MCT619
 * Assignment: Write a Java program for calculating the area of triangles and rectangles. The user is asked whether a triangle or rectangle is required, 
 * then prompted for the relevant dimensions, and the answer is displayed. Use the Wages program as a template. Note that the area of a rectangle 
 * is width x height, and the area of a triangle is ½ base width x height. Ensure your program works correctly for different user inputs.*/

import javax.swing.JOptionPane; // Dialog box methods

public class CalculateAreaOfShape 
{	
	public static void main(String[] args) 
	{   
		/*Declare the whole number and string variables*/
		double shape, width, height, area;
		String shapeStr, widthStr, heightStr;
		
		/* Get the user to choose which shape to calculate area of and check for incorrect input */
		shapeStr = JOptionPane.showInputDialog(null, "\n Do you want to find the area of \n 1 . Rectangle \n 2 . Triangle \n\n Enter either 1 or 2 to choose: ");
		while(shapeStr.isEmpty() || !shapeStr.matches("[1-2]") )
		    {
			 shapeStr = JOptionPane.showInputDialog(null, "\n Incorrect input \n Please enter either 1 or 2 only:", 
					    "Error",
	                    JOptionPane.WARNING_MESSAGE);
		    }
		shape = Double.parseDouble(shapeStr);
		
		/* Get width from user in string form, check for incorrect or empty input and when OK convert to float */
		widthStr = JOptionPane.showInputDialog(null, "Enter shapes width:");
		while(widthStr.isEmpty() || !widthStr.matches("^[0-9]*$"))
		 	{
			widthStr = JOptionPane.showInputDialog(null, "\n Incorrect input \n Please enter a number for width:", 
				    "Error",
                    JOptionPane.WARNING_MESSAGE);
		    }
		width = Double.parseDouble(widthStr);
		
		/* Get height from user in string form, check for incorrect or empty input and when OK convert to float  */
		heightStr = JOptionPane.showInputDialog(null, "Enter shapes height:");
		while(heightStr.isEmpty() || !heightStr.matches("^[0-9]*$"))
		 	{
			heightStr = JOptionPane.showInputDialog(null, "\n Incorrect input \n Please enter a number for height:", 
				    "Error",
                    JOptionPane.WARNING_MESSAGE);
		    }
		height = Double.parseDouble(heightStr);
		
		/* If the user has select 1 then calculate area of Rectangle */
		if (shape == 1) {		
			area = height * width;
			JOptionPane.showMessageDialog(null, "Area of Rectangle is: "+area);
		}
		
		/* If the user has select 2 then calculate area of Triangle */
		else if (shape == 2) {
			area = (height * width)/2;
			JOptionPane.showMessageDialog(null, "Area of Triangle is: "+area); 
		}
		
		/* If some another error occurs then fail gracefully*/
		else {
			JOptionPane.showMessageDialog(null, "Error: Unknown failure - please try again", 
					"Incorrect Input",
                    JOptionPane.WARNING_MESSAGE);
		}
		System.exit(0); // Terminate program
	}
}