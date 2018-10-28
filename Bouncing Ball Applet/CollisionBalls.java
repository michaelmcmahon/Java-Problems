/* mmcmahon_wk7_Assignment_CollisionBalls.java
 *Applet code so that the balls bounce off each other.  
 * 
 * <html>
 * <applet code = "CollisionBalls.class" width = "400" height = "400">
 * <param name=numBalls value="5">
 * </applet>
 * </html>
 */

import java.awt.*;
import java.applet.*;
import java.util.Random;


class CollideBall
{
    int width, height;
    public static final int diameter=30;
    double x, y, dx, dy, coll_x, coll_y;
    boolean collide;
    Color color;
    Graphics g;

    //the constructor
    public CollideBall(int w, int h, int x, int y, double dx, double dy, Color c)
    {
        width=w;
        height=h;
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
        color=c;
    }

    public double getCenterX() {return x+diameter/2;}
    public double getCenterY() {return y+diameter/2;}

    public void move()
    {
        if (collide)
        {
            double xvect=coll_x-getCenterX();
            double yvect=coll_y-getCenterY();

            if((dx>0 && xvect>0) || (dx<0 && xvect<0))
                dx=-dx;

            if((dy>0 && yvect>0) || (dy<0 && yvect<0))
                dy=-dy;

            collide=false;
        }

        x+=dx;
        y+=dy;

        // bounce ball off the boundry walls
        if(x<0 || x>width-diameter)
        {
            dx=-dx;
            x+=dx;
        }

        if(y<0 || y>height-diameter)
        {
            dy=-dy;
            y+=dy;
        }
    }

    public void hit(CollideBall b)
    {
        if(!collide)
        {
            coll_x=b.getCenterX();
            coll_y=b.getCenterY();
            collide=true;
        }
    }

    public void paint(Graphics gr)
    {
        g=gr;
        g.setColor(color);
        g.fillOval((int)x,(int)y,diameter,diameter);
    }
}

public class CollisionBalls extends Applet implements Runnable{
	private static final long serialVersionUID = 491852199048520152L;
	Thread thread;
    Image image;
    Graphics offscreen;
    
    int numBalls = 10; //remove number when adding HTML
	ABall balls[];
	
	private Color Colors[] = {Color.GRAY, Color.BLUE, Color.ORANGE, Color.CYAN, Color.WHITE, Color.MAGENTA, Color.GREEN,  Color.PINK, Color.YELLOW, Color.RED};
	Color ballColor[];
	int c; // count the colors used
    CollideBall ball[];


    //how many balls?
    static final int MAX=5;

    @Override
	public void init()
    {
        image=createImage(getWidth(),getHeight());
        offscreen=image.getGraphics();

        ball=new CollideBall[MAX];

        int w=getWidth();
        int h=getHeight();

        //shortcut balls with start coordinates, increment values
        ball[0]=new CollideBall(w,h,50,20,1.5,2.0,Color.orange);
        ball[1]=new CollideBall(w,h,60,100,2.0,-3.0,Color.red);
        ball[2]=new CollideBall(w,h,15,70,-2.0,-2.5,Color.pink);
        ball[3]=new CollideBall(w,h,150,60,-2.7,-2.0,Color.cyan);
        ball[4]=new CollideBall(w,h,210,30,2.2,-3.5,Color.magenta);
    }

    @Override
	public void start()
    {
        if (thread == null)
        {
            thread = new Thread (this);
            thread.start();
        }
    }

    @Override
	public void run()
    {
        while(true)
        {
            //Thread sleeps for 20 milliseconds
            try {Thread.sleep(20);}
            catch (Exception e) { }

            for(int i=0;i<MAX;i++)
                ball[i].move();

            handleCollision();

            repaint();
        }
    }

    boolean collide(CollideBall b1, CollideBall b2)
    {
        double wx=b1.getCenterX()-b2.getCenterX();
        double wy=b1.getCenterY()-b2.getCenterY();

        //the distance between the centers two colliding balls
        double distance=Math.sqrt(wx*wx+wy*wy);

        if(distance<CollideBall.diameter)
        {
            return true;
        }

        return false;
    }

    private void handleCollision()
    {
        //we iterate through all the balls, checking for collisions
        for(int i=0;i<MAX;i++)
            for(int j=0;j<MAX;j++)
            {
                if(i!=j)
                {
                    if(collide(ball[i], ball[j]))
                    {
                        ball[i].hit(ball[j]);
                        ball[j].hit(ball[i]);
                    }
                }
            }
    }

    @Override
	public void update(Graphics g)
    {
        paint(g);
    }

    @Override
	public void paint(Graphics g)
    {
        //draw background
    	offscreen.setColor(Color.BLACK);
    	offscreen.fillRect(0,0,getWidth(),getHeight());

        //paint the balls
        for(int i=0;i<MAX;i++)
            ball[i].paint(offscreen);

        g.drawImage (image,0,0, this);
    }
}