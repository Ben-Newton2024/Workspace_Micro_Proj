import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Main extends JPanel implements ActionListener, ChangeListener{
	
	private int[][] myMaze;
	
	public Bloc Point = new Bloc(Color.WHITE);
	public Bloc Point1 = new Bloc(Color.WHITE);
	public Bloc Point2 = new Bloc(Color.WHITE);
	public Bloc Point3 = new Bloc(Color.WHITE);
	
	private Random rando = new Random();

	//middle Jcomponents
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
	
	
	//north Jcomponents
	
	private JSlider Size = new JSlider(JSlider.HORIZONTAL,0,250,25);
	
	private JButton Start = new JButton("Start");
	private JButton Stop = new JButton("stop");
	boolean istarted = false;
	
	//west jcompnents
	private JButton Left1 = new JButton("Stuff");
	private JButton Left2 = new JButton("Stuff2");
	
	//refresh rate
	private Timer myAnimationTimer = new Timer(0,this);
	
	
	
	public void emptyMaze(int xq) {
		myMaze = new int[xq][xq];
		
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{
				if(y == 0|| myMaze[y][x] == myMaze.length-1) {
					myMaze[y][x] = 3;
				}
				else if( x == 0 || myMaze[y][x] == myMaze[0].length-1) {
					myMaze[y][x] = 3;
				}
				else {
				myMaze[y][x] = 0;
				}
			}
		}		
	}
	
	
	@SuppressWarnings("deprecation")
	public Main() {
		
		///to stop a null pointer error
		
		int x = Size.getValue();
		emptyMaze(x);
				
		this.setFocusable(true);
		
		
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
		GridLayout MidLayout = new GridLayout(2,2, 10,20);
		
		//buttons lables drop down menus

		
		
				
		//middle
		MiddlePanel.setLayout(MidLayout);
		
		
		//Adding JLabels to middle for stuff
//		MiddlePanel.add(algorithmDropDown );
//		MiddlePanel.add(algorithmDropDown1);
		MiddlePanel.add(MiddleTL);
		MiddlePanel.add(MiddleTR);
//		MiddlePanel.add(algorithmDropDown2);
//		MiddlePanel.add(algorithmDropDown3);
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
		
		
		////////////////adding action listeners /////////////////
		
		algorithmDropDown.addActionListener(this);
		algorithmDropDown1.addActionListener(this);
		algorithmDropDown2.addActionListener(this);
		algorithmDropDown3.addActionListener(this);
		Start.addActionListener(this);
		Stop.addActionListener(this);
		
		Left1.addActionListener(this);
		
		algorithmDropDown.resize(100,100);
		
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
	
	


	///////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////MAIN PAINT COMPNENET FOR THIS.PANEL Main/////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		//int blockWidth = (int)Math.round((double)getWidth()/(double)myMaze[0].length);
		//int blockHeight = (int)Math.round((double)getHeight()/(double)myMaze.length);
		
		paintComponent1();
		paintComponent2();
		paintComponent3();
		paintComponent4();
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////MIDDLE PAINT AREAS FOR THE MAZE UI TO BE MADE////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	///////top left
	public void paintComponent1()
	{
		Graphics MG2 = MiddleTL.getGraphics();


		
		int blockWidth = (int)Math.round((double)MiddleTL.getWidth()/(double)myMaze[0].length);
		int blockHeight = (int)Math.round((double)MiddleTL.getHeight()/(double)myMaze.length);
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{

				if (myMaze[y][x] == 0) {
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if (myMaze[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if(myMaze[y][x] == 3){
					MG2.setColor(Color.PINK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
			}
		}
		Point.draw1(MG2, (int)Point.getXpos()*blockWidth, (int)Point.getYpos()*blockWidth, blockWidth, blockHeight);	

	}
	
	////////top right
	public void paintComponent2()
	{
		Graphics MG2 = MiddleTR.getGraphics();
		
		
		int blockWidth = (int)Math.round((double)MiddleTR.getWidth()/(double)myMaze[0].length);
		int blockHeight = (int)Math.round((double)MiddleTR.getHeight()/(double)myMaze.length);
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{

				if (myMaze[y][x] == 0) {
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if (myMaze[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if(myMaze[y][x] == 3){
					MG2.setColor(Color.PINK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
			}
		}
		Point.draw1(MG2, (int)Point.getXpos()*blockWidth, (int)Point.getYpos()*blockWidth, blockWidth, blockHeight);	

	}
	
	
	////////bottom left
	public void paintComponent3()
	{
		Graphics MG2 = MiddleBL.getGraphics();
		

		int blockWidth = (int)Math.round((double)MiddleBL.getWidth()/(double)myMaze[0].length);
		int blockHeight = (int)Math.round((double)MiddleBR.getHeight()/(double)myMaze.length);
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[0].length; x++)
			{

				if (myMaze[y][x] == 0) {
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if (myMaze[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if(myMaze[y][x] == 3){
					MG2.setColor(Color.PINK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
			}
		}
		Point.draw1(MG2, (int)Point.getXpos()*blockWidth, (int)Point.getYpos()*blockWidth, blockWidth, blockHeight);	
	}
	
	///////bottom right
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

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////ACTION EVENTS//////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Start) {
			myAnimationTimer.start();
			istarted = true;
			Size.setEnabled(false);		
//			algorithmDropDown.setEnabled(false);
//			algorithmDropDown1.setEnabled(false);
//			algorithmDropDown2.setEnabled(false);
//			algorithmDropDown3.setEnabled(false);

		}
		else if (e.getSource() == Stop) {
			myAnimationTimer.stop();
			istarted = false;
			Size.setEnabled(true);
//			algorithmDropDown.setEnabled(true);
//			algorithmDropDown1.setEnabled(true);
//			algorithmDropDown2.setEnabled(true);
//			algorithmDropDown3.setEnabled(true);
		}
		
//		String w = (String) algorithmDropDown.getSelectedItem();
//		if (w == "HuntAndKill") {
//			HuntAndKill();
//			paintComponent1();
//			
//		}
//		String a = (String) algorithmDropDown1.getSelectedItem();
//		if (a == "HuntAndKill") {
//			HuntAndKill();
//			paintComponent2();
//		}
//		String s = (String) algorithmDropDown2.getSelectedItem();
//		if (s == "HuntAndKill") {
//			HuntAndKill();
//			paintComponent3();
//		}
//		String d = (String) algorithmDropDown3.getSelectedItem();
//		if (d == "HuntAndKill") {
//			HuntAndKill();
//			paintComponent4();
//		}
		
		if(e.getSource() == Left1 && istarted == true) {

			HuntAndKill(MiddleTL, Point);
		}
		if(e.getSource() == Left2 && istarted == true) {

			HuntAndKill(MiddleTL, Point1);
		}
		
		repaint();
		
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int x = Size.getValue();
		myMaze = new int[x][x];
		emptyMaze(x);
		
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////VALID MOVEMETNS OF THE POINT.bloc///////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean isValidMove(Actor a, int direction)
	{
		
		double speed = a.getSpeed();
		
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
		if(myMaze[(int)topleftY][(int)topleftX] != 3
				&&
				myMaze[(int)toprightY][(int)toprightX] != 3
				&& 
				myMaze[(int)bottomleftY][(int)bottomleftX] != 3
				&& 
				myMaze[(int)bottomrightY][(int)bottomrightX] != 3)
//				&&
//				myMaze[(int)topleftY][(int)topleftX] != 1 
//				&&
//				myMaze[(int)toprightY][(int)toprightX] != 1
//				&&
//				myMaze[(int)bottomleftY][(int)bottomleftX] != 1
//				&&
//				myMaze[(int)bottomrightY][(int)bottomrightX] != 1)
				
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////MAZE GENERATION TYPES////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void HuntAndKill(JLabel Label, Bloc Point){
		//start position bottom left
		//randomm passsages and directions
		//hunt finds new area to start from
		
		int q = Size.getValue();
		emptyMaze(q);
		
		Point.setPos(1, 1);
		
		Graphics Paint = Label.getGraphics();
		
		int c = 1;		
		
		while (c == 1) {
			int num = rando.nextInt(4);
			
			if( num == 0)
			{
				Point.setnextFace(Actor.UP);
				System.out.println("UP");
			}
			if( num == 1)
			{
				Point.setnextFace(Actor.DOWN);
				System.out.println("DOWN");
			}
			if( num == 2)
			{			
				Point.setnextFace(Actor.LEFT);
				System.out.println("LEFT");
			}
			if( num == 3)
			{
				Point.setnextFace(Actor.RIGHT);
				System.out.println("RIGHT");
			}
	
			if(isValidMove(Point, Point.getnextFace()))
				Point.setFace(Point.getnextFace());	
			if(isValidMove(Point, Point.getFace())) {
				Point.move();
				myMaze[(int) Point.getYpos()][(int) Point.getXpos()] = 1;
				}
	
			int blockWidth = (int)Math.round((double)Label.getWidth()/(double)myMaze[0].length);
			int blockHeight = (int)Math.round((double)Label.getHeight()/(double)myMaze.length);
			
			for(int y = 0; y < myMaze.length; y++)
			{
				for(int x = 0; x < myMaze[0].length; x++)
				{
	
					if (myMaze[y][x] == 0) {
						Paint.setColor(Color.BLACK);
						Paint.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
					}
					else if (myMaze[y][x] == 1) {
						Paint.setColor(Color.WHITE);
						Paint.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
					}
					else if(myMaze[y][x] == 3){
						Paint.setColor(Color.PINK);
						Paint.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
					}
				}
			}
			Point.draw1(Paint , (int)Point.getXpos()*blockWidth, (int)Point.getYpos()*blockWidth, blockWidth, blockHeight);	
		}
	}
}
