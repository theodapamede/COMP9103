/*
 * Week 4
 * Title: FirstMatch
 * Description: Search for the first match of a given string in a string array
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class W4_homework_1 {
	public static void main(String[]args){
		String keyword = args[0];
		int n=0;
		for(int i=1; i<args.length; i++){
			if((n==0)&&(keyword.equals(args[i]))){
				n=i-1;
				System.out.println("The index of the first match of '"+keyword+"' is "+n+".");
			}
		}
	}
}
