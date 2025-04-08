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
			AudioInputStream audioInputStream = 
					   AudioSystem.getAudioInputStream(new File(File));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					FloatControl volumeControl = 
					    (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
					volumeControl.setValue(100.0f); // Increase volume by 10 decibels.
					clip.start();
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
			AudioInputStream audioInputStream = 
					   AudioSystem.getAudioInputStream(new File(File));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					FloatControl volumeControl = 
					    (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
					volumeControl.setValue(100.0f); // Increase volume by 10 decibels.
					clip.start();
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