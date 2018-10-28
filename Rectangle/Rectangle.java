/* Basic Rectangle class with private member variables length and width.
 * The class has methods to set and get the length
 * and to calculate the perimeter and area
 * 
 * Author: Keith Nagle, March 2006
 * Modified: Tom Howley, March 2007 
 */

public class Rectangle { // Begin class Rectangle
	// Declare constants: use of constants makes code more readable and easier to change if necessary later on.
	private static final int MAX_SIDELENGTH = 20;
	private static final int MIN_SIDELENGTH = 0;
	private static final int DEFAULT_SIDELENGTH = 1;
	
	// Declare private variables
	// Note that these are only two attributes of this class.
	private double length;
	private double width;
	
	// Default constructor. sets length and width to default values
	public Rectangle(){
		length=DEFAULT_SIDELENGTH;
		width=DEFAULT_SIDELENGTH;
	}
	
	// Method to set the rectangle length. Check if parameter is within accepted range.
	// Output message if incorrect.
	public void setLength (double newLength)
	{
		if (newLength > MIN_SIDELENGTH && newLength < MAX_SIDELENGTH)
			length = newLength;
		else
			System.err.println("Incorrect rectangle length (" + newLength + "):length will default to 1");
	}
	
	// Method to set the rectangle width. Check if parameter is within accepted range.
	// Output message if incorrect.
	public void setWidth (double newWidth){
		if (newWidth > MIN_SIDELENGTH && newWidth < MAX_SIDELENGTH)
			width = newWidth;
		else
			System.err.println("Incorrect rectangle width (" + newWidth + "): width will default to 1");
	}
	
	// Method to access value of private member variable length.
	public double getLength (){
		return length;
	}
	
	// Method to access value of private member variable length.
	public double getWidth (){
		return width;
	}
	
	// Method to calculate the perimeter of the rectangle
	// Note: the getLength() and getWidth() methods are called here
	public double getPerimeter (){
		return 2* (getLength() + getWidth());
	}
	
	// Method to calculate the area of the rectangle
	// Note that variables are accessed directly
	// This is possible when within the class but cannot
	// happen outside of the class.
	public double getArea (){
		return length * width;
	}
} // End class Rectangle
