
import javax.swing.JFrame;

public class XnOrunner {
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new Board());
		window.setSize(700,600);
		window.setTitle("Tic Tac Toe"
				+ "  =+REVENGE OF JAR JAR+="
				+ "  -=-BATTLE OF JEDI AND SITH-=-");
		window.setVisible(true);
	}
}
