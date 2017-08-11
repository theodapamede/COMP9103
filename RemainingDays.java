/*
 * This program is to calculate the remaining days
 * for submission.
 * Days: Monday = 1 ... Sunday = 7
 */
public class RemainingDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int TODAY = 3;
		final int DUE = 10;
		int due_day=TODAY+DUE%7;
		if (due_day > 7){
			System.out.println(due_day-7);
		}
		else{
			System.out.println(due_day);
		}
	}
}