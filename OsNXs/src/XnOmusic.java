import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class XnOmusic
{
	public void playSound(String File)
	{
		try 
		{
			//plays song
			//finds song
			//opens the file
			//plays the file
			//if can't find file displays error
			//plays different sound depending on action
			AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(File).getAbsoluteFile());
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioInputStream1);
			clip1.start();
		}
		catch(Exception ex) 
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		
		
	}
	public void loopSound(String File)
	{
		try 
		{
			//plays song
			//finds song
			//opens the file
			//plays the file
			//if can't find file displays error
			//plays different sound depending on action
			AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(File).getAbsoluteFile());
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioInputStream1);
			clip1.start();
		}
		catch(Exception ex) 
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	public void StopBoi()
	{
		
	}
}