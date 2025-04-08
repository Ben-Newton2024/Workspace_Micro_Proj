import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

public class MapbyNoise extends JPanel

{
	int[][] myMap1;
	int[][] myMap2;
	
	JPanel View = new JPanel();
	public MapbyNoise() {
		this.setFocusable(true);
		System.out.println(random1Grad());
		noise1(2);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.black);
	}
	
	public double random1Grad() {
		Random rand = new Random();
		double num = rand.nextDouble();
		
		int num2 = rand.nextInt(2);
		if (num2 == 1) {
			return -num;
		}
		else {
			return num;
		}
	}
	
	public void noise1(double y) {
		//set size of map
		int size = 200;
		
		for (int i = 0; i<size; i++) {
			myMap1[i] = random1Grad();
		}
		System.out.println(Arrays.deepToString(myMap1)+"\n");
	}
}
	