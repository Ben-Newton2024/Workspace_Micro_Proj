import java.awt.Graphics2D;

public abstract class Actor {
	
	public static final int UP = 270;
	public static final int DOWN = 90;
	public static final int LEFT = 180;
	public static final int RIGHT = 0;
	
	public double mySpeed = 0.1;
	
	private double myYpos;
	private double myXpos;
	
	public abstract void draw(Graphics2D g, int x, int y, int width, int height);
	
	private int myFace = RIGHT;
	private int myLastFace = RIGHT;
	private int myNextFace = RIGHT;
	
	//SETTING POSITIONS
	public void setPos (double x, double y)
	{
		myYpos = y;
		myXpos = x;
	}
	
	//FOR GETTING X POS OF AN COMONENT INCLUDING THIS ACTOR
	public double getXpos()
	{
		return myXpos;
	}
	//FOR GETTING Y POS OF AN COMONENT INCLUDING THIS ACTOR

	public double getYpos()
	{
		return myYpos;
	}
	//FOR GETTING SPEED OF AN COMONENT INCLUDING THIS ACTOR

	public double getSpeed()
	{
		return mySpeed;
	}
	//FOR SETTING DIRECTIONS (FACES)

	public void setFace(int d)
	{
		myFace = d;
	}
	//FOR GETTING DIRECTION OF AN COMONENT INCLUDING THIS ACTOR

	public int getFace()
	{
		return myFace;
	}
	//FOR SETTING LAST FACE OF AN COMONENT INCLUDING THIS ACTOR

	public void setLastFace(int d)
	{
		myLastFace = d;
	}
	//FOR GETTING LAST FACE OF AN COMONENT INCLUDING THIS ACTOR

	public int getLastFace()
	{
		return myLastFace;
	}
	//	//FOR SETTING NEXT FACE OF AN COMONENT INCLUDING THIS ACTOR
	public void setnextFace(int d)
	{
		myNextFace = d;
	}
	//FOR GETTING NEXT FACE OF AN COMONENT INCLUDING THIS ACTOR
	public int getnextFace()
	{
		return myNextFace;
	}
	
	//ROUNDING TO A PRECISE AMOUNT SO NO AUTO ROUNDING TO 0 ERRORS
	public static double round (double value, int precision)
	{
		int scale = (int)Math.pow(10,  precision);
		return (double)Math.round(value * scale) / scale;
	}
	
	//BASIC MOVEMENTS
	public void move()
	{


		if(myFace == RIGHT)
		{
			setPos(round(getXpos()+mySpeed,2),getYpos());			
		}
		if(myFace == DOWN)
		{
			setPos(getXpos(),round(getYpos()+mySpeed,2));
		}
		if(myFace == LEFT)
		{
			setPos(round(getXpos()-mySpeed,2),getYpos());
		}
		if(myFace == UP)
		{
			setPos(getXpos(),round(getYpos()-mySpeed,2));
		}
		
		
		
	}
		
		

}
