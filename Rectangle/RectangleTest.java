/* Class to test the Rectangle class. Creates
 * a number of different rectangle objects
 * and tests the get/set methods.
 * 
 * Author: Tom Howley, March 2007
 */

public class RectangleTest {

	public static void main(String[] args) {
		double x = 0;
		double y = 1;
		
		if (x != y){
			x = y = 0.1;
		}
		
	
		// TEST CASE 1: The default case, no length or width is set
		Rectangle r1 = new Rectangle();
		System.out.println("TEST CASE 1 - Default case: length = 1 and width = 1");
		System.out.println("Width: " + r1.getWidth() + " Length: " + r1.getLength() 
				+ " Area: " + r1.getArea() + " Perimeter: " + r1.getPerimeter());
		System.out.println();
		
		// TEST CASE 2: Valid rectangle using setWidth/Length
		Rectangle r2 = new Rectangle();
		r2.setLength(10);
		r2.setWidth(5);
		System.out.println("TEST CASE 2 - Valid Rectangle: length = 10 and width = 5");
		System.out.println("Width: " + r2.getWidth() + " Length: " + r2.getLength() 
				+ " Area: " + r2.getArea() + " Perimeter: " + r2.getPerimeter());
		System.out.println();
		
		// TEST CASE 3: Invalid length #1
		Rectangle r3 = new Rectangle();
		r3.setLength(20);
		r3.setWidth(5);
		System.out.println("TEST CASE 3 - Invalid Rectangle: length = 20 and width = 5");
		System.out.println("Width: " + r3.getWidth() + " Length: " + r3.getLength() 
				+ " Area: " + r3.getArea() + " Perimeter: " + r3.getPerimeter());
		System.out.println();
		
		// TEST CASE 4: Invalid length #2
		Rectangle r4 = new Rectangle();
		r4.setLength(0);
		r4.setWidth(5);
		System.out.println("TEST CASE 4 - Invalid Rectangle: length = 0 and width = 5");
		System.out.println("Width: " + r4.getWidth() + " Length: " + r4.getLength() 
				+ " Area: " + r4.getArea() + " Perimeter: " + r4.getPerimeter());
		System.out.println();

		// TEST CASE 5: Invalid width #1
		Rectangle r5 = new Rectangle();
		r5.setLength(10);
		r5.setWidth(20);
		System.out.println("TEST CASE 5 - Invalid Rectangle: length = 10 and width = 20");
		System.out.println("Width: " + r5.getWidth() + " Length: " + r5.getLength() 
				+ " Area: " + r5.getArea() + " Perimeter: " + r5.getPerimeter());
		System.out.println();
		
		// TEST CASE 6: Invalid width #2
		Rectangle r6 = new Rectangle();
		r6.setLength(10);
		r6.setWidth(0);
		System.out.println("TEST CASE 6 - Invalid Rectangle: length = 10 and width = 0");
		System.out.println("Width: " + r6.getWidth() + " Length: " + r6.getLength() 
				+ " Area: " + r6.getArea() + " Perimeter: " + r6.getPerimeter());
		System.out.println();
		
	}

}
