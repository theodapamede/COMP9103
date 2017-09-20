
public class Staff {
	//instance fields
	private String name;
	private int hours;
	private double rate;
	
	//constructors
	public Staff(){
		name = null;
		hours = 0;
		rate = 0;		
	}
	
	public Staff(String s, int hrs, double rt){
		name = s;
		hours = hrs;
		rate = rt;
	}
	
	//methods
	public String getName(){
		return name;
	}
	public int getHours(){
		return hours;
	}
	public double getRate(){
		return rate;
	}
	public void addName(String s){
		name = s;
	}
	public void addHours(int hrs){
		hours = hrs;
	}
	public void addRate(double rt){
		rate = rt;
	}
	public double getSalary(){
		double salary = hours*rate;
		return salary;
	}
}
