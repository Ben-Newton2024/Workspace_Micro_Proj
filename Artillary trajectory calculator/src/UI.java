import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UI extends JPanel implements ChangeListener
{
	
	Artillary John = new Artillary();
	JSlider Y = new JSlider(0,550,0);
	JSlider U = new JSlider(0,100,100);
	JSlider Angle = new JSlider(0,90,2);
	
	JLabel Ym = new JLabel();
	JLabel U1 = new JLabel();
	JLabel Angletext = new JLabel();
	
	//JLabel LandPoint = new JLabel();
	//JLabel MaxH = new JLabel();
	
	private double YY;
	private double TrueYvalue;
	private double Vel;
	private double Grav = 9.807;
	private double Angl;
	private double angleRadians;
	//private double Xpos;
	//private double Ypos;
	//private double Range;
	//private double YX;
	
	public UI()
	{
		
		//for the sliders
		Y.addChangeListener((ChangeListener) this);
		U.addChangeListener((ChangeListener) this);
		Angle.addChangeListener((ChangeListener) this);
		
		//to get the value from the sliders
		Ym.setText("Height of point"+Y.getValue() +"m");
		U1.setText("Initial velocity" + U.getValue()+"m/s^2");
		Angletext.setText("angle of projection " + Angle.getValue() +"degrees");
		
		//LandPoint.setText("range" + Range + "m");
		//MaxH.setText("maximum Height" + Ypos + "m");
		
		
		//add everything to a panel
		JPanel main = new JPanel(new GridLayout(2,4));
		main.add(Ym);
		main.add(U1);
		main.add(Angletext);
		//main.add(LandPoint);
	    main.add(Y);
	    main.add(U);
	    main.add(Angle);
	    //main.add(MaxH);
	    main.setVisible(true);
	    this.setLayout(new BorderLayout());
	    this.add(main, BorderLayout.NORTH);
	}
	
	//draws everything
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;	
		
		//shows the slider text
		Ym.setText("Height of point "+ Y.getValue() +"m");
		U1.setText("Initial velocity " + U.getValue()+"m/s^2");
		Angletext.setText("Angle of projection " + Angle.getValue() +" degrees");
		
		YY = Y.getValue();
		Angl = Angle.getValue();
		Vel = U.getValue();
		
		TrueYvalue = 550 - YY;
		angleRadians = Angl*Math.PI/180;
		
		
		//shows height distance etc
		
		//start dot - start of luanch position
		g2.fillOval(0, (int) TrueYvalue, 10, 10);
		
		double Xpos = John.calcLand(YY, Grav, angleRadians, Vel);
		double Ypos = John.calcMaxHeight(Vel, Grav, angleRadians, YY);
		double Range = John.calcRange(Vel, angleRadians, Grav);
		double Time = John.TimetoMaxHeight(Vel,Grav,angleRadians);
		double xxxx = John.calcMaxHDis(Vel, angleRadians, Grav, 0, 0);
		
		//distance landing
		g2.setColor(Color.RED);
		g2.fillOval((int) Xpos, 550, 10,10);
		
		//max height line
		g2.setColor(Color.GREEN);
		g2.drawLine(0, (int) (550-Ypos),(int) (Xpos+1000),(int) (550-Ypos));
		
		//max height dot and the distance it reaches - need to move on the x axis but doesnt??????
		g2.setColor(Color.CYAN);
		g2.fillOval((int)xxxx, (int) (550-Ypos), 10,10);
		
		
	}
	
	//refreshes on movement from sliders
	public void stateChanged(ChangeEvent ce) {
        this.repaint();
     }

	
	
}
