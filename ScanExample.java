import java.util.Scanner;
public class ScanExample {
	public static void main(String[]args){
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		while(N>1){
			int X = N;
			int tfac = 2;
			while(tfac <= N){
				if(X%tfac==0){
					X = X/tfac;
					System.out.print(tfac+" ");
				}
				else tfac=tfac+1;
			}
			System.out.println();
			N=scn.nextInt();
		}
		scn.close();
	}

}
