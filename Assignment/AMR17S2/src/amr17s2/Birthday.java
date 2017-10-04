package amr17s2;

import java.util.*;
import java.text.*;

public class Birthday {
	//Fields
	private static SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String birthdayString;
	private Date birthday;
	
	//Constructors
//	public Birthday() {}

	public Birthday(String date) {
		birthdayString = date;
		String[] temp;
		Scanner scan = new Scanner(date);
		String date1 = "\\d{2}-\\d{2}-\\d{4}";
		String date2 = "\\d{1}-\\d{1}-\\d{4}";
		String date3 = "\\d{1}/\\d{1}/\\d{4}";
		String date4 = "\\d{2}/\\d{2}/\\d{4}";
		String input = scan.next();
		if(input.matches(date1)||input.matches(date2)||input.matches(date3)||input.matches(date4)){
			temp = birthdayString.split("\\D");
			if(temp.length == 3) {
				for(int i = 0; i<2; i++) {
					if(temp[i].length()<2) {
						temp[i] = "0"+temp[i];
					}
				}
				birthdayString = temp[0] + "/" + temp[1] + "/" + temp[2];
			}
		}
		try {
			birthday = birthdayFormat.parse(birthdayString);
		}
		catch (ParseException e) {
			birthday = null;
		}
		scan.close();
	}
	
	//Methods
	public boolean checkBirthday() {
		if(birthday!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
//	public boolean dateCheck(String date) {
//		Scanner scan = new Scanner(date);
//		String date1 = "\\d{2}-\\d{2}-\\d{4}";
//		String date2 = "\\d{1}-\\d{1}-\\d{4}";
//		String date3 = "\\d{1}/\\d{1}/\\d{4}";
//		String date4 = "\\d{2}/\\d{2}/\\d{4}";
//		String input = scan.next();
//		if(input.matches(date1)||input.matches(date2)||input.matches(date3)||input.matches(date4)){
//			scan.close();
//			return true;
//		}
//		else{
//			scan.close();
//			return false;
//		}
//	}
	
	public String toString() {
		return birthdayFormat.format(birthday);
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
//	public String reformatDate(String date) {
//		String[] temp = date.split("\\D");
//		if(temp.length == 3) {
//			for(int i = 0; i<2; i++) {
//				if(temp[i].length()<2) {
//					temp[i] = "0"+temp[i];
//				}
//			}
//			birthdayString = temp[0] + "/" + temp[1] + "/" + temp[2];
//		}
//		return birthdayString;
//	}
	
}
