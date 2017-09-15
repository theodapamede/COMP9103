/*
 * Week 4
 * Title: Upper and Lower
 * Description: Count the number of occurrences of each case-insensitive letter in the input string
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class W4_homework_3 {
	public static void main(String[]args){
		String word = args[0];
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		int low=0, high=0;
		for(int i=0; i<word.length(); i++){
			for(int j=0; j<upper.length(); j++){
				if(word.charAt(i)==upper.charAt(j))
					high=high+1;
			}
		}
		for(int i=0; i<word.length(); i++){
			for(int j=0; j<lower.length(); j++){
				if(word.charAt(i)==lower.charAt(j))
					low=low+1;
			}
		}
		System.out.println("Uppercase: "+high);
		System.out.println("Lowercase: "+low);
	}
}
