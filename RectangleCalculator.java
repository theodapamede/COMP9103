/*
 * This program is to calculate the area, perimeter and
 * diagonal of a rectangle based on args[0] and args[1]
 */
public class RectangleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double length=Double.parseDouble(args[0]);
		double width=Double.parseDouble(args[1]);
		double area=length*width;
		double perimeter=2*(length+width);
		double diagonal=Math.sqrt(Math.pow(length, 2)+Math.pow(width, 2));
		System.out.println("Length= "+length);
		System.out.println("Width = "+width);
		System.out.println("Area= "+area);
		System.out.println("Perimeter= "+perimeter);
		System.out.println("Diagonal= "+diagonal);

	}

}
