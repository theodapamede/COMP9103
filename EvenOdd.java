/*
 * Title: Even or Odd
 * Desc: reads single input from command, prints whether even or odd number
 */
public class EvenOdd {
	public static void main(String[]args){
		int input = Integer.parseInt(args[0]);
		if((input%2)!=0)
			System.out.println("Odd!");
		else
			System.out.println("Even!");
	}

}
