import java.awt.*;


public class ABall {
	  int x,y; // The current position of the ball.
	  int radius; // The radius of the ball.
	  int dx,dy; // The velocity (speed + direction) of the ball.
	  Color color; // The colour of the ball

	  // Six argument Ball constructor
	 public ABall(int x,int y,int radius,int dx,int dy,Color bColor)
	 {
	   this.x=x;
	   this.y=y;
	   this.radius=radius;
	   this.dx=dx;
	   this.dy=dy;
	   color=bColor;
	 }
	 
	// set x
	public void setX(int x) {
		this.x = x;
	} // end method setX

	// return x
	public int getX() {
		return x;
	} // end method getX

	// set y
	public void setY(int y) {
		this.y = y;
	} // end method setY

	// return y
	public int getY() {
		return y;
	} // end method getX
	
	// set Radius
	public void setRadius(int radius) {
		this.radius = radius;
	} // end method setRadius

	// return radius
	public int getRadius() {
		return radius;
	} // end method getRadius
	
	// set dx
	public void setDX(int dx) {
		this.dx = dx;
	} // end method setDX

	// return dx
	public int getDX() {
		return dx;
	} // end method getDX
	
	// set dy
	public void setDY(int dy) {
		this.dy = dy;
	} // end method setDY

	// return dy
	public int getDY() {
		return dy;
	} // end method getDY
	
	// set BallColor
	public void setBallColor(Color bColor) {
		this.color = bColor;
	} // end method setDY

	// return BallColor
	public Color getBallColor() {
		return color;
	} // end method getBallColor
	
	// return String representation of Ball object
	   public String toString()
	   {
	      return String.format( 
	    		    "%s: %d\n"
	    		  + "%s: %d\n"
	    		  + "%s: %d\n"
	    		  + "%s: %d\n"
	    		  + "%s: %d\n"
	    		  + "%s: %s \n;", 
	    		  	  
	         super.toString(), 
	         "The x position of the ball", getX(), 
	         "The y position of the ball", getY(), 
	      	 "The Radius of the ball", getRadius(),
	  		 "The", getDX(), 
	      	 "The", getDY(),
	      	 "The ", getBallColor());
	   } // end method toString
}
