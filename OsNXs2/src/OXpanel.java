import javax.swing.JButton;

public class OXpanel extends JButton
{
	private String mySymbol = "";
	
	
	
	public void setSymbol(String s)
	{
		//this.setBackground(Color.BLACK);
		mySymbol = s;
		this.setText(s);
		this.setEnabled(false);
	}
	public void setSymbolBroken(String s)
	{
		mySymbol = s;
		this.setText(s);
	}
	
	public String getSymbol()
	{
		return mySymbol;
	}
}