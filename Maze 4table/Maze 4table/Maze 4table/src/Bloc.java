import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bloc extends Actor {
	
	private Color myColor; 
	
	public Bloc(Color c)
	{
		myColor = c;
	}
	public void draw1(Graphics g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
		g.setColor(myColor);
		g.fillRect(x, y, width, height);
	}
	@Override
	public void draw(Graphics2D g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}

}
