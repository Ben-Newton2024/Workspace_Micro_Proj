public class Stack
{
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
		
		//take value
		if(currentIndex>=0)
		{
			currentIndex--;
			return(myArray[currentIndex]);
		}
		else 
		{
			return 0;
		}
	}
	public int peek()
	{
		return myArray[currentIndex];
	}
	
	public static void main(String[] args)
	{

		Stack bob = new Stack();
		bob.push(4);
		bob.push(9);
		System.out.println(bob.peek());
		bob.push(11);
		System.out.println(bob.pop());
		System.out.println(bob.pop());
		System.out.println(bob.pop());
		bob.push(100);
		System.out.println(bob.pop());
		
				
	}
}
