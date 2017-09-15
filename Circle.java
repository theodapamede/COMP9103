
public class Circle {
	//instances
	double radius;
	//constructors
	public Circle(){
		radius = 0;
	}
	
	public Circle(double rad){
		radius = rad;
	}
	
	public void addRadius(double rad){
		if(rad>0)
			radius = rad;
	}
	//methods
	public double getArea(){
		double area = Math.PI*Math.pow(radius,2);
		return area;
	}
	
	public double getPerimeter(){
		double perimeter = Math.PI*2*radius;
		return perimeter;
	}

}
