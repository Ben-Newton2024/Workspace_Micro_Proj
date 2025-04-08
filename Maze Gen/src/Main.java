import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Main extends JPanel implements ActionListener, ChangeListener
{
	//for simulating key presses for the movement of maze gens
	
	
	//begginings of maze
	private int[][] myMaze;
	
	
	//pointer to the bloc movement its on aka the nrandom direction the maze is being generated from
	public Bloc Point = new Bloc(Color.BLACK);
	
	
	//for any random movement
	private Random rando = new Random();

	
	//middle JComponents
	private JLabel MiddleTL = new JLabel();
	private JLabel MiddleTR = new JLabel();
	private JLabel MiddleBL = new JLabel();
	private JLabel MiddleBR = new JLabel();
	
	private boolean wait = true;
	
		//drop down menus
	String[] choice = {"","HuntAndKill","choice1","num2","qwerytu"};
	
	JComboBox algorithmDropDown  = new JComboBox(choice);
	JComboBox algorithmDropDown1 = new JComboBox(choice);
	JComboBox algorithmDropDown2 = new JComboBox(choice);
	JComboBox algorithmDropDown3 = new JComboBox(choice);
	
	
	//north JComponents
	private JSlider Size = new JSlider(JSlider.HORIZONTAL,0,250,25);
	
	private JButton Start = new JButton("Start");
	private JButton Stop = new JButton("stop");
	
	//west JComponents
	private JButton Left1 = new JButton("Stuff");
	
	
	//refresh rate
	private Timer myAnimationTimer = new Timer(16,this);

	
	
	
	/////////making mazes before an error occurs/////////////
	public void startUp(int xq) {
		myMaze = new int[xq][xq];
		

		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{
				if(y == 0|| myMaze[y][x] == myMaze.length ||
						x == 0 || myMaze[y][x] == myMaze[0].length)
				{
					myMaze[y][x] = 2;
				}
				else {
				myMaze[y][x] = 0;
				}
			}
		}
		
		myAnimationTimer.start();
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////MAIN JPANEL AND JFRAME HOLDINGS/////////////////////////////
	/////////////////////////////INCLUDES ALL BUTTONS AND ALL UI'S////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Main() {
		
		
		
		///to stop a null pointer error
		int x = Size.getValue();
		startUp(x);
		
		//setting layout
		BorderLayout MainLayout = new BorderLayout();
		this.setLayout(MainLayout);
		
		
		
		//TODO yessssss
		MiddleTL.setBackground(Color.GREEN);
		
		//////////////////////MIDDLE///////////////////////////
		
		
		//new JPanel
		JPanel MiddlePanel = new JPanel();

		/*2 rows
		 * 2 columns
		 * 200 pixels height gap
		 * 40 pixels width gap */
		GridLayout MidLayout = new GridLayout(4,2, 10,20);
		
		//buttons lables drop down menus

		
		
				
		//middle
		MiddlePanel.setLayout(MidLayout);
		
		
		//Adding JLabels to middle for stuff
		MiddlePanel.add(algorithmDropDown );
		MiddlePanel.add(algorithmDropDown1);
		MiddlePanel.add(MiddleTL);
		MiddlePanel.add(MiddleTR);
		MiddlePanel.add(algorithmDropDown2);
		MiddlePanel.add(algorithmDropDown3);
		MiddlePanel.add(MiddleBL);
		MiddlePanel.add(MiddleBR);
		
		
		
		
		/////////////////////WEST///////////////////////////////
		
		
		//west panel
		JPanel WestPanel = new JPanel();
		
		//West grid layout for buttons/ sliders
		GridLayout WestLayout = new GridLayout(2,1, 10,40);
		
		//setting layoyt for west
		WestPanel.setLayout(WestLayout);
		
		//making buttons
		JButton Left2 = new JButton("Stuff2");
		
		//adding stuff to panel
		WestPanel.add(Left1);
		WestPanel.add(Left2);
		
		
		/////////////////////EAST///////////////////////////////
		
		
		//east grid layout for buttons/ sliders
		GridLayout EastLayout = new GridLayout(2,2, 200,40);
		
		
		/////////////////////NORTH//////////////////////////////
		
		
		//jpanel for north
		JPanel NorthPanel = new JPanel();
		
		//layout out for north butons
		GridLayout NorthLayout = new GridLayout(1,4, 150,1);
		
		//making grid for buttons north
		NorthPanel.setLayout(NorthLayout);
		
		//make buttons-Labels
		JLabel stopsign = new JLabel("stop");
		JLabel startsign = new JLabel("start");
		
		//adding buttons and stuff
		NorthPanel.add(startsign, BorderLayout.NORTH);
		NorthPanel.add(Start, BorderLayout.NORTH);
		NorthPanel.add(Size);
		NorthPanel.add(Stop, BorderLayout.NORTH);
		NorthPanel.add(stopsign, BorderLayout.NORTH);
		
		
		////////////////adding action listeners ////////////////
		
		algorithmDropDown.addActionListener(this);
		algorithmDropDown1.addActionListener(this);
		algorithmDropDown2.addActionListener(this);
		algorithmDropDown3.addActionListener(this);
		Start.addActionListener(this);
		Stop.addActionListener(this);
		
		Left1.addActionListener(this);
		
		Size.setMajorTickSpacing(50);
		Size.setMinorTickSpacing(10);
		Size.setPaintTicks(true);
		Size.setPaintLabels(true);
		Size.addChangeListener(this);
		
		//adding all the panels to main display
		
		this.add(MiddlePanel, BorderLayout.CENTER);
		this.add(NorthPanel, BorderLayout.NORTH);
		//
		//
		this.add(WestPanel, BorderLayout.WEST);
		

	}
	
	


	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////MAIN PAINT COMPNENET FOR THIS.PANEL Main////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		int blockWidth = (int)Math.round((double)getWidth()/(double)myMaze[1].length);
		int blockHeight = (int)Math.round((double)getHeight()/(double)myMaze.length);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////MIDDLE PAINT AREAS FOR THE MAZE UI TO BE MADE////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////top left/////////////////////////////
	public void paintComponent1()
	{
		Graphics MG2 = MiddleTL.getGraphics();


		
		int blockWidth = (int)Math.round((double)MiddleTL.getWidth()/(double)myMaze[0].length);
		int blockHeight = (int)Math.round((double)MiddleTL.getHeight()/(double)myMaze.length);
		
		Point.draw1(MG2, (int)Math.round((Point.getXpos()*blockWidth)), (int)Math.round(Point.getYpos()*blockWidth), blockWidth, blockHeight);	

		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{

				if(myMaze[y][x] == 2){
					MG2.setColor(Color.PINK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				
				if(x == Point.getXpos() && y == Point.getYpos()){
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
			}
		}
	}
	
	//////////////////////////top right/////////////////////////
	public void paintComponent2()
	{
		Graphics MG2 = MiddleTR.getGraphics();
		
		int blockWidth = (int)Math.round((double)MiddleTR.getWidth()/(double)myMaze[0].length);
		int blockHeight = (int)Math.round((double)MiddleTR.getHeight()/(double)myMaze.length);
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{
				Point.draw1(MG2, x*blockWidth, y*blockWidth, blockWidth, blockHeight);
				if (myMaze[y][x] == 0) {
					
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);

				}
				else if (myMaze[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else {
					MG2.setColor(Color.PINK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
			}
		}
	}
	
	
	/////////////////////////bottom left////////////////////////
	public void paintComponent3()
	{
		Graphics MG2 = MiddleBL.getGraphics();
		
		int blockWidth = (int)Math.round((double)MiddleBL.getWidth()/(double)myMaze[0].length);
		int blockHeight = (int)Math.round((double)MiddleBL.getHeight()/(double)myMaze.length);
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{
				Point.draw1(MG2, x*blockWidth, y*blockWidth, blockWidth, blockHeight);
				if (myMaze[y][x] == 0) {
					
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);

				}
				else if (myMaze[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else {
					MG2.setColor(Color.PINK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
			}
		}
	}
	
	/////////////////////////bottom right///////////////////////
	public void paintComponent4()
	{
		Graphics MG2 = MiddleBR.getGraphics();
		
		int blockWidth = (int)Math.round((double)MiddleBR.getWidth()/(double)myMaze[0].length);
		int blockHeight = (int)Math.round((double)MiddleBR.getHeight()/(double)myMaze.length);
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{
				Point.draw1(MG2, x*blockWidth, y*blockWidth, blockWidth, blockHeight);
				if (myMaze[y][x] == 0) {
					
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);

				}
				else if (myMaze[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else {
					MG2.setColor(Color.PINK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
			}
		}
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////ACTION EVENTS/////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void actionPerformed(ActionEvent e) {
		
		repaint();
		if (e.getSource() == Start) {
			//myAnimationTimer.start();
			Size.setEnabled(false);		
			algorithmDropDown.setEnabled(false);
			algorithmDropDown1.setEnabled(false);
			algorithmDropDown2.setEnabled(false);
			algorithmDropDown3.setEnabled(false);

		}
		if (e.getSource() == Stop) {
			myAnimationTimer.stop();
			
			Size.setEnabled(true);
			algorithmDropDown.setEnabled(true);
			algorithmDropDown1.setEnabled(true);
			algorithmDropDown2.setEnabled(true);
			algorithmDropDown3.setEnabled(true);
		}
		//////////////////drop down boxes responses/////////////
//		String w = (String) algorithmDropDown.getSelectedItem();
//		if (w == "HuntAndKill") {
//			try {
//				HuntAndKill();
//			} catch (AWTException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			paintComponent1();
//			
//		}
//		String a = (String) algorithmDropDown1.getSelectedItem();
//		if (a == "HuntAndKill") {
//			try {
//				HuntAndKill();
//			} catch (AWTException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			paintComponent2();
//		}
//		String s = (String) algorithmDropDown2.getSelectedItem();
//		if (s == "HuntAndKill") {
//			try {
//				HuntAndKill();
//			} catch (AWTException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			paintComponent3();
//		}
//		String d = (String) algorithmDropDown3.getSelectedItem();
//		if (d == "HuntAndKill") {
//			try {
//				HuntAndKill();
//			} catch (AWTException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			paintComponent4();
//		}
		
		if(e.getSource() == Left1) {
			try {
				HuntAndKill();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			paintComponent1();
		}

		
		if(isValidMove(Point, Point.getnextFace()))
			Point.setFace(Point.getnextFace());			
		if(isValidMove(Point, Point.getFace()))
			Point.move();
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int x = Size.getValue();
		myMaze = new int[x][x];

	}
	
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyChar() == 'p') {
			System.exit(0);
		}
		if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
        if(e.getKeyChar() == 'a')
        {
        	Point.setnextFace(Actor.LEFT);      	
        }
        if(e.getKeyChar() == 'w')
        {
        	Point.setnextFace(Actor.UP);
        }
        if(e.getKeyChar() == 's')
        {
        	Point.setnextFace(Actor.DOWN);
        }
        if(e.getKeyChar() == 'd')
        {
        	Point.setnextFace(Actor.RIGHT);
        }
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////VALID MOVEMETNS OF THE POINT.bloc////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	private boolean isValidMove(Actor a, int direction)
	{
		////////////////////////getting all info////////////////
		////////////////nessesary for testing if movement///////
		///////////////////////is A. O. K.//////////////////////
		
		double  speed = a.getSpeed();
		
		double topleftX = a.getXpos();
		double topleftY = a.getYpos();
		
		double toprightX = a.getXpos()+0.99;
		double toprightY = a.getYpos();
		
		double bottomleftX = a.getXpos();
		double bottomleftY = a.getYpos()+0.99;
		
		double bottomrightX = a.getXpos()+0.99;
		double bottomrightY = a.getYpos()+0.99;
		
		if(direction == a.UP)
		{
			topleftY-=speed;
			toprightY-=speed;
		}
		if(direction == a.DOWN)
		{
			bottomleftY+=speed;
			bottomrightY+=speed;
		}
		if(direction == a.LEFT) 
		{
			topleftX-=speed;
			bottomleftX-=speed;
		}
		if(direction == a.RIGHT)
		{
			toprightX+=speed;
			bottomrightX+=speed;
		}
		
		/////////////////////movement checking////////////////////
		if(myMaze[(int)topleftY][(int)topleftX] != 1 
				&&
				myMaze[(int)topleftY][(int)topleftX] != 2
				&&
				myMaze[(int)toprightY][(int)toprightX] != 1
				&&
				myMaze[(int)toprightY][(int)toprightX] != 2
				&& 
				myMaze[(int)bottomleftY][(int)bottomleftX] != 1
				&&
				myMaze[(int)bottomleftY][(int)bottomleftX] != 2
				&& 
				myMaze[(int)bottomrightY][(int)bottomrightX] != 1
				&&
				myMaze[(int)bottomrightY][(int)bottomrightX] != 2)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////MAZE GENERATION TYPES////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//                               HUNT AND KILL ALGORITHM                                //
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void HuntAndKill()  throws AWTException{
		//start position bottom left
		//randomm passsages and directions
		//hunt finds new area to start from
		
		Robot robot = new Robot();
		
		Point.setPos(2, 2);
		
		int moves = 0;
		
		
		
		while(moves != Size.getValue()*Size.getValue())
		{
			
			int num = rando.nextInt(4);
			
			if( num == 0)
			{
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_W);
			}
			if( num == 1)
			{
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);
			}
			if( num == 2)
			{
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
			}
			if( num == 3)
			{
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);
			}
			
			moves++;
		}
	}
}
