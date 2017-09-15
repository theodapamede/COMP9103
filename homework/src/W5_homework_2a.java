import java.util.Scanner;
public class W5_homework_2a {
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		String date1 = "\\d{2}-\\d{2}-\\d{4}";
		String date2 = "\\d{1}-\\d{1}-\\d{2}";
		String input = scan.next();
		if(input.matches(date1)||input.matches(date2)){
			System.out.println("true");
		}
		else System.out.println("false");
		scan.close();
		
	}

}
