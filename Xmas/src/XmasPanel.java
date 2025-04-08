import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Random;
import javax.imageio.*;
import javax.swing.*;

public class XmasPanel extends JPanel implements ActionListener
{

	private XmasBall myBall = new XmasBall();
	private Timer myTimer = new Timer(25, this);
	private XmasBall[] myBalls = new XmasBall[100];
	

	//panel for which it creates the ball to be displayed in the window
	public XmasPanel()
	{
		//night time sky
		this.setBackground(Color.black);
		
		myTimer.start();
		//creates 10 balls in random positions and speeds
		for (int i = 0; i < myBalls.length; i++)
		{
			myBalls[i] = new XmasBall();
			Random rando = new Random();
			//import the random function to "choose" a random number between to parameters
			myBalls[i].setPos(rando.nextInt(100),-500);
			myBalls[i].setSpeed(rando.nextInt(4),rando.nextInt(3));
		}
	}
	//make stars - dont work for some reason not sure why
	//paints ball and fills it
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//snow floor
		
		g.setColor(Color.white);
		g.fillRect(1, 457, 1000, 10);
		
		//crimbo tree
		g.setColor(Color.getHSBColor(36,72,49));
		g.fillRect(725, 375, 50, 100);
		g.setColor(Color.GREEN);
		g.fillRect(700,325, 100, 100);
		g.fillRect(715,259, 66, 66);
		
		//g2.setColor(myBall.getColor());
		//g2.drawImage(image,myBall.getXpos(), myBall.getYpos(),  myBall.getSize(), 80, null);
		//loops and creates a ball icon each loop
		//asigns each ball their icons
		//so you can see each ball as the image not just a norbal ball fill
		for (int i = 0; i < myBalls.length;i++)
		{
			Image image = new ImageIcon("snow.png").getImage();
			g2.drawImage(image,myBalls[i].getXpos(), myBalls[i].getYpos(),  myBalls[i].getSize(), 50, null);
		}
		//crimbo tree
		g.setColor(Color.getHSBColor(36,72,49));
		g.fillRect(425, 375, 50, 100);
		g.setColor(Color.GREEN);
		g.fillRect(400,325, 100, 100);
		g.fillRect(415,259, 66, 66);
		


	}
	//action listener for repainting balls new position
	public void actionPerformed(ActionEvent arg0)
	{
		
		for (int i = 0; i < myBalls.length;i++)
		{
			myBalls[i].move(getWidth(),getHeight(),0,0);
			repaint();
		}
	}
	public void actionPerformed1(ActionEvent e)
	{
		for (int i = 0; i < myBalls.length;i++)
		{
			myBalls[i].updatePosition(getWidth(), getHeight());
			repaint();
		}
	}
	
}
