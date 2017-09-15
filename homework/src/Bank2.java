import java.util.ArrayList;

public class Bank2{
	
	private ArrayList<BankAccount> accounts;
	
	public Bank2(){
		accounts = new ArrayList<BankAccount>();
	}
	
	public BankAccount get(int i){
		return this.get(i);
	}
	
	public int size(){
		return this.size();
	}
	
	public void addAccount(BankAccount ba){
		accounts.add(ba);
	}
	
	public void deleteAccount(int accountNumber){
		int j = 0;
		for(int i=0; i<accounts.size(); i++){
			if(accounts.get(i).getAccountNumber()==accountNumber){
				j = i;
			}
		}
		accounts.remove(j);
	}
	
	public BankAccount find(String name){
		for(BankAccount a : accounts){
			if(a.getOwnerName().equals(name)){
				return a;
			}
		}
		return null;
	}
	
	BankAccount s = new BankAccount("Sleep",1010,4321);
}
	
	