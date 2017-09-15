/**
 * Week 6 Homework
 * @author tdap2572
 *
 */


public class Rectangle {
//instance fields
	private double width;
	private double height;
//constructors
	/**
	 * Constructs a default rectangle (width=2, height=1).
	 */
	public Rectangle(){
		width=2;
		height=1;
	}
	
	/**
	 * Constructs a user defined rectangle.
	 */
	public Rectangle(double w, double h){
		width=w;
		height=h;
	}
	
//methods
	/**
	 * Changes the width
	 * @param w (width)
	 */
	public void changeWidth(double w){
		if(w>0) width=w;
	}
	/**
	 * Changes the height
	 * @param h (height)
	 */
	public void changeHeight(double h){
		if(h>0) height=h;
	}
	/**
	 * Gets the area of the rectangle
	 * @return the area of the rectangle
	 */
	public double getArea(){
		double area = width*height;
		return area;
	}
	/**
	 * Gets the perimeter of the rectangle
	 * @return the perimeter of the rectangle
	 */
	public double getPerimeter(){
		double perimeter = 2*(width+height);
		return perimeter;
	}
	/**
	 * Gets the X coordinate of the centre
	 * @return the X coordinate
	 */
	public double getX(){
		double x = width/2;
		return x;
	}
	/**
	 * Gets the Y coordinate of the centre
	 * @return the Y coordinate
	 */
	public double getY(){
		double y = height/2;
		return y;
	}
	/**
	 * Gets the (X,Y) coordinates of the centre
	 * @return the (X,Y) coordinates
	 */
	public String getCentre(){
		double x = width/2;
		double y = height/2;
		String centre = String.format("(%.2f, %.2f)",x,y);
		return centre;
	}
	/**
	 * Gets the diagonal length of the rectangle
	 * @return the diagonal
	 */
	public double getDiagonal(){
		double r = Math.sqrt((Math.pow(width, 2))+(Math.pow(height, 2)));
		return r;
	}
}
