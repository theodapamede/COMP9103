/*
 * Week 4
 * Title: NonzeroAverage
 * Description: Calculate the average of non-zero values of an int array
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class W4_homework_2 {
	public static void main(String[]args){
		int[] array = new int[args.length];
		double sum=0, count=0;
		double average=0;
		if(array.length>0){
			for(int i=0; i<array.length; i++){
				array[i] = Integer.parseInt(args[i]);
				if(array[i]!=0){
					sum=sum+array[i];
					count=count+1;
				}
			}			
		}
		average=sum/count;
		System.out.println(average);
	}
}
