import java.util.ArrayList;
public class BankTester2 {
	public static void main(String[]args) {
		Bank2 test = new Bank2();
		test.addAccount(new BankAccount("Romeo",1020,2009));
		test.deleteAccount(1020);
		
		ArrayList<BankAccount> sorting = new ArrayList<BankAccount>();
		BankAccount one = new BankAccount("One", 1001, 6000);
		BankAccount two = new BankAccount("Two", 1002, 5000);
		BankAccount three = new BankAccount("Three", 1003, 4000);
		
		sorting.add(one);
		sorting.add(two);
		sorting.add(three);
		
		for(int i=0; i<sorting.size(); i++) {
			System.out.println(sorting.get(i).getBalance());
		}
		System.out.println();
		int itemSorted;
		for(itemSorted=1; itemSorted<sorting.size(); itemSorted++) {
			BankAccount temp = sorting.get(itemSorted);
			int loc = itemSorted-1;
			while(loc>=0 && sorting.get(loc).getBalance() > temp.getBalance()) {
				sorting.set((loc+1), sorting.get(loc));
				loc--;
			}
			sorting.set((loc+1), temp);
		}
		
		for(int i=0; i<sorting.size(); i++) {
			System.out.println(sorting.get(i).getBalance());
		}
		
	}
}
