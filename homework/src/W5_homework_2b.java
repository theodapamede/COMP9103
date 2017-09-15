import java.util.Scanner;
public class W5_homework_2b {
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		String salaryList = scan.nextLine();
		String salary[] = salaryList.split("\\$");
		double[] array = new double[salary.length-1];
		for(int i=0; i<salary.length; i++)
			if(i>0) array[i-1]= Double.parseDouble(salary[i]);
		double total = 0;
		for(int i=0; i<array.length; i++){
			total = total + array[i];
		}
		//insertion-sort
		for(int itemSorted=1; itemSorted<array.length; itemSorted++){
			double temp = array[itemSorted];
			int loc = itemSorted-1;
			while(loc>=0 && array[loc]>temp){
				array[loc+1]=array[loc];
				loc--;
			}
			array[loc+1]=temp;
		}
		
		double average = total/array.length;
		int greater = 0, lesser=0;
		for(int i=0; i<array.length; i++){
			if(array[i]>average) greater++;
			else if(array[i]<average) lesser++;
		}
		System.out.println("Total: "+total+"\n Average: "+average+" \n >average: "+greater+"\n <average: "+lesser);
		scan.close();
	}

}
