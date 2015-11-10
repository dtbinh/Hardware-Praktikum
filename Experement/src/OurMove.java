import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class OurMove {
	
	public OurMove() {
		
	}
	
	public void rotateLeft(int degrees) {
		
		int speed = 180; // Motor-rotation in Degrees per second 
		float rotationFactor = 2.6f; // Constant Factor, so if multiplied with degrees you get the degrees the motor has to turn
		
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		
		Motor.A.rotate((int)(degrees * rotationFactor), true);
		Motor.B.rotate((int)(-1 * degrees * rotationFactor), true);

		Delay.msDelay( (int)(1000 * degrees * rotationFactor) / speed );
	}
	
	public void rotateRight(int degrees) {
		
		int speed = 180; // Motor-rotation in Degrees per second 
		float rotationFactor = 2.6f; // Constant Factor, so if multiplied with degrees you get the degrees the motor has to turn
		
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		
		Motor.B.rotate((int)(degrees * rotationFactor), true);
		Motor.A.rotate((int)(-1 * degrees * rotationFactor), true);

		Delay.msDelay( (int)(1000 * degrees * rotationFactor) / speed );
	}
	
	public void forward(int cm) {
		
		int speed = 360; // Motor-rotation in Degrees per second 
		float drivingFactor = 2.6f; // Constant Factor, so if multiplied with cm you get the degrees the motor has to turn
		
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		
		Motor.A.rotate((int)(cm * drivingFactor), true);
		Motor.B.rotate((int)(cm * drivingFactor), true);

		Delay.msDelay( (int)(1000 * cm * drivingFactor) / speed );
	}

	public void backward(int cm) {
	
		int speed = 360; // Motor-rotation in Degrees per second 
		float drivingFactor = 2.6f; // Constant Factor, so if multiplied with cm you get the degrees the motor has to turn
	
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
	
		Motor.A.rotate((int)(-1 * cm * drivingFactor), true);
		Motor.B.rotate((int)(-1 * cm * drivingFactor), true);

		Delay.msDelay( (int)(1000 * cm * drivingFactor) / speed );
	}
}
