import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lejos.hardware.motor.Motor;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;


public class Crane {
	//Ev3
		RemoteEV3 ev3 ;
		
		//Crane Motors
		RMIRegulatedMotor  motorC;  //Open and Close 
	    RMIRegulatedMotor  motorD; // up and down
	    int cranelevel=2;
		
	    public Crane() throws RemoteException, MalformedURLException, NotBoundException
	    {
	   	  ev3=new RemoteEV3("10.0.1.1");//initiate Ev3
		  ev3.isLocal();
		  ev3.getPort("C");
		  ev3.getPort("D");
		  motorC =  ev3.createRegulatedMotor("C",'M');//open and close
		  motorD= ev3.createRegulatedMotor("D",'M'); //up and down
	    }
	    
	    
	    public void moveCraneUpAndDown(int angel) throws RemoteException
	    {  //Positive angel crane goes down
	    	motorD.rotate(angel);
	    }
	    
	    public void moveCraneUp() throws RemoteException
	    {
	    	motorD.backward();
	    	Delay.msDelay(1500);
	    	this.stopUpDownMotor();
	    	this.cranelevel+=1;
	    	
	    }
	    public void moveCraneDown() throws RemoteException{
	    	motorD.forward();
	    	Delay.msDelay(1500);//1800
	    	this.stopUpDownMotor();
	    	this.cranelevel-=1;
	    	
	    }
	    public void closeCraneGrip() throws RemoteException, InterruptedException
	    {
	    	 motorC.forward();
	    	 Thread.sleep(250);//500
			 this.stopGripMotor();
	    }
	    public void openCraneGrip() throws RemoteException, InterruptedException
	    {
	    	motorC.backward();
	    	 Thread.sleep(250);
			this.stopGripMotor();
	    	
	    }
	    public void stopGripMotor () {
	    	Motor.C.stop();
			
		}
	    public void stopUpDownMotor () {
	    	Motor.D.stop();
			
		}
	    public void stopBothMotors () {
	    	Motor.C.stop();
	    	Motor.D.stop();
			
		}
	    public void closemotors() throws RemoteException
	    {
	    	motorC.close();
	    motorD.close();
	    }
	    
	    	

}
