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
		Scanner scan = new Scanner(name);
		String input = scan.nextLine();
		int a=0;
		while(input.length()>0){
			for(int i=0; i<input.length(); i++){
				if(!Character.isAlphabetic(input.charAt(i))){
					a = 1;
				}
				else if(Character.isUpperCase(input.charAt(0))){
					String names[] = input.split(" ");
					for(int j=0; j<names.length; j++){
						for(int k=0; k<names[j].length(); k++){
							if(Character.isUpperCase(names[j].charAt(0))){
								a=2;
							}
							else a=1;
						}
					}
				}
				else a=1;
			}
		}
		if(a==2){
			scan.close();
			return true;
		}
		else{
			scan.close();
			return false;
		}
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
