/*
 * Week 2
 * Title: Remaining Days
 * Description: This program is to calculate the day of submission.
 * Author: Theodorus Dapamede (SID. 470239731)
 */
public class RemainingDays {

	public static void main(String[] args) {
		final String TODAY = "Wednesday"; //day of today; case-insensitive
		final int DUE = 10; //number of days remaining
		int dueday=999; //initializing an arbitrary default number
		
		if (TODAY.equalsIgnoreCase("Monday"))
			dueday=1;
		else if (TODAY.equalsIgnoreCase("Tuesday"))
			dueday=2;
		else if (TODAY.equalsIgnoreCase("Wednesday"))
			dueday=3;
		else if (TODAY.equalsIgnoreCase("Thursday"))
			dueday=4;
		else if (TODAY.equalsIgnoreCase("Friday"))
			dueday=5;
		else if (TODAY.equalsIgnoreCase("Saturday"))
			dueday=6;
		else if (TODAY.equalsIgnoreCase("Sunday"))
			dueday=7;
		else
			System.out.println("You have input an invalid day for today!");
		
		dueday = dueday+DUE%7;//calculating the new "dueday"
		
		if (dueday > 7)
			dueday=dueday-7;
		
		switch (dueday){
		case 1: System.out.print("The submission is due in "+DUE+" days, which is a Monday.");break;
		case 2: System.out.print("The submission is due in "+DUE+" days, which is a Tuesday.");break;
		case 3: System.out.print("The submission is due in "+DUE+" days, which is a Wednesday.");break;
		case 4: System.out.print("The submission is due in "+DUE+" days, which is a Thursday.");break;
		case 5: System.out.print("The submission is due in "+DUE+" days, which is a Friday.");break;
		case 6: System.out.print("The submission is due in "+DUE+" days, which is a Saturday.");break;
		case 7: System.out.print("The submission is due in "+DUE+" days, which is a Sunday.");break;
		default: System.out.print("Please enter the correct values.");break;
		}
		
	}
}