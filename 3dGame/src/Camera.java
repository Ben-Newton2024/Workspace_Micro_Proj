import java.awt.MouseInfo;
import java.awt.event.*;


public class Camera implements KeyListener
{
	public double xPos, yPos, xDir, yDir, xPlane, yPlane;
	public boolean left, right, forward, back;
	public final double MOVE_SPEED = .08;
	public final double ROTATION_SPEED = .045;
	public Camera(double x, double y, double xd, double yd, double xp, double yp) 
	{
		xPos = x;
		yPos = y;
		xDir = xd;
		yDir = yd;
		xPlane = xp;
		yPlane = yp;
		
	}
	public void keyPressed(KeyEvent key) {
		if(key.getKeyChar() == 'a')
			left = true;
		if(key.getKeyChar() == 'd')
			right = true;
		if(key.getKeyChar() == 'w')
			forward = true;
		if(key.getKeyChar() == 's')
			back = true;
	}
	public void keyReleased(KeyEvent key) {
		if(key.getKeyChar() == 'a')
			left = false;
		if(key.getKeyChar() == 'd')
			right = false;
		if(key.getKeyChar() == 'w')
			forward = false;
		if(key.getKeyChar() == 's')
			back = false;
	}
	public void update(int[][] map) {  
		if(forward) {
			if(map[(int)(xPos + xDir * MOVE_SPEED)][(int)yPos] == 0) {
				xPos+=xDir*MOVE_SPEED;
			}
			if(map[(int)xPos][(int)(yPos + yDir * MOVE_SPEED)] ==0)
				yPos+=yDir*MOVE_SPEED;
		}
		if(back) {
			if(map[(int)(xPos - xDir * MOVE_SPEED)][(int)yPos] == 0)
				xPos-=xDir*MOVE_SPEED;
			if(map[(int)xPos][(int)(yPos - yDir * MOVE_SPEED)]==0)
				yPos-=yDir*MOVE_SPEED;
		}
		if(right) {
			double oldxDir=xDir;
			xDir=xDir*Math.cos(-ROTATION_SPEED) - yDir*Math.sin(-ROTATION_SPEED);
			yDir=oldxDir*Math.sin(-ROTATION_SPEED) + yDir*Math.cos(-ROTATION_SPEED);
			double oldxPlane = xPlane;
			xPlane=xPlane*Math.cos(-ROTATION_SPEED) - yPlane*Math.sin(-ROTATION_SPEED);
			yPlane=oldxPlane*Math.sin(-ROTATION_SPEED) + yPlane*Math.cos(-ROTATION_SPEED);
		}
		if(left) {
			double oldxDir=xDir;
			xDir=xDir*Math.cos(ROTATION_SPEED) - yDir*Math.sin(ROTATION_SPEED);
			yDir=oldxDir*Math.sin(ROTATION_SPEED) + yDir*Math.cos(ROTATION_SPEED);
			double oldxPlane = xPlane;
			xPlane=xPlane*Math.cos(ROTATION_SPEED) - yPlane*Math.sin(ROTATION_SPEED);
			yPlane=oldxPlane*Math.sin(ROTATION_SPEED) + yPlane*Math.cos(ROTATION_SPEED);
		}
        
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}