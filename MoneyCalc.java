import java.util.Scanner;
public class MoneyCalc {
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		double[] money = new double[3];
		int i = 0;
		while(i<money.length && scan.hasNextDouble()){
			money[i] = scan.nextDouble();
			i++;
		}
		double principle = money[0];
		double interest = money[1]*principle;
		double total = principle+interest;
		for(int j = 1; j<=money[2]; j++){
			System.out.printf("Year "+j+"-principle: $%7.2f Interest: $%5.2f Total: $%7.2f\n", principle, interest, total);
			principle = total;
			interest = principle*money[1];
			total = principle+interest;
		}
	}
}
