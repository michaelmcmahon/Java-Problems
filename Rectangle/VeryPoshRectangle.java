/* class VeryPoshRectangle
 * the class will store the cartesian coordinates of the four corners of a rectangle
 * the constructor calls a method that accepts four coordinate pairs and verifies
 * that each of these is in the first quadrant, with no single x or y coordinate
 * larger than 20.0. The set method also verifies that the supplied coordinates specify
 * a rectangle. There are methods to calculate the length, width, perimeter and area.
 * Also included is a method to find out if the rectangle is also a square
 * This example uses 4 Point objects for the 4 corners of the rectangle.
 * This requires less variables and there is no need for getLineLength()
 * from CoordRectangle since Point has inbuilt methods to calculate line lengths. 
 */

import java.awt.Point;
import javax.swing.JOptionPane;

public class VeryPoshRectangle {
	// declare the private objects for each of the four corners
	private Point topLeft;
	private Point topRight;
	private Point bottomLeft;
	private Point bottomRight;
	
	private boolean validRectangle = false;
	
	// constructor
	public VeryPoshRectangle (Point tl, Point tr, Point bl, Point br){
		setCoordinates( tl, tr, bl, br );
	}
	
	public void setCoordinates(Point tl, Point tr, Point bl, Point br){
		// are the coordinates valid
		if (validPoint(tl) && validPoint(tr) && validPoint(bl) && validPoint(br)){
			// if so set the member objects
			topLeft = tl;
			topRight = tr;
			bottomLeft = bl;
			bottomRight = br;
		}
		//are the opposite sides equal. This uses the distance() method from the Point class
		if ((tl.distance(tr) == bl.distance(br)) 
			&& (tl.distance(bl) == tr.distance(br))){
			// if true check that distances from corner to corner are equal
			// this is an alternative method than measuring the internal angles.
			if (tl.distance(br) == bl.distance(tr)){
				// after everything we have a valid rectangle
				validRectangle = true;
			}
		}
		
		if (validRectangle == false){
			JOptionPane.showMessageDialog(null, "The supplied coordinates do not specify a rectangle!");
			System.exit(0);
		}		
	}

	// as with the PoshRectangle class. accesses the x and y variables from the Point objects
	public double slope (Point p1, Point p2){
		if (p2.y - p1.y == 0) // horizonal lines
			return 1.0;
		else if (p2.x - p1.x == 0) // vertical lines 
			return -1.0;
		else
			return (p2.y - p1.y) / (p2.x - p1.x);	// normal case	
	}
	
	// as with the PoshRectangle class and the slope method
	public boolean validPoint(Point p){
		if ( p.x < 0 || p.x > 20 || p.y < 0 || p.y > 20)
			return false;
		else
			return true;
	}
	
	// as with the PoshRectangle class. Uses the Point object's distance() method
	// as in the setCoordinates() method above.
	public double getLength(){
		if (topLeft.distance(topRight) > topLeft.distance(bottomLeft))
			return topLeft.distance(topRight);
		else
			return topLeft.distance(bottomLeft);
	}
	
	public double getWidth(){
		if (topLeft.distance(topRight) < topLeft.distance(bottomLeft))
			return topLeft.distance(topRight);
		else
			return topLeft.distance(bottomLeft);
	}
	public double getPerimeter(){
		return 2 * (getLength()+ getWidth());
	}
	
	public double getArea(){
		return getLength()* getWidth();
	}
	public boolean isSquare(){
		if (getLength() == getWidth())
			return true;
		else
			return false;	
	}
}
