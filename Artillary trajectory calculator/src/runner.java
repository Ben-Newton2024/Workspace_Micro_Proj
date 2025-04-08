import javax.swing.JFrame;

//basic boi
public class runner 
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new UI());
		window.setSize(1000,600);
		window.setTitle("trajectory calc");
		window.setVisible(true);
	}
}

