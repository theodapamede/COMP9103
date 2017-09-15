/**
 * Conducts system check
 * @author Theo Dapamede
 *
 */
import java.util.Scanner;
public class SystemCheck {
	//Fields
	private String sysCheck;
	
	//Constructors
	public SystemCheck() {}
	//Methods
	
	/*
	 * NameCheck
	 */
	public boolean nameCheck(String name) {
		String[] checkName = name.split(" ");
		int a = 0;
		for(int i=0; i<checkName.length; i++) { //Per word check
			for(int j=0; j<checkName[i].length();j++) { //Per letter in word check
				if(!Character.isAlphabetic(checkName[i].charAt(j))||!Character.isUpperCase(checkName[i].charAt(0))) {
					a=1;
					break;
				}
				else {
					a=2;
				}
			}
		}
		if(a==2) return true;
		else return false;
	}
	
	/*
	 * DateCheck
	 */
	public boolean dateCheck(String date) {
		Scanner scan = new Scanner(date);
		String date1 = "\\d{2}-\\d{2}-\\d{4}";
		String date2 = "\\d{1}-\\d{1}-\\d{4}";
		String date3 = "\\d{1}/\\d{1}/\\d{4}";
		String date4 = "\\d{2}/\\d{2}/\\d{4}";
		String input = scan.next();
		if(input.matches(date1)||input.matches(date2)||input.matches(date3)||input.matches(date4)){
			scan.close();
			return true;
		}
		else{
			scan.close();
			return false;
		}
	}
	
}
