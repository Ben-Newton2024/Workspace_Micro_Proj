public class Queue {
	
	private int[] myArray = new int[10];
	int currentIndex = 0;
	
	public void push(int value)
	{
		//add value
		if(currentIndex < myArray.length)
		{
			myArray[currentIndex] = value;
		currentIndex++;
		}
		
	}
	
	public int pop()
	{
		int firstinput = myArray[0];		
		//take value
		if(currentIndex>=0)
		{
			for(int i = 1; i<myArray.length ; i++)
			{
				myArray[i-1] = myArray[i];
			}
			return(firstinput);
		}
		else 
		{
			return 0;
		}
	}
	
	public int peek()
	{
		return myArray[0];
	}
	
	
	public static void main(String[] args)
	{
		Queue bob = new Queue();
		bob.push(4);
		bob.push(9);
		System.out.println(bob.peek());
		bob.push(11);
		System.out.println(bob.pop());
		System.out.println(bob.pop());
		System.out.println(bob.pop());
		bob.push(100);
		bob.push(9);
		bob.push(20);
		bob.push(40);
		System.out.println(bob.pop());
	}

}
