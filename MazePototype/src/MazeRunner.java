import javax.swing.JFrame;

public class MazeRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main bob = new Main();
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(bob);
		window.setSize(1000,1000);
		window.setVisible(true);
	}

}
