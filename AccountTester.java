
public class AccountTester {
	public static void main(String[]args){
		BankAccount one = new BankAccount();
		BankAccount two = new BankAccount("John Doe", 5000, 0.05, 12345);
		System.out.println(two.owner());
		one.deposit(10000);
		one.addRate(0.02);
		one.addOwner("Jane Doe");
		two.withdraw(2500);
		System.out.println(one.getEndofMonthBalance());
		System.out.println(two.getEndofMonthBalance());
	}

}
