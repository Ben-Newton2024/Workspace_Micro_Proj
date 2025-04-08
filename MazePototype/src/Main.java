import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Main extends JPanel implements ActionListener, ChangeListener{
	
	private MazeGen myMaze  = new MazeGen();	
	private MazeGen myMaze1 = new MazeGen();	
	private MazeGen myMaze2 = new MazeGen();	
	private MazeGen myMaze3 = new MazeGen();	
	
	private Bloc Point		= new Bloc(Color.WHITE);
	private Bloc Point1		= new Bloc(Color.WHITE);
	private Bloc Point2 	= new Bloc(Color.WHITE);
	private Bloc Point3 	= new Bloc(Color.WHITE);
	
	private Random rando 	= new Random();

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
	private Timer myAnimationTimer = new Timer(16,this);
	
	
	
	public void emptyMaze(int xq) {
		myMaze.emptyMaze(xq);
		myMaze1.emptyMaze(xq);
		myMaze2.emptyMaze(xq);
		myMaze3.emptyMaze(xq);
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
		GridLayout MidLayout = new GridLayout(2,2);
		
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
		GridLayout WestLayout = new GridLayout(2,1);
		
		//setting layoyt for west
		WestPanel.setLayout(WestLayout);
		
		//making buttons
		
		//adding stuff to panel
		WestPanel.add(Left1);
		WestPanel.add(Left2);
		
		
		/////////////////////EAST///////////////////////////////
		
		
		//east grid layout for buttons/ sliders
		GridLayout EastLayout = new GridLayout(2,2);
		
		
		/////////////////////NORTH//////////////////////////////
		
		
		//jpanel for north
		JPanel NorthPanel = new JPanel();
		
		//layout out for north butons
		GridLayout NorthLayout = new GridLayout(1,4);
		
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
		Left2.addActionListener(this);
		
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
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////MIDDLE PAINT AREAS FOR THE MAZE UI TO BE MADE////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	///////top left
	public void paintComponent1(JLabel Label, MazeGen maze)
	{
		
		Graphics Paint = Label.getGraphics();
		int blockWidth = (int)Math.round((double)Label.getWidth()/(double)maze.returnMaze()[0].length);
		int blockHeight = (int)Math.round((double)Label.getHeight()/(double)maze.returnMaze().length);

		
		for(int y = 0; y < maze.returnMaze().length; y++)
		{
			for(int x = 0; x < maze.returnMaze()[0].length; x++)
			{
				//border
				if(maze.returnMaze()[y][x] == 9){
					Paint.setColor(Color.PINK);
					Paint.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				///black space
				else if (maze.returnMaze()[y][x] == 0) {
					Paint.setColor(Color.BLACK);
					Paint.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				//horizontal corridor
				else if (maze.returnMaze()[y][x] == 1) {
					Paint.setColor(Color.WHITE);
					Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, (y*blockHeight));
					Paint.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight),x*blockWidth+blockWidth, (y*blockHeight+blockHeight));
				}
				//verticle corridor
				else if (maze.returnMaze()[y][x] == 2 ) {
					Paint.setColor(Color.WHITE);
					Paint.drawLine(x*blockWidth, y*blockHeight, x*blockWidth, y*blockHeight+blockHeight);
					Paint.drawLine(x*blockWidth+blockWidth, y*blockHeight, x*blockWidth+blockWidth, y*blockHeight+blockHeight);
				}
				//corners
				else if (maze.returnMaze()[y][x] == 3) {
					Paint.setColor(Color.WHITE);
					Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth, (y*blockHeight+blockHeight));
					Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, y*blockHeight);
				}
				else if (maze.returnMaze()[y][x] == 4) {
					Paint.setColor(Color.WHITE);
					Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, (y*blockHeight));
					Paint.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight),x*blockWidth+blockWidth, (y*blockHeight+blockHeight));
				}
				else if (maze.returnMaze()[y][x] == 5) {
					Paint.setColor(Color.WHITE);
					Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, (y*blockHeight));
					Paint.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight),x*blockWidth+blockWidth, (y*blockHeight+blockHeight));
				}
				else if (maze.returnMaze()[y][x] == 6) {
					Paint.setColor(Color.WHITE);
					Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, (y*blockHeight));
					Paint.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight),x*blockWidth+blockWidth, (y*blockHeight+blockHeight));
				}
			}
		}
	}
	
	////////top right
	public void paintComponent2()
	{
		Graphics MG2 = MiddleTR.getGraphics();
		
		
		int blockWidth = (int)Math.round((double)MiddleTR.getWidth()/(double)myMaze.returnMaze()[0].length);
		int blockHeight = (int)Math.round((double)MiddleTR.getHeight()/(double)myMaze.returnMaze().length);
		
		for(int y = 0; y < myMaze.returnMaze().length; y++)
		{
			for(int x = 0; x < myMaze.returnMaze()[0].length; x++)
			{

				if (myMaze.returnMaze()[y][x] == 0) {
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if (myMaze.returnMaze()[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if(myMaze.returnMaze()[y][x] == 2){
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
		

		int blockWidth = (int)Math.round((double)MiddleBL.getWidth()/(double)myMaze.returnMaze()[0].length);
		int blockHeight = (int)Math.round((double)MiddleBR.getHeight()/(double)myMaze.returnMaze().length);
		
		for(int y = 0; y < myMaze.returnMaze().length; y++)
		{
			for(int x = 0; x < myMaze.returnMaze()[0].length; x++)
			{

				if (myMaze.returnMaze()[y][x] == 0) {
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if (myMaze.returnMaze()[y][x] == 1) {
					MG2.setColor(Color.WHITE);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}
				else if(myMaze.returnMaze()[y][x] == 2){
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
		
		int blockWidth = (int)Math.round((double)MiddleBR.getWidth()/(double)myMaze.returnMaze()[0].length);
		int blockHeight = (int)Math.round((double)MiddleBR.getHeight()/(double)myMaze.returnMaze().length);
		
		for(int y = 0; y < myMaze.returnMaze().length; y++)
		{
			for(int x = 0; x < myMaze.returnMaze()[0].length; x++)
			{
				Point.draw1(MG2, x*blockWidth, y*blockWidth, blockWidth, blockHeight);
				if (myMaze.returnMaze()[y][x] == 0) {
					
					MG2.setColor(Color.BLACK);
					MG2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);

				}
				else if (myMaze.returnMaze()[y][x] == 1) {
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
		
		String w = (String) algorithmDropDown.getSelectedItem();
		String a = (String) algorithmDropDown1.getSelectedItem();
		String s = (String) algorithmDropDown2.getSelectedItem();
		String d = (String) algorithmDropDown3.getSelectedItem();
		
//		if (w == "HuntAndKill" && istarted == true) {
//			HuntAndKill(MiddleTL, Point, myMaze);
//			paintComponent1();
//			
//		}
//		if (a == "HuntAndKill" && istarted == true) {
//			HuntAndKill(MiddleTR, Point1, myMaze1);
//			paintComponent2();
//		}
//		if (s == "HuntAndKill" && istarted == true) {
//			HuntAndKill(MiddleBL, Point2, myMaze3);
//			paintComponent3();
//		}
//		if (d == "HuntAndKill" && istarted == true) {
//			HuntAndKill(MiddleBR, Point3, myMaze3);
//			paintComponent4();
//		}
		
		if(e.getSource() == Left1 && istarted == true) {

			HuntAndKill(MiddleTL, Point, myMaze);
		}
		if(e.getSource() == Left2 && istarted == true) {

			HuntAndKill(MiddleTR, Point1, myMaze1);
		}	
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int x = Size.getValue();
		emptyMaze(x);
		
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////VALID MOVEMETNS OF THE POINT.bloc///////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean isValidMove(Actor a, int direction, MazeGen maze)
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
		if(maze.returnMaze()[(int)topleftY][(int)topleftX] != 0
				&&
				maze.returnMaze()[(int)toprightY][(int)toprightX] != 0
				&& 
				maze.returnMaze()[(int)bottomleftY][(int)bottomleftX] != 0
				&& 
				maze.returnMaze()[(int)bottomrightY][(int)bottomrightX] != 0)				
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////MAZE GENERATION TYPES////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	///////////////////////////////////
	/// Map Numbers
	/// 
	///  0: empty
	///  1: Horizontal Corridors
	///  2: Vertical   Corridors
	///  3: Up Right   Corner
	///  4: Down Right Corner
	///  5: UP Left    Corner
	///  6: Down Left  Corner
	///  7: #
	///  8: #
	///  9: border
	///
	///////////////////////////////////
	
	

	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///																									       ///
	///									Hunt and Kill														   ///
	///																							     		   ///
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void HuntAndKill(JLabel Label, Bloc mPoint, MazeGen maze){
		//start position bottom left
		//randomm passsages and directions
		//hunt finds new area to start from
		

		int blockWidth = (int)Math.round((double)Label.getWidth()/(double)maze.returnMaze()[0].length);
		int blockHeight = (int)Math.round((double)Label.getHeight()/(double)maze.returnMaze().length);
		
		int q = Size.getValue();
		emptyMaze(q);

		mPoint.setPos(1, 1);
		
		Graphics Paint = Label.getGraphics();
		do {
			if(isValidMove(mPoint, mPoint.getnextFace(), maze)) {
				mPoint.setFace(mPoint.getnextFace());
			}
			if(isValidMove(mPoint, mPoint.getFace(), maze)) {
				if(mPoint.getLastFace() == Actor.UP && mPoint.getFace() == Actor.RIGHT) 
				{
					maze.returnMaze()[(int)mPoint.getYpos()][(int)mPoint.getXpos()] = 3;
				}
				else if(mPoint.getLastFace() == Actor.UP && mPoint.getFace() == Actor.LEFT) 
				{
					maze.returnMaze()[(int)mPoint.getYpos()][(int)mPoint.getXpos()] = 4;
				}
				else if(mPoint.getLastFace() == Actor.DOWN && mPoint.getFace() == Actor.RIGHT) 
				{
					maze.returnMaze()[(int)mPoint.getYpos()][(int)mPoint.getXpos()] = 5;
				}
				else if(mPoint.getLastFace() == Actor.DOWN && mPoint.getFace() == Actor.LEFT) 
				{
					maze.returnMaze()[(int)mPoint.getYpos()][(int)mPoint.getXpos()] = 6;
				}
				else if((mPoint.getLastFace() == Actor.RIGHT && mPoint.getFace() == Actor.RIGHT) || mPoint.getLastFace() == Actor.LEFT && mPoint.getFace() == Actor.LEFT) 
				{
					maze.returnMaze()[(int)mPoint.getYpos()][(int)mPoint.getXpos()] = 1;
				}
				else if(mPoint.getLastFace() == Actor.UP && mPoint.getFace() == Actor.UP || mPoint.getLastFace() == Actor.DOWN && mPoint.getFace() == Actor.DOWN)
				{
					maze.returnMaze()[(int)mPoint.getYpos()][(int)mPoint.getXpos()] = 2;
				}
	
				mPoint.move();
				mPoint.setLastFace(mPoint.getFace());
			}
			else
			{
				Hunt(mPoint, maze);
			}
			
			mPoint.setnextFace(mPoint.getFace());
			while(mPoint.getFace() == mPoint.getnextFace()) {
				int num = rando.nextInt(4);
				
				if( num == 0)
				{
					mPoint.setnextFace(Actor.UP);
				}
				if( num == 1)
				{
					mPoint.setnextFace(Actor.DOWN);
				}
				if( num == 2)
				{			
					mPoint.setnextFace(Actor.LEFT);
				}
				if( num == 3)
				{
					mPoint.setnextFace(Actor.RIGHT);
				}
			}
			
			///////////////////////////// REDRAWING

			
			for(int y = 0; y < maze.returnMaze().length; y++)
			{
				for(int x = 0; x < maze.returnMaze()[0].length; x++)
				{
					//border
					if(maze.returnMaze()[y][x] == 9){
						Paint.setColor(Color.PINK);
						Paint.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
					}
					///black space
					else if (maze.returnMaze()[y][x] == 0) {
						Paint.setColor(Color.BLACK);
						Paint.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
					}
					//horizontal corridor
					else if (maze.returnMaze()[y][x] == 1) {
						Paint.setColor(Color.WHITE);
						Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, (y*blockHeight));
						Paint.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight),x*blockWidth+blockWidth, (y*blockHeight+blockHeight));
					}
					//cvert
					else if (maze.returnMaze()[y][x] == 2 ) {
						Paint.setColor(Color.RED);
						Paint.drawLine(x*blockWidth, y*blockHeight, x*blockWidth, y*blockHeight+blockHeight);
						Paint.drawLine(x*blockWidth+blockWidth, y*blockHeight, x*blockWidth+blockWidth, y*blockHeight+blockHeight);
					}
					//cornereesss
					//up right
					else if (maze.returnMaze()[y][x] == 3) {
						Paint.setColor(Color.BLUE);
						Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth, (y*blockHeight+blockHeight));
						Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, y*blockHeight);
					}
					else if (maze.returnMaze()[y][x] == 4) {
						Paint.setColor(Color.GREEN);
						Paint.drawLine(x*blockWidth, y*blockHeight, x*blockWidth, y*blockHeight+blockHeight);
						Paint.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight),x*blockWidth+blockWidth, (y*blockHeight+blockHeight));
					}
					else if (maze.returnMaze()[y][x] == 5) {
						Paint.setColor(Color.cyan);
						Paint.drawLine(x*blockWidth, (y*blockHeight),x*blockWidth+blockWidth, (y*blockHeight));
						Paint.drawLine(x*blockWidth+blockWidth, y*blockHeight, x*blockWidth+blockWidth, y*blockHeight+blockHeight);
					}
					else if (maze.returnMaze()[y][x] == 6) {
						Paint.setColor(Color.MAGENTA);
						Paint.drawLine(x*blockWidth+blockWidth, y*blockHeight, x*blockWidth+blockWidth, y*blockHeight+blockHeight);
						Paint.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight),x*blockWidth+blockWidth, (y*blockHeight+blockHeight));
					}
				}
			}
		}
		while(istarted == true);
	}
	
	public void Hunt(Bloc mPoint, MazeGen maze) {
		
		for(int y = 0; y < maze.returnMaze().length; y++)
		{
			for(int x = 0; x < maze.returnMaze()[0].length; x++)
			{
			//	top 		= maze[y-1][x];
			//	bottom 		= maze[y+1][x];
			//	left 		= maze[y][x-1];
			//	right 		= maze[y][x+1];
				
				if(maze.returnMaze()[y][x] == 1)
				{
					System.out.println("horizontal");
					if(maze.returnMaze()[y][x-1] == 0) 
					{
						System.out.println("Hor left");
						mPoint.setPos(x-1,y);
						y = 10000;
						x = 10000;
					}
					else if(maze.returnMaze()[y][x+1] == 0) 
					{
						System.out.println("hor right");
						mPoint.setPos(x+1, y);
						y = 10000;
						x = 10000;
					}
				}
				else if(maze.returnMaze()[y][x] == 2)
				{
					System.out.println("vert");
					if(maze.returnMaze()[y+1][x] == 0) 
					{
						System.out.println("Vert down");
						mPoint.setPos(x,y+1);
						y = 10000;
						x = 10000;
					}
					else if(maze.returnMaze()[y-1][x] == 0) 
					{
						System.out.println("vert up");
						mPoint.setPos(x, y-1);
						y = 10000;
						x = 10000;
					}
				}
				else {
				}
			}
		}
	}
}
