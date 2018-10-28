/* Class to test the CoordRectangle class. Creates
 * a number of different rectangle objects using different sets of coordinates
 * 
 * Note: it is better to test using hard-coded test cases. User-input can be used
 * in addition for testing the class.
 * 
 * Author: Tom Howley, March 2007
 */
import java.awt.Point;

public class CoordRectangleTest {

	public static void main(String[] args) 
	{
		
		// TEST CASE 1: Valid Rectangle
		CoordRectangle r1 = new CoordRectangle(1,1,4,4,5,3,2,0);
		System.out.println("TEST CASE 1 - Valid Rectangle with coords: (1,1,4,4,5,3,2,0)");
		System.out.println("Width: " + r1.getWidth() + " Length: " + r1.getLength() 
				+ " Area: " + r1.getArea() + " Perimeter: " + r1.getPerimeter());
		if(r1.isSquare())
			System.out.println("This is a square!");
		else
			System.out.println("This is not a square");
		System.out.println();

		// TEST CASE 2: Valid Square (Not Parallel with X and Y Axis)
		CoordRectangle r2 = new CoordRectangle(1,5,5,8,8,4,4,1);
		System.out.println("TEST CASE 2 - Valid Square (Not Parallel with X and Y Axis) with coords: (1,5,5,8,8,4,4,1)");
		System.out.println("Width: " + r2.getWidth() + " Length: " + r2.getLength() 
				+ " Area: " + r2.getArea() + " Perimeter: " + r2.getPerimeter());
		if(r2.isSquare())
			System.out.println("This is a square!");
		else
			System.out.println("This is not a square");
		System.out.println();

		// TEST CASE 3: Invalid Rectangle
		CoordRectangle r3 = new CoordRectangle(1,7,3,4,3,1,1,1);
		System.out.println("TEST CASE 3 - Invalid Rectangle with coords: (1,7,3,4,3,1,1,1)");
		System.out.println("Width: " + r3.getWidth() + " Length: " + r3.getLength() 
				+ " Area: " + r3.getArea() + " Perimeter: " + r3.getPerimeter());
		if(r3.isSquare())
			System.out.println("This is a square!");
		else
			System.out.println("This is not a square");
		System.out.println();
		
		// TEST CASE 4: Invalid Rectangle - wrong Quadrant
		CoordRectangle r4 = new CoordRectangle(-1,4,3,4,3,1,-1,1);
		System.out.println("TEST CASE 4 - Invalid Rectangle in the wrong Quadrant with coords: (-1,4,3,4,3,1,-1,1)");
		System.out.println("Width: " + r4.getWidth() + " Length: " + r4.getLength() 
				+ " Area: " + r4.getArea() + " Perimeter: " + r4.getPerimeter());
		if(r4.isSquare())
			System.out.println("This is a square!");
		else
			System.out.println("This is not a square");
		System.out.println();
		
		// TEST CASE 5: Invalid Rectangle - outside max allowed coordinate value
		CoordRectangle r5 = new CoordRectangle(1,25,3,25,3,1,1,1);
		System.out.println("TEST CASE 5 - Invalid Rectangle goes outside max allowed Coordinate Value, with coords: (1,25,3,25,3,1,1,1)");
		System.out.println("Width: " + r5.getWidth() + " Length: " + r5.getLength() 
				+ " Area: " + r5.getArea() + " Perimeter: " + r5.getPerimeter());
		if(r5.isSquare())
			System.out.println("This is a square!");
		else
			System.out.println("This is not a square");
		System.out.println();
		
		// TEST CASE 5: valid Rectangle - using VerPoshRectangle
		Point p1 = new Point(1,1);
		Point p2 = new Point(4,4);
		Point p3 = new Point(2,0);
		Point p4 = new Point(5,3);
		VeryPoshRectangle r6 = new VeryPoshRectangle(p1, p2, p3, p4);
		System.out.println("TEST CASE 6 - valid Rectangle using VeryPoshRectangle class");
		System.out.println("Width: " + r6.getWidth() + " Length: " + r6.getLength() 
				+ " Area: " + r6.getArea() + " Perimeter: " + r6.getPerimeter());
		if(r6.isSquare())
			System.out.println("This is a square!");
		else
			System.out.println("This is not a square");
		System.out.println();
	}

}
