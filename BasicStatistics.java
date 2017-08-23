
public class BasicStatistics {
	public static void main(String[]args){
		double[] input = new double[Integer.parseInt(args[0])];
		double sum=0;
		int minIndex=0, maxIndex=0;
		for(int i=0; i<input.length; i++){ //sum
			input[i]= Integer.parseInt(args[i]);
			sum += input[i];
		}
		for(int i=0;i<input.length; i++){ //max
			if(input[i]>input[maxIndex])
				maxIndex=i;
		}
		for(int i=0;i<input.length;i++){ //min
			if(input[i]<input[minIndex])
				minIndex=i;
		}
		double average = (sum/input.length);
		
		int smaller=0;
		for(int i=0;i<input.length;i++){
			if(input[i]>average)
				smaller++;
		}
		
		int larger=0;
		for(int i=0;i<input.length;i++){
			if(input[i]<average)
				larger++;
		}
		
		System.out.println("Sum "+sum);
		System.out.println("Average "+average);
		System.out.println("Min "+input[minIndex]);
		System.out.println("Max "+input[maxIndex]);		
		System.out.println("Smaller "+smaller);
		System.out.println("Larger "+larger);
	}

}
