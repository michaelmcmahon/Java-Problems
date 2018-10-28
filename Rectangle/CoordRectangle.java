/* class CoordRectangle
 * the class will store the cartesian coordinates of the four corners of a rectangle
 * the constructor calls a method that accepts four coordinate pairs and verifies
 * that each of these is in the first quadrant, with no single x or y coordinate
 * larger than 20.0. The set method also verifies that the supplied coordinates specify
 * a rectangle. There are methods to calculate the length, width, perimeter and area.
 * Also included is a method to find out if the rectangle is also a square
 * This example uses 8 doubles as its 4 coordinate pairs.
 * 
 * Author: Keith Nagle, March 2006
 * Modified: Tom Howley, March 2007
 */


public class CoordRectangle {
	// Declare constants
	private static final int MAX_COORD = 20;
	private static final int MIN_COORD = 0;
	// Declare private variables for the four coordinates (starting at top-left corner and moving clockwise)
	// NOTE: these are the only attributes used for this class.
	private double x1=0, y1=0, x2=0, y2=0, x3=0, y3=0, x4=0, y4=0;
	
	// Constructor which takes in the 4 coordinate pairs
	public CoordRectangle (double x1, double y1, double x2, double y2, 
			 			double x3, double y3, double x4, double y4){
		// Call the setCoordinates() method, pass the coordinates.
		setCoordinates(x1,y1,x2,y2,x3,y3,x4,y4);
	}
	
	// Method which checks the x and y coordinate of each pair
	// Assigns the values to the private variables if they are within a valid range
	// It then verifies that the supplied coordinates specify a rectangle
	public void setCoordinates(double xc1, double yc1, double xc2, double yc2, 
							 double xc3, double yc3, double xc4, double yc4){
		
		boolean validRectangle = false;
		
		// Check that each pair has valid x and y coordinates
		if (validPoint(xc1, yc1) && validPoint(xc2, yc2) && validPoint(xc3, yc3) && validPoint(xc4, yc4))
		{
			// Now check that the opposite sides are equal. 1st step in verifying a rectangle
			if ((getLineLength(xc1,yc1, xc2, yc2) == getLineLength(xc3,yc3, xc4, yc4)) 
					&& (getLineLength(xc1,yc1, xc4, yc4) == getLineLength(xc2,yc2,xc3,yc3)))
			{
				// If opposite sides are equal, check that one of the internal angles is a right-angle (90 degs)
				// Here, we do this by checking that the product of the slope of two adjacent sides is -1.
				if ( (slope(xc1, yc1, xc2, yc2) * slope(xc1, yc1, xc4, yc4)) == -1)
				{				
					validRectangle = true; // We have a valid rectangle. Set the variable to true

					//	If all are valid, then assign the values to the member variables
					x1 = xc1;
					y1 = yc1;
					x2 = xc2;
					y2 = yc2;
					x3 = xc3;
					y3 = yc3;
					x4 = xc4;
					y4 = yc4;
				}
			}
		}
		
		// Display a message if it is not a valid rectangle (this also occurs if outside first quadrant or greater than MAX_COORD
		if (validRectangle == false)
			System.err.println("Error: invalid coordinates ("+xc1+","+yc1+","+xc2+","+yc2+","  
					+xc3+","+yc3+","+xc4+","+yc4+","+ ") for rectangle!");		
	}
	
	// Method to check that a pair of coordinates are in the first quadrant
	// and are not greater than MAX_VALUE. Returns true or false.
	public boolean validPoint(double x, double y){
		if ( x < MIN_COORD || x > MAX_COORD || y < MIN_COORD || y > MAX_COORD)
			return false;
		else
			return true;
	}
	
	// Method to find the slope of a line
	// Two special cases: horizontal and vertical lines: the standard slope 
	// formula (y2 - y1) / (x2 - x1) will not work, so we use a different approach in this case.
	public double slope (double x1, double y1, double x2, double y2){
		if (y2 - y1 == 0) // horizonal lines
			return 1;
		else if (x2 - x1 == 0) // vertical lines 
			return -1;
		else
			return (y2 - y1) / (x2 - x1); 
	}
	
	// Method to calculate the distance between two points x1, y1 and x2, y2
	public double getLineLength ( double x1, double y1, double x2, double y2 ){
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));    
	}
	
	// Method to find the length of a rectangle
	// Check the top (left to right) against the side (top to bottom)
	// Return the longer of the two.
	public double getLength(){
		double side1 = getLineLength(x1, y1, x2, y2);
		double side2 = getLineLength(x1, y1, x4, y4);
		if(side1 > side2)
			return side1;
		else
			return side2;				
	}
	
	// Similar to getLength. Returns the shorter of two lines.
	public double getWidth(){
		double side1 = getLineLength(x1, y1, x2, y2);
		double side2 = getLineLength(x1, y1, x4, y4);
		if(side1 < side2)
			return side1;
		else
			return side2;				
	}
	
	// Method to calculate the perimeter of the rectangle
	public double getPerimeter(){
		return 2 * (getLength()+ getWidth());
	}
	
	// Method to calculate the area of the rectangle
	public double getArea(){
		return getLength()* getWidth();
	}
	
	// Method to check if the rectangle is also a square.
	public boolean isSquare(){
		if (getLength() == getWidth() && getLength() != 0)
			return true;
		else
			return false;
		
	}
}	// end class PoshRectangle
