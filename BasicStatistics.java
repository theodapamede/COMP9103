
public class BasicStatistics {
	public static void main(String[]args){
		int N = Integer.parseInt(args[0]);
		double[] stats = new double[N];
		double sum=0, average=0, min=Integer.parseInt(args[1]), max=min;
		int low=0, high=0;
		if(stats.length>0){
			for(int i=0; i<stats.length; i++){
				stats[i] = Integer.parseInt(args[i+1]);
				sum = sum+stats[i];
				if(stats[i]<min){
					min=stats[i];
				}
				else if(stats[i]>max){
					max=stats[i];
				}
			}
			average=sum/N;
			for(int j=0; j<stats.length; j++){
				if(stats[j]<average){
					low=low+1;
				}
				else if(stats[j]>average){
					high=high+1;
				}
			}
		}
		System.out.printf("Sum: %2.1f, Average: %2.1f, Min: %2.1f, Max: %2.1f, Smaller: %2d, Larger: %2d", sum, average, min, max, low, high);
	}
}
