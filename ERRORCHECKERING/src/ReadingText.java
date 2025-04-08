import java.io.*;

public class ReadingText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("Text.txt"));
			String line;
			do
			{
				line = reader.readLine();
				System.out.println(reader.readLine());
			}
			while(line != null);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("erroe");
		}
		catch(IOException e)
		{
			System.out.println("ERRRERERE");
		}

	}

}
