/**demo on the use of javadoc
 * example
 * @author Theo Dapamede
 */

public class Car {
	private double speed;
	private double accelerationPower;
	private double brakePower;
	private boolean acceleratorOn;
	private boolean brakeOn;
	private double position;
	private String name;
	private static double lowerSpeedLimit = 80.0;
	private static double upperSpeedLimit = 110.0;
	
	public Car(String n, double s, double p, double a, double b) {
		name = n;
		position = p;
		accelerationPower = a;
		brakePower = b;
		speed = s;
		acceleratorOn = true;
		brakeOn = false;
	}
	
	public double getPosition() {
		return position;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean tooFast() {
		return (speed>upperSpeedLimit);
	}
	
	public boolean tooSlow() {
		return (speed<lowerSpeedLimit);
	}
	
	public void move(double time) {
		if (tooSlow()) {
			acceleratorOn = true;
			brakeOn = false;
		}
		if (tooFast()) {
			brakeOn = true;
			acceleratorOn = false;
		}
		double a = 0.0;
		if (acceleratorOn) a += accelerationPower;
		if (brakeOn) a -= brakePower;
		speed = speed + time*a;
		position += time*speed;
	}

}
