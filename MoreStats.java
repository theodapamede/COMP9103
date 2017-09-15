
public class MoreStats {
	public static void main(String[]args){
		final int N = Integer.parseInt(args[0]);
		int[][] square = new int[N][N];
		int k=1, sum=0, min=Integer.parseInt(args[1]), max=min;
		double average=0;
		int colsum=0, rowsum=0, diagsum=0;
		if(square.length>0){
			System.out.println("Please input "+(N*N)+" values,");
			System.out.println("to create a "+N+" by "+N+" square:");
			for(int i=0; i<square.length; i++){
				for(int j=0; j<square.length; j++){
					square[i][j]=Integer.parseInt(args[k]);
					sum = sum+square[i][j];
					if(square[i][j]<min)
						min=square[i][j];
					else if(square[i][j]>max)
						max=square[i][j];
					System.out.print(square[i][j]);
					k++;
				}
				System.out.println();
			}
			average=sum/(N*N);
			System.out.printf("Sum: %2d Average: %2.1f Min: %2d Max: %2d\n",sum, average, min, max);
			
			//Calculating the sum of every column and row
			for(int j=0; j<square.length; j++){
				for(int i=0; i<square.length; i++){
					colsum=colsum+square[i][j];
				}
				System.out.println("Sum of column-"+j+": "+colsum);
				colsum=0;
			}
			for(int i=0; i<square.length; i++){
				for(int j=0; j<square.length; j++){
					rowsum=rowsum+square[i][j];
				}
				System.out.println("Sum of row-"+i+": "+rowsum);
				rowsum=0;
			}
			
			//Calculating the sum of diagonals
			for(int i=0; i<square.length; i++){
				for(int j=0; j<square.length; j++){
					if(i==j || (i+j)==(N-1))
						diagsum=diagsum+square[i][j];					
				}
			}
			System.out.println("Sum of diagonals: "+diagsum);
		}
	}
}
