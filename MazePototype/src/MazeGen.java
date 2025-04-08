
public class MazeGen {
	
	public int[][] myMaze;
	
	public void emptyMaze(int q) {
		myMaze = new int[q][q];
		
		for(int y = 0; y < myMaze.length; y++)
		{
			for(int x = 0; x < myMaze[y].length; x++)
			{
				if(y == 0 || y == myMaze.length-1 || x == 0 || x == myMaze[0].length-1) {
					myMaze[y][x] = 9;
				}


				else {
				myMaze[y][x] = 0;
				}
			}
		}	
	}
	
	public int[][] returnMaze(){
		return myMaze;
	}
}
