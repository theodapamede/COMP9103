import java.util.*;
import java.io.*;

public class AverageInFile1{
	public static void main(String[] args){
		//try-catch block is needed to control print out any errors
		
		try{
			File file = new File(args[0]); // to set up a stream from the file
			Scanner reader = new Scanner (file); // to scan the file
			double sum = 0.0; // cumulative total
			int num = 0; // number of values
			
			// compute average of values in input file
			while (reader.hasNextDouble()){
				sum += reader.nextDouble();
				num++;
			}
			if(num>0)
				System.out.println("Average of values in "+args[0]+"is "+sum/num);
		}
		
		catch(Exception e){
			System.out.println("Error "+e.getMessage())
		}
	}
}