
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;


public class UltraSensor {

       EV3UltrasonicSensor ultrasensor;
       public SampleProvider distance;
       public float [] sample;
      // Robotunit allrob;
      
	 
	 public UltraSensor(){//Robotunit allr) {
	
				 ultrasensor = new EV3UltrasonicSensor(SensorPort.S1);
				 ultrasensor.getDistanceMode();
				// get an instance of this sensor in measurement mode
					 distance=  ultrasensor.getMode("Distance");

					// initialize an array of floats for fetching samples. 
					// Ask the SampleProvider how long the array should be
					sample = new float[distance.sampleSize()];
					
		// allrob=allr;
		 //allr.sample=new float[distance.sampleSize()];
		
	}


	 
	 
//	 public void getMeSampels(SampleProvider distance) {
//		 synchronized (allrob.lock) {
//			 distance.fetchSample(allrob.sample, 0);
//			
//		}
//	}
	
		public float getASample()
		{  synchronized (this) {
			return this.sample[this.sample.length-1];
		}	
		}
		



		public float[] fetchASampele(SampleProvider distance) {
			
			

			// fetch a sample
			   synchronized (this) {
				 distance.fetchSample(sample, 0);
				 return sample;
			}
	        
	          
			 //Float.toString  (sample[sample.length-1]);
			
			
		}
		
		public void fetchASampeleOnly() {
			
			

			// fetch a sample, save in sample
			   synchronized (this) {
				 distance.fetchSample(sample, 0);
			}
		}


public void close ()
{

	}





//public void getsampeles(Object lock) {
//
//// get an instance of this sensor in measurement mode
//SampleProvider distance=  ultrasensor.getMode("Distance");
//
//// initialize an array of floats for fetching samples. 
//// Ask the SampleProvider how long the array should be
//sample = new float[distance.sampleSize()];
//
//// fetch a sample
//while(true) 
//{   synchronized (lock) {
//	
//	 distance.fetchSample(sample, 0);
//}
//
//  
// //Float.toString  (sample[sample.length-1]);
//}
//
//}

}
