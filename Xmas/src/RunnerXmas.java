
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunnerXmas {
	public static void main(String[] args)
	{
		
		
		
		MusicXmas steve = new MusicXmas();
		steve.loopSound("Muse.wav");
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new XmasPanel());
		window.setSize(1000,500);
		window.setTitle("BOUNCY");
		window.setVisible(true);
	}
}

