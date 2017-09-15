/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {

	// instance fields
	private double balance;
	String ownerName;
	double rate;
	static int AccNo;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
		ownerName = null;
		rate = 0;
		AccNo = 0;
	}

	/**
	 * Constructs a bank account for the user with a given balance.
	 */
	public BankAccount(String name, double initialBalance, double interest, int acc) {
		balance = initialBalance;
		ownerName = name;
		rate = interest;
		AccNo = acc;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 */
	public void deposit(double amount) {
		if (amount > 0)
			balance = balance + amount;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount
	 *            the amount to withdraw
	 */
	public void withdraw(double amount) {
		if (balance >= amount)
			balance = balance - amount;
	}
	
	public void addRate(double interest){
		if (interest>0)
			rate = interest;
	}
	
	public void addAcc(int acc){
		if (acc>0)
			AccNo = acc;
	}
	
	public void addOwner(String own){
		ownerName = own;
	}
	
	public int getAccNo(){
		return AccNo;
	}
	
	public String owner(){
		return ownerName;
	}
	
	public double getRate(){
		return rate;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	public double getEndofMonthBalance(){
		double endofMonthBalance = balance + (balance*rate);
		return endofMonthBalance;
	}

}
