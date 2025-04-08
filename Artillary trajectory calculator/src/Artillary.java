public class Artillary 
{
	//WHAT I NEED
	//speed
	//velocity
	//luanch angle
	//gravity
	//math.sin and tan etc

	
	// equation for the trajectory
	
	public double calcLand(double StartHeight,  
				double gravity, 
				double LaunchAngle,
				double Velocity)
				
	{
		System.out.println(StartHeight + "H");
		System.out.println(gravity + "grav");
		System.out.println(LaunchAngle + "rad");
		System.out.println(Velocity +"ms-1");
		double y = (StartHeight * Math.tan(LaunchAngle)) 
				- (-gravity * StartHeight * StartHeight
				/ 2 * (Velocity * Velocity) * Math.pow(Math.cos(LaunchAngle), 2));
		System.out.println(y + "noob");
		return -y;
	}
	
	//colaucalte the max height 
	
	public double calcMaxHeight(double Velocity,
				double gravity,
				double LaunchAngle,
				double StartHeight)
	{
		double h = StartHeight+((Velocity * Velocity)*Math.pow(Math.sin(LaunchAngle),2))/2*gravity;
		
		return h;
	}

	//calcualte the range e.g the landing distance from luanch 0x
	
	public double calcRange(double Velocity,
				double LaunchAngle,
				double gravity)
	{
		double R = (Velocity * Velocity) * Math.sin(2*LaunchAngle) / gravity;
		
		return R;
	}
	
	// doesnt seem to want it to move more than the decimal to show the distnace
	// for fiding the distance to the max height so then the cyan blob can move to it to show the max height distance
	public double TimetoMaxHeight(double Velocity,
			double gravity,
			double LaunchAngle)
	{
		double calc = (Velocity* Math.sin(LaunchAngle))/-gravity;
		return calc;
	}
	
	
	//////////////////////////////
	public double calcMaxHDis(double Velocity,
			double LaunchAngle,
			double gravity,
			double StartHeight,
			double StartDistance)
		{ 
			double num = 0;
			for(double i = 0 ; i < 1000000; i+= 0.001)
			{
				double Vy = Velocity*Math.sin(LaunchAngle) + -gravity*i; 
				if ((int)Vy == 0 || Vy< 1 && Vy > -1)
				{
					num = i;
					break;
				}
			}
			double calc = num*100;
			return calc;
		}
}

