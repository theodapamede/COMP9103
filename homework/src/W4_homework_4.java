/*
 * Week 4
 * Title: Pascal's Triangle
 * Description: Displays the Pascal's triangle with the size determined by user
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class W4_homework_4 {
	public static void main(String[]args){
		final int N = Integer.parseInt(args[0]);
		int[][] pascal = new int[N][N];
		if(pascal.length>0){
			for(int i=0; i<pascal.length; i++){
				for(int j=0; j<=i; j++){
					if(i==j||j==0){
						pascal[i][j]=1;
					}
					else if(j>0){
						pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
					}
					System.out.print(pascal[i][j]+"   ");
				}
				System.out.println();
			}
		}
	}
}
