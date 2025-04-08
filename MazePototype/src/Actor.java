import java.awt.Graphics2D;

public abstract class Actor {
	
	public static final int UP = 270;
	public static final int DOWN = 90;
	public static final int LEFT = 180;
	public static final int RIGHT =0;
	
	public double mySpeed = 1;
	
	private double myYpos;
	private double myXpos;
	
	public abstract void draw(Graphics2D g, int x, int y, int width, int height);
	
	private int myFace = RIGHT;
	private int myLastFace = RIGHT;
	private int myNextFace = RIGHT;
	
	public void setPos (double x, double y)
	{
		myYpos = y;
		myXpos = x;
	}
	public double getXpos()
	{
		return myXpos;
	}
	
	public double getYpos()
	{
		return myYpos;
	}
	public double getSpeed()
	{
		return mySpeed;
	}
	public void setFace(int d)
	{
		myFace = d;
	}
	public int getFace()
	{
		return myFace;
	}
	
	public void setLastFace(int d)
	{
		myLastFace = d;
	}
	public int getLastFace()
	{
		return myLastFace;
	}
	
	public void setnextFace(int d)
	{
		myNextFace = d;
	}
	public int getnextFace()
	{
		return myNextFace;
	}
	public void move()
	{


		if(myFace == RIGHT)
		{
			setPos(getXpos()+mySpeed,getYpos());			
		}
		if(myFace == DOWN)
		{
			setPos(getXpos(),getYpos()+mySpeed);
		}
		if(myFace == LEFT)
		{
			setPos(getXpos()-mySpeed,getYpos());
		}
		if(myFace == UP)
		{
			setPos(getXpos(),getYpos()-mySpeed);
		}
		
		
		
	}
		
		

}
