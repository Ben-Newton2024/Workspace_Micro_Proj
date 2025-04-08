
public class Eroors {
	
	public static void main (String[] args)
	{
		String value = "8";
		String vlaue2 = "0";
		
		try
		{
			int vlaue = Integer.parseInt(value);
			int valuee = Integer.parseInt(vlaue2);
			System.out.println(vlaue/valuee);
			
		}
		catch(NumberFormatException e)
		{
			System.out.println("WOINT WORK");
		}
		catch(ArithmeticException e)
		{
			System.out.println("KKKK");
		}
	}

}
