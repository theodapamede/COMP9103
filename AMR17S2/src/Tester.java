
public class Tester {
	public static final String DASHSHORT = new String(new char[4]).replace("\0", "-");
	public static final String DASHLONG = new String(new char[25]).replace("\0", "-");
	public static void main(String[]args) {
		int i = 809;
		String tier = "mileage";
		System.out.printf("%squery age "+tier+"%s%n",DASHSHORT,DASHSHORT);
		System.out.printf("number %05d\n", i);
		System.out.printf("%s\n",DASHLONG);
	}
}
