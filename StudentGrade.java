/*
 * Week 3
 * Title: Exercise 1 - Converting student's grade to mark range by switch
 * Description: Input student's grade (H, D, C, P, or F), outputs the corresponding mark range.
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class StudentGrade {
	public static void main(String[]args){
		final String INPUT = "H, D, C, P, or F";
		int output=0;
		for(int i=0; i<INPUT.length(); i++){
			if(Character.toLowerCase(INPUT.charAt(i))=='h')
				output=1;
			else if(Character.toLowerCase(INPUT.charAt(i))=='d')
				output=2;
			else if(Character.toLowerCase(INPUT.charAt(i))=='c')
				output=3;
			else if(Character.toLowerCase(INPUT.charAt(i))=='p')
				output=4;
			else if(Character.toLowerCase(INPUT.charAt(i))=='f')
				output=5;
			else
				output=0;
			switch(output){
			case 1: System.out.println("Grade: "+INPUT.charAt(i)+", Mark Range: 85-100");break;
			case 2: System.out.println("Grade: "+INPUT.charAt(i)+", Mark Range: 75-84");break;
			case 3: System.out.println("Grade: "+INPUT.charAt(i)+", Mark Range: 65-74");break;
			case 4: System.out.println("Grade: "+INPUT.charAt(i)+", Mark Range: 50-64");break;
			case 5: System.out.println("Grade: "+INPUT.charAt(i)+", Mark Range: 0-49");break;
			default: break;
			}
		}
	}
}