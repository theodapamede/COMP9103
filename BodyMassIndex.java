
public class BodyMassIndex {
	public static void main(String[]args){
		final double WEIGHT = 55.8;
		final double HEIGHT = 1.65;
		double bmi = (WEIGHT)/(Math.pow(HEIGHT, 2));
		if(bmi>=18.5){
			if(bmi<25)
				System.out.print("Normal Weight");
			else if(bmi<30)
				System.out.print("Overweight");
			else
				System.out.print("Obese");
		}
		else
			System.out.print("Underweight");
		System.out.print(bmi);
	}
}
