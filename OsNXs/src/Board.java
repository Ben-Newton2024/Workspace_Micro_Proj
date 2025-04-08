import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener
{
	private Boolean sm = true;
	Random rando = new Random();
	private String dif = "";
	private String mode = "";
	private XnOmusic Carl = new XnOmusic();
	private int Num = 0;
	private Boolean current = true;
	OXpanel[][] myPanels = new OXpanel[3][3]; // array for all the buttons fro the jpanal///////////////////////////
	
	
	///////////////////////////////////////////////---------------------------------------////////////////////////////////////////
	///////////////////////////////////////////////CONSTRUCTOR - MAKING THE BOARD IN PANEL////////////////////////////////////////
	///////////////////////////////////////////////---------------------------------------////////////////////////////////////////
	public Board()
	{
		setLayout(new GridLayout(3,3));
		for (int i = 0; i < myPanels.length;i++)
		{
			for (int j = 0; j< myPanels[i].length;j++)
			{
				this.myPanels[i][j] = new OXpanel();
				this.add(myPanels[i][j]);
				myPanels[i][j].setFocusable(false);
				this.myPanels[i][j].addActionListener(this);
			}
		}
		StartUp();
	}	
	public void StartUp()
	{
		ImageIcon image = new ImageIcon("ICON.png");
		Object[] options = 
			{"Single Player",
             "Multi Player",
			};
		int N = JOptionPane.showOptionDialog
				(this,
				"X is yoda, O is jar jar",
				"WELCOME TO 0's N X's\n"+"no",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				image,
				options,options[1]);
		Carl.loopSound("star wars cantina.wav");
		if (N == 0)
		{
			sm = true;
			dif = J();
		}
		else if (N == -1)
		{
			close();
		}
		else
		{
			sm = false;
			mode = Choice();
		}
	}
	////////////////////////////////////////////////--------------------------------------/////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////SINGLEPLAYER BOOLEAN/MULTIPLAYER STUFF/////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////--------------------------------------/////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e)
	{
		OXpanel source = (OXpanel)e.getSource();
		/////////////////////////////MultiPlayer/////////////////////////////////////////////
		if (sm == false)
		{ 
			if (mode == "Boring Dude")
			{
				///////////////////////////////////player one////////////////////////////////////
				//button clicking placing x and o
				if (current == true)
				{	
					this.setBackground(Color.GREEN);
					source.add(YoPic());
					source.setSymbol("X");
					current = false;
					CheckWinner();
					
				}
				/////////////////////////////player two///////////////////////////////////////////////////
				else if (current == false)
				{
					this.setBackground(Color.BLUE);
					source.add(JarPic());
					source.setSymbol("O");
					current = true;
					CheckWinner();
				}
				//check if all bottons pressed and no winner
				if (Num >= 9)
				{
					Looser();
				}
			}
			else if (mode == "BRoKen_M&oDe")
			{
				///////////////////////////////////player one////////////////////////////////////
				//button clicking placing x and o
				if (current == true)
				{	
					this.setBackground(Color.GREEN);
					source.setSymbolBroken("X");
					current = false;
					CheckWinner();
					
				}
				/////////////////////////////player two///////////////////////////////////////////////////
				else if (current == false)
				{
					this.setBackground(Color.BLUE);
					source.setSymbolBroken("O");
					current = true;
					CheckWinner();
				}
			}
		}
		else
		{
			//////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////singlePlayer//////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////
			if (current == true)
			{
				if (dif == "BRoKen_M&oDe")
				{
					this.setBackground(Color.GREEN);
					source.setSymbolBroken("X");
				}
				else
				{
					source.setSymbol("X");
					source.add(YoPic());
					if(Num == 9)
					{
						Looser();
					}
				}
				current = false;
				CheckWinner();
				
			}
			//////////////////////////////////////DA COMPS TURN -----------VERY BAAAAAAD---------------/////////////////////////////////
			if (current == false)
			{
				this.setBackground(Color.BLUE);
				if (dif == "Easy")
				{
					EasyBoi();
				}
				else if (dif == "Mediam")
				{
					CornerBoi();
				}
				else if (dif == "Hard")
				{
					System.out.println("START");
					HardBoi();
					System.out.println("Fini");
				}
				else if (dif == "BRoKen_M&oDe")
				{
					int Y = rando.nextInt(3);
					int X = rando.nextInt(3);
					myPanels[X][Y].setSymbolBroken("O");
					current = true;
					CheckWinner();
				}
			}
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	//MOST INEFFICIENT CHECKER EVER YAYAYAYAYAYAYAYAYYA yahoooooooo,:) ------------------------------------=================================================================
	///////////////////////////////////////////////////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	private void CheckWinner()
	{
		//horizontal x o/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		for(int i = 0; i<3;i++)
		{
			if (myPanels[i][0].getSymbol() ==  "X" && myPanels[i][1].getSymbol() ==  "X" && myPanels[i][2].getSymbol() ==  "X")
			{
				//System.out.println("X won H");
				Winner("WON YOU HAVE, PROUD YOU SHOULD BE PADAWAN");
				
			}
			if (myPanels[i][0].getSymbol() ==  "O" && myPanels[i][1].getSymbol() ==  "O" && myPanels[i][2].getSymbol() ==  "O")
			{
				//System.out.println("O won H");
				Winner("HOW WUDE, MISA GLAD SITH REIGNS ON");
				
			}
		}
		//vertical x o ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		for(int i = 0; i<3;i++)
		{
			if (myPanels[0][i].getSymbol() ==  "X" && myPanels[1][i].getSymbol() ==  "X" && myPanels[2][i].getSymbol() ==  "X")
			{
				//System.out.println("X won V");
				Winner("WON YOU HAVE, PROUD YOU SHOULD BE PADAWAN");
				
			}
			if (myPanels[0][i].getSymbol() ==  "O" && myPanels[1][i].getSymbol() ==  "O" && myPanels[2][i].getSymbol() ==  "O")
			{
				//System.out.println("O won V");
				Winner("HOW WUDE, MISA GLAD SITH REIGNS ON");
				
			}
		}

		//diagonal right//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (myPanels[0][0].getSymbol() ==  "O" && myPanels[1][1].getSymbol() ==  "O" && myPanels[2][2].getSymbol() ==  "O")
		{
			//System.out.println("O won DR");
			Winner("HOW WUDE, MISA GLAD SITH REIGNS ON");
			
		}
		
		else if (myPanels[0][0].getSymbol() ==  "X" && myPanels[1][1].getSymbol() ==  "X" && myPanels[2][2].getSymbol() ==  "X")
		{
			//System.out.println("X won DR");
			Winner("WON YOU HAVE, PROUD YOU SHOULD BE PADAWAN");
			
		}
		//diagonal left /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (myPanels[0][2].getSymbol() ==  "O" && myPanels[1][1].getSymbol() ==  "O" && myPanels[2][0].getSymbol() ==  "O")
		{
			//System.out.println("O won DL");
			Winner("HOW WUDE, MISA GLAD SITH REIGNS ON");
			
		}
		
		else if (myPanels[0][2].getSymbol() ==  "X" && myPanels[1][1].getSymbol() ==  "X" && myPanels[2][0].getSymbol() ==  "X")
		{
			//System.out.println("X won DL");
			Winner("WON YOU HAVE, PROUD YOU SHOULD BE PADAWAN");
			
		}
	}
	
	/////////////////////////////////////////////////////////////shows the winner and gives option to restart or close///////////////////////////////
	
	public void Winner(String s)
	{
		if (s == "HOW WUDE, MISA GLAD SITH REIGNS ON")
		{
			ImageIcon image = new ImageIcon("jar jar win.png");
			Object[] options = 
				{"restart",
	             "close",
				};
			
			int N = JOptionPane.showOptionDialog(this,//parent container of JOptionPane
			s,
			"---====+ SITH OR JEDI +====---",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			image,//do not use a custom Icon
			options,//the titles of buttons
			options[1]);//default button titles
			if (N == 0)
			{
				restart();
				
			}
			else if (N == -1)
			{
				close();
			}
			else if (N == 1)
			{
				close();
			}

		}
		else
		{
			
			ImageIcon image = new ImageIcon("yoda won.png");
			Object[] options = 
				{"restart",
	             "close",
				};
			
			int N = JOptionPane.showOptionDialog(this,//parent container of JOptionPane
			s,
			"---====+ SITH OR JEDI +====---",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			image,//do not use a custom Icon
			options,//the titles of buttons
			options[1]);//default button titles
			if (N == 0)
			{
				restart();
				
			}
			else if (N == -1)
			{
				close();
			}
			else if (N == 1)
			{
				close();
			}


		}
	}
	
	///////////////////////////////////////////////////////loser gives option to restart or close////////////////////////////////////////////
	
	public void Looser()
	{
		
		Object[] options = {"restart",
                "close"};
		int N = JOptionPane.showOptionDialog(this,//parent container of JOptionPane
		"YOU BOTH LOST A GAME OF TIC TAC TOE",
		"WINNER RIGHT HERE, WINNER",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,//do not use a custom Icon
		options,//the titles of buttons
		options[1]);//default button title
		if (N == 0)
		{
			restart();
		}
		else if (N == -1)
		{
			close();
		}
		else
		{
			close();
		}
	}
	
	////////////////////////////////////restart - removes everything on the page creates new grid prints on the borad jpanel/////////////////////////
	
	public void restart()
	{
		Num = 0;
		this.removeAll();
		this.revalidate();
		this.repaint();
		setLayout(new GridLayout(3,3));
		for (int i = 0; i < myPanels.length;i++)
		{
			for (int j = 0; j< myPanels[i].length;j++)
			{
				this.myPanels[i][j] = new OXpanel();
				this.add(myPanels[i][j]);
				this.myPanels[i][j].addActionListener(this);
			}
		}
		current = true;

	}
	
	/////////////////////////////////////////////close closes the system down all of it/////////////////////////////////////////////////////////
	
	public void close()
	{
		System.exit(0);
	}
	
	public JLabel JarPic()
	{
		Num ++;
		JLabel addImage = new JLabel();
		ImageIcon image = new ImageIcon("jar jar I.png");
		//playes jar jar death sound
		Carl.playSound("JAR JAR.wav");
		addImage.setIcon(image);
		return addImage;
	}
	
	public JLabel YoPic()
	{
		Num ++;
		JLabel addImage = new JLabel();
		ImageIcon image = new ImageIcon("yodaIcon.png");
		// playes YODas death sound 
		Carl.playSound("yoda.wav");
		addImage.setIcon(image);
		return addImage;
	}
	public String J()
	{
		String[] choices = { "Easy", "Mediam", "Hard", "Impossible*","BRoKen_M&oDe"};
		String input = (String) JOptionPane.showInputDialog(null, "=+CHOOSE LEVEL+=",
		"-=-=DIFFICULTY=-=-", JOptionPane.QUESTION_MESSAGE, null, // Use
		choices, // Array of choices
		choices[1]); // Initial choice
		//System.out.println(input);
		if (input == "null") 
		{
			close();
		}
		return(input);
	}
	public String Choice()
	{
		String[] choices = {"Boring Dude","BRoKen_M&oDe"};
		String input = (String) JOptionPane.showInputDialog(null, "=+MODE CHOOSER+=",
		"-=-=MODE_BOI=-=-", JOptionPane.QUESTION_MESSAGE, null, // Use
		choices, // Array of choices
		choices[1]); // Initial choice
		//System.out.println(input);
		if (input == "null") 
		{
			close();
		}
		return(input);
	}
	public void EasyBoi()
	{
		for (int i = 0; i < 10;i++)
		{
			int Y = rando.nextInt(3);
			int X = rando.nextInt(3);
			if (myPanels[X][Y].getSymbol() == "X" || myPanels[X][Y].getSymbol() == "O")
			{
			}
			else
			{
				myPanels[X][Y].setSymbol("O");
				myPanels[X][Y].add(JarPic());
				current = true;
				CheckWinner();
				if(Num >= 9)
				{
					Looser();
				}
				i = 9;
			}
			
		}
	}
	/////////////////////////////////////////////VERY BAD MEDIAM MODE////////////////////////////////////////////////////////////
	public void CornerBoi()
	{
		for (int i = 0; i <11; i++)
		{
			int X = 0;
			int Y = 0;
			if (myPanels[X][Y].getSymbol() == "X" || myPanels[X][Y].getSymbol() == "O")
			{
				X = 2;
				Y = 0;
			}
			if (myPanels[X][Y].getSymbol() == "X" || myPanels[X][Y].getSymbol() == "O")
			{
				X = 0;
				Y = 2;
			}
			if (myPanels[X][Y].getSymbol() == "X" || myPanels[X][Y].getSymbol() == "O")
			{
				X = 2;
				Y = 2;
				
			}
			if (myPanels[X][Y].getSymbol() == "X" || myPanels[X][Y].getSymbol() == "O")
			{
				X = rando.nextInt(3);
				Y = rando.nextInt(3);
			}
			if (myPanels[X][Y].getSymbol() == "X" || myPanels[X][Y].getSymbol() == "O")
			{
			}

			else
			{
				myPanels[X][Y].setSymbol("O");
				myPanels[X][Y].add(JarPic());
				current = true;
				CheckWinner();
				if(Num == 9)
				{
					Looser();
				}
				i = 20;
			}
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////Hard mode/////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////still being worked on ////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void HardBoi()
	{
		for (int i = 0; i <3; i++)
		{
			for (int j = 0; j <3; j ++)
			{
				int k = 0;
				if (j+1 < 2)
				{
					k = j;
				}
				else 
				{
					k = j+1; 
				}
				///////////////////////////////////////horizontal///////////////////////////////////////////////////
				if (myPanels[i][j].getSymbol() == "O" && myPanels[i][k].getSymbol() == "O")
				{
					System.out.println("1");
					if (j+2>2)
					{
						//random X AND Y
						int X = rando.nextInt(3);
						int Y = rando.nextInt(3);
						if (myPanels[X][Y].getSymbol() == "O" || myPanels[X][Y].getSymbol() == "X")
						{
						}
						else
						{
							myPanels[X][Y].setSymbol("O");
							myPanels[X][Y].add(JarPic());
							j = 4;
							i = 4;
							CheckWinner();
						}
								
					}
					else
					{
						myPanels[i][k+1].setSymbol("O");
						myPanels[i][k+1].add(JarPic());
						j = 4;
						i = 4;
						CheckWinner();
					}
					
				}
				if (myPanels[i][j].getSymbol() == "X" && myPanels[i][j+1].getSymbol() == "X")
				{
					System.out.println("2");
					if (j+2>2)
					{
						//random X AND Y
						int X = rando.nextInt(3);
						int Y = rando.nextInt(3);
						if (myPanels[X][Y].getSymbol() == "O" || myPanels[X][Y].getSymbol() == "X")
						{
						}
						else
						{
							myPanels[X][Y].setSymbol("O");
							myPanels[X][Y].add(JarPic());
							j = 4;
							i = 4;
							CheckWinner();
						}
					}
					else
					{
						myPanels[i][j+2].setSymbol("O");
						myPanels[i][j+2].add(JarPic());
						j = 4;
						i = 4;
						CheckWinner();
					}
				}
				/////////////////////////////////////////vertical//////////////////////////////////////////////
				if (myPanels[i][j].getSymbol() == "O" && myPanels[i+1][j].getSymbol() == "O")
				{
					System.out.println("3");
					if (i+2>2)
					{
						//random X AND Y
						int X = rando.nextInt(3);
						int Y = rando.nextInt(3);
						if (myPanels[X][Y].getSymbol() == "O" || myPanels[X][Y].getSymbol() == "X")
						{
						}
						else
						{
							myPanels[X][Y].setSymbol("O");
							myPanels[X][Y].add(JarPic());
							j = 4;
							i = 4;
							CheckWinner();
						}
					}
					else
					{
						myPanels[i+2][j].setSymbol("O");
						myPanels[i+2][j].add(JarPic());
						j = 4;
						i = 4;
						CheckWinner();
					}
					
				}
				if (myPanels[i][j].getSymbol() == "X" && myPanels[i+1][j].getSymbol() == "X")
				{
					System.out.println("4");
					if (i+2>2)
					{
						//random X AND Y
						int X = rando.nextInt(3);
						int Y = rando.nextInt(3);
						if (myPanels[X][Y].getSymbol() == "O" || myPanels[X][Y].getSymbol() == "X")
						{
						}
						else
						{
							myPanels[X][Y].setSymbol("O");
							myPanels[X][Y].add(JarPic());
							j = 4;
							i = 4;
							CheckWinner();
						}
					}
					else
					{
						myPanels[i+2][j].setSymbol("O");
						myPanels[i+2][j].add(JarPic());
						j = 4;
						i = 4;
						CheckWinner();
					}
				}
				/////////////////////////////////////////////random start up one//////////////////////////////////////
				else
				{
					System.out.println("5");
					int X = rando.nextInt(3);
					int Y = rando.nextInt(3);
					if (myPanels[X][Y].getSymbol() == "O" || myPanels[X][Y].getSymbol() == "X")
					{
					}
					else
					{
						myPanels[X][Y].setSymbol("O");
						myPanels[X][Y].add(JarPic());
						j = 4;
						i = 4;
						CheckWinner();
					}
				}
			}
		}
	}
}