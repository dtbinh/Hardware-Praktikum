
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.sql.rowset.spi.SyncResolver;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.Color;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;

public class Robotunit implements Runnable{

  //Moving Motors forward,backward,Left and right
  	Movement FBLR;
  	//crane 
  Crane crane;
    //Sensors 1- ultrasonic
   UltraSensor ultr;
    //Sensor 2-Color
  Colorrsensor clrsensor;
  
  OurMove om = new OurMove();

  Color[] order = new Color[3]; 
   
    
    
	public Robotunit() throws RemoteException, MalformedURLException, NotBoundException{
		   FBLR =new Movement();//this);
		   crane=new Crane();
		   ultr=new UltraSensor();//this);
		  // clrsensor=new Colorrsensor();
		 
	
		  
		   
		 
	}
	@Override
	public void run() {
		    int i=0;
		         FBLR.moveForwardBackward();
			while(true)
			{ if(i==1)
			{   FBLR.stop();
			FBLR.closemotors();
			try {
				crane.closemotors();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				this.ultr.fetchASampele(this.ultr.distance);
				if (this.ultr.getASample()<=0.05f)
				{i+=1;
				FBLR.stop();
			   // FBLR.turnLeftRight(20);
			   // FBLR.moveForwardBackward();
				FBLR.moveForwardBackward(-100);
				try {
					crane.openCraneGrip();
					crane.moveCraneDown();
					crane.moveCraneDown();
					FBLR.moveForwardBackward(100);
					crane.closeCraneGrip();
					crane.moveCraneUp();
					crane.moveCraneUp();
					
				} catch (RemoteException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 
			    
			    
			    }
				
			}
			
		}
	
	//NEW METHOD: find center, look north
	public void findStartPosition() {
		
		int lowerBorder = 30; //Lower border for the interval the roboter searches in (in cm)
		int upperBorder = 50; //Upper border for the interval the roboter searches in (in cm)
		
//fetch new UltraSensor sample?
		ultr.fetchASampeleOnly();
		while(ultr.getASample() <= lowerBorder && ultr.getASample() >= upperBorder) {
			
			om.rotateRight(1);
			ultr.fetchASampeleOnly();
		}
		
		float distA;
		float distB;
		int degreesSinceObject = 0;
		
		while(degreesSinceObject < 180) {
			
			while(ultr.getASample() >= lowerBorder && ultr.getASample() <= upperBorder) {
			
				distA = ultr.getASample();
				degreesSinceObject = 0;
			
				om.rotateRight(1);
				degreesSinceObject++;
				ultr.fetchASampeleOnly();
			}
		
			while(ultr.getASample() <= lowerBorder && ultr.getASample() >= upperBorder) {
			
				om.rotateRight(1);
				degreesSinceObject++;
				ultr.fetchASampeleOnly();
			}
		
			if(ultr.getASample() >= lowerBorder && ultr.getASample() <= upperBorder) {
			
				distB = ultr.getASample();
			}
		}
		
		om.rotateLeft(120);
		float distC = ultr.getASample();
		while(ultr.getASample() <= distC) {
			
			distC = ultr.getASample();
			om.rotateLeft(1);
			ultr.fetchASampeleOnly();
		}
		om.rotateRight(1);
		om.backward((int)((196/2) - distC));
		om.rotateLeft(90);
		ultr.fetchASampeleOnly();
		om.backward((int)((196/2) - ultr.getASample()));
		om.rotateRight(90);
	}

	/*
	// NEW METHOD: read order of colors
	public void findColorOrder() {
		
		clrsensor.checkColor();
		while(clrsensor.getColor() != Color.BLACK) {
			om.forward(1);
			clrsensor.checkColor();
		}
		while(clrsensor.getColor() == Color.BLACK) {
			om.forward(1);
			clrsensor.checkColor();
		}
		om.forward(20); //muss genau gemessen werden
		om.rotateRight(90);
		clrsensor.checkColor();
		while(clrsensor.getColor() != Color.RED || clrsensor.getColor() != Color.GREEN || clrsensor.getColor() != Color.YELLOW) {
			
			om.forward(1);
			clrsensor.checkColor();
		}
		color[0] = clrsensor.getColor();
		while(clrsensor.getColor() == color[0]) {
			
			om.forward(1);
			clrsensor.checkColor();
		}
		color[1] = clrsensor.getColor();
		while(clrsensor.getColor() == color[1]) {
			
			om.forward(1);
			clrsensor.checkColor();
		}
		color[2] = clrsensor.getColor();
	}
*/

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException, InterruptedException {
		// TODO Auto-generated method stub
		  Robotunit A=new Robotunit();
		 
//		 A.crane.closeCraneGrip();
//		A.crane.moveCraneUp();
//		 A.crane.moveCraneUp();
//		 A.crane.moveCraneDown();
//		 A.crane.moveCraneDown();
//		 
//          //Delay.msDelay(5000);
//		// A.crane.openCraneGrip();
//	
//		 A.crane.closemotors();
		  // With threadings
	   //Movement thread  
		  //Thread t1=new Thread(A);
          Thread t2=new Thread(A);
           //  t1.start();
             t2.start();
             
	}
}
