/*
 * Week 3
 * Title: Exercise 2 - Triangle
 * Description: Takes in a value between 1 and 9 and prints a triangle, such that the base has all the numbers with spaces between numbers.
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class Triangle {
	public static void main(String[]args){
		int input = Integer.parseInt(args[0]); //input takes in values between 1 and 9.
		if ((input<1)||(input>9)){
			System.out.print("Please enter a value between 1 and 9.");
		}
		else{
			for (int i=1; i <= input; i++){
				for (int j=1; j <= i; j++){
					System.out.print(j+" ");
				}
				System.out.println();
			}
		}
	}

}
