import java.util.*;
import java.io.*;

public class TextFileO{
	public static void main(String[] args){
		//try-catch block is needed to control print out any errors
		
		try{
			File file = new File(args[0] + ".txt"); // 
			PrintWriter out = new PrintWriter (file); // 
			Scanner in = new Scanner(System.in);
			
			while (in.hasNextInt()){
				out.printf("%d", in.nextInt());
				out.println();
			}
			out.close();
			System.out.println("inputs written into file successfully!");
		}
		
		catch(FileNotFoundException e){
			System.out.println("The file not found.")
		}
	}
}