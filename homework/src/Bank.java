import java.util.ArrayList;
public class Bank {
	//Instances
	private ArrayList<BankAccount> accounts;
	
	//Constructors
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}
	
	//Methods
	/**
	 * Adding a new bank account
	 * @param accountNumber
	 */
	public void addAccount(BankAccount ba) {
		accounts.add(ba);
	}
	
	/**
	 * Removal of a bank account according to the given accountNumber
	 * @param accountNumber
	 */
	public void deleteAccount(int accountNumber){
		int j = 0;
		for(int i=0; i<accounts.size(); i++){
			if(accounts.get(i).getAccountNumber()==accountNumber){
				j = i;
			}
		}
		accounts.remove(j);
	}
	/**
	 * Retrieval of a bank account based on a given owner name
	 * @param accountNumber
	 * @return
	 */
	public BankAccount find(String name) {
		for(BankAccount a : accounts) {
			if(a.getOwnerName().equals(name)) {
				return a;
			}
		}
		return null;
	}
	/**
	 * Sorting the accounts according to accounts balances
	 */

	public void sort() {
		int itemSorted;
		for(itemSorted=1; itemSorted<accounts.size(); itemSorted++){
			BankAccount temp = accounts.get(itemSorted);
			int loc = itemSorted-1;
			while(loc>=0 && accounts.get(loc).getBalance() > temp.getBalance()){
				accounts.set((loc+1), accounts.get(loc));
				loc--;
			}
			accounts.set((loc+1), temp);
		}
	}

	//Get owner name from accountNumber
	public String getName(int accountNumber) {
		for(BankAccount a : accounts) {
			if(a.getAccountNumber()==accountNumber) {
				return a.getOwnerName();
			}
		}
		return null;
	}
	//Get accountNumber from owner name
	public int getAccountNumber(String name) {
		for(BankAccount a : accounts) {
			if(a.getOwnerName().equals(name)) {
				return a.getAccountNumber();
			}
		}
		return 0;
	}
	//Get balance from accountNumber
	public double getBalance(int accountNumber) {
		for(BankAccount a : accounts) {
			if(a.getAccountNumber()==accountNumber) {
				return a.getBalance();
			}
		}
		return 0;
	}
	
	public BankAccount get(int i) {
		return accounts.get(i);
	}
	
	public int size() {
		return accounts.size();
	}
	
	//List of bank accounts
	BankAccount a = new BankAccount("Alpha", 1001, 5000);
	BankAccount b = new BankAccount("Bravo", 1002, 3000);
	BankAccount c = new BankAccount("Charlie", 1003, 2000);
	BankAccount d = new BankAccount("Delta", 1004, 4000);
	BankAccount e = new BankAccount("Echo", 1005, 6000);
}
