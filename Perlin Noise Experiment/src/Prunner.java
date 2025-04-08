import javax.swing.JFrame;

public class Prunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapbyNoise carl = new MapbyNoise();
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(carl);
		window.setSize(1000,700);
		window.setVisible(true);
	}

}
