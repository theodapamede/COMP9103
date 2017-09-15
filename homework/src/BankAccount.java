public class BankAccount{
	//Instances
	private int accountNumber;
	private double balance;
	private String ownerName;
	
	//Constructors
	public BankAccount(int anAccountNumber) {
		accountNumber = anAccountNumber;
		balance = 0;
		ownerName = null;
	}
	public BankAccount(String name, int anAccountNumber, double initialBalance) {
		accountNumber = anAccountNumber;
		balance = initialBalance;
		ownerName = name;
	}
	
	//Methods
	public int getAccountNumber() {
		return accountNumber;
	}
	public void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}
	public void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}
	public double getBalance() {
		return balance;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void addName(String name) {
		ownerName = name;
	}
}