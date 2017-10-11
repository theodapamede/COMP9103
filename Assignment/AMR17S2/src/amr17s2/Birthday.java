package AMR17S2;

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
		String date5 = "\\d{2}/\\d{1}/\\d{4}";
		String date6 = "\\d{2}-\\d{1}-\\d{4}";
		String date7 = "\\d{1}/\\d{2}/\\d{4}";
		String date8 = "\\d{1}-\\d{2}-\\d{4}";
		String input = scan.next();
		if(input.matches(date1)||input.matches(date2)||input.matches(date3)||input.matches(date4) || input.matches(date5) || input.matches(date6) || input.matches(date7) || input.matches(date8)){
			temp = birthdayString.split("\\D");
			if(temp.length == 3) {
				int day = Integer.parseInt(temp[0]);
				int month = Integer.parseInt(temp[1]);
				int year = Integer.parseInt(temp[2]);
				if(day <= 31 && day > 0 && month <= 12 && month > 0 && year > 1900 && year <= 2017) {
					for(int i = 0; i<2; i++) {
						if(temp[i].length()<2) {
							temp[i] = "0"+temp[i];
						}
					}
					birthdayString = temp[0] + "/" + temp[1] + "/" + temp[2];
				}
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
		int a = 0;
		if(birthday != null) {
			String bd = this.toString();
			String[] date = bd.split("/");
			int day = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);
			int year = Integer.parseInt(date[2]);
			if(year%4==0 && year>1900 && year<=2017) { //checks for leap year
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
					if(day>0 && day<=31) {
						a = 1;
					}
				}
				else if(month==4||month==6||month==9||month==11) {
					if(day>0 && day<=30) {
						a = 1;
					}
				}
				else if(month==2) {
					if(day>0 && day<=29) {
						a = 1;
					}
				}
			}
			else if(year%4!=0 && year>1900 && year<=2017) {
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
					if(day>0 && day<=31) {
						a = 1;
					}
				}
				else if(month==4||month==6||month==9||month==11) {
					if(day>0 && day<=30) {
						a = 1;
					}
				}
				else if(month==2) {
					if(day>0 && day<=28) {
						a = 1;
					}
				}
			}
		}
		if(a == 1 && birthday!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		if(birthday != null) {
			return birthdayFormat.format(birthday);
		}
		else return null;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public int getAge() {
		String bd = this.toString();
		String[] temp = bd.split("/");
		int year = Integer.parseInt(temp[2]);
		int age = 2017-year;
		return age;
	}

}
