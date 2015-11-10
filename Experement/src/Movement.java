
import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;



public class Movement {//implements  Runnable {

	DifferentialPilot  fBLR;
	//Robotunit allrob;

    
    
 
	
	
	
	public Movement(){//Robotunit allr) {
		// TODO Auto-generated constructor stub
		
		
		//allrob=allr;
		
	}




//negative distance means Backward
public void moveForwardBackward(double distance) {
		// TODO Auto-generated method stub
	fBLR=new DifferentialPilot(50, 165, Motor.A, Motor.B);
	fBLR.travel(distance);

	}
public void moveForwardBackward() {
	// TODO Auto-generated method stub
fBLR=new DifferentialPilot(50, 165, Motor.A, Motor.B);

fBLR.forward();

}


public void turnLeftRight(double angel)
    {
	fBLR=new DifferentialPilot(50, 165, Motor.A, Motor.B);
	fBLR.rotate(angel);
	}



public void stop() {
	this.fBLR.stop();
//	Motor.A.stop();
//	Motor.B.stop();
	
}
// public  void run() {
//   
//	 fBLR.travel(3000);
//	while(true)
//	{ 
//		if (utmp.getASample()<=0.4f)
//		{
//	
//		fBLR.stop();
//	    fBLR.rotate(180);
//        fBLR.travel(3000);
//	    }
//	
//	
//	}
// }
public void closemotors()
{
	Motor.A.close();
     Motor.B.close();
	}
}
