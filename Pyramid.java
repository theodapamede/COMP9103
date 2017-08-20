/*
 * Week 3
 * Title: Exercise 3 - Pyramid
 * Description: Takes in odd positive integer n from command-line and outputs a pyramid
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class Pyramid {
	public static void main(String[]args){
		int input = Integer.parseInt(args[0]); //takes in an odd positive integer
		if ((input%2==0)||(input<=0)){ //check whether input is correct or not
			System.out.print("Please input an odd positive integer.");
		}
		else{
			for(int line=1;line<=input;line=line+2){
				for(int space=input;space>line;space=space-2){
					System.out.print(" ");
				}
				for(int star=1;star<=line;star++){
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}