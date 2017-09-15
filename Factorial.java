
public class Factorial {
	public static void main(String[]args){
		int input = Integer.parseInt(args[0]);
		int factorial = 1;
		while(input>0){
			factorial = factorial*input;
			input--;
		}
		System.out.print(factorial);
	}
}
