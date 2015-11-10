
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import java.awt.Color;


public class Colorrsensor {
	EV3ColorSensor colorsensor;
	public Colorrsensor () {
		 colorsensor  = new EV3ColorSensor(SensorPort.S2);
		  SensorMode mode =colorsensor.getColorIDMode();
		
	}
	
//	 PINK = 8;
//	 GRAY = 9;
//	 LIGHT_GRAY = 10;
//	 DARK_GRAY = 11;
//	 CYAN = 12;
//	 BROWN = 13;
//	 NONE = -1;
	
	//colorsensor.getColorID()
	public Color DetectColor  (int ColorID)throws InterruptedException
	{
	switch (ColorID)
		{
				
		 case 0:
				Thread.sleep(100);
			    return Color.RED;
		 case 1:
				Thread.sleep(100);
			    return Color.GREEN;
		 case 2:
				Thread.sleep(100);
		        return Color.BLUE;
		 case 3:
			    Thread.sleep(100);
			    return Color.YELLOW;
		 case 4:
				Thread.sleep(100);
			    return Color.MAGENTA;
		 case 5:
		       Thread.sleep(100);
			   return Color.ORANGE;
		 case 6:
		       Thread.sleep(100);
			   return Color.WHITE;
		 case 7:
			   Thread.sleep(100);
			   return Color.BLACK;
			   default :
			   return Color.CYAN;
			
	    
		}
}
	

}
