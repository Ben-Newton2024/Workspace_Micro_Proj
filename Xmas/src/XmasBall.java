import java.awt.*;
import java.util.Random;

public class XmasBall 
{

	private int mySize = 50;
	private Color myColour = new Color(0,0,204);
	private int myXpos = 50;
	private int myYpos = 30;
	private int myXspeed = 9;
	private int myYspeed = 1;
	
	public void setPos(int x, int y)
	{
		myXpos = x;
		myYpos = y;
	}
	public int getXpos()
	{
		return myXpos;
	}
	public int getYpos()
	{
		return myYpos;
	}
	public Color getColor()
	{
		return myColour;
	}
	public int getSize()
	{
		return mySize;
	}
	public void setSpeed(int x, int y)
	{
		myXspeed = x;
		myYspeed = y;
	}
	public void move(int rightBound, int bottomBound, int leftBound, int topBound)
	{
		myXpos += myXspeed;
		myYpos += myYspeed;
		//if ball is > bottom bound
		//ball.setpos < top bound
		//teleports snow/png so its neverending snow
		if (myYpos > bottomBound)
		{
			Random rando = new Random();
			int z = rando.nextInt(20);
			setPos(rando.nextInt(500),-250);
			setSpeed(rando.nextInt(20)- z,rando.nextInt(4));
		}
		myYspeed += 0.9;
	}
	public void updatePosition(int panelWidth, int panelHeight)
	{
		myXpos += myXspeed;
		myYpos += myYspeed;
	}
}