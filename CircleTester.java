
public class CircleTester {
	public static void main(String[]args){
		Circle one = new Circle();
		one.addRadius(7);
		System.out.printf("%.2f \n",one.getArea());
		System.out.printf("%.2f \n",one.getPerimeter());
		Circle two = new Circle(150);
		System.out.printf("%.2f \n",two.getArea());
		System.out.printf("%.2f",two.getPerimeter());
	}
}
