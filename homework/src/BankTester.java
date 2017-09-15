public class BankTester {
	public static void main(String[]args) {
		Bank test = new Bank();
		
		test.addAccount(test.a);
		test.addAccount(test.b);
		test.addAccount(test.c);
		test.addAccount(test.d);
		test.addAccount(test.e);
		
		//Print all accounts
		System.out.println("Initial list:\nOwner \t AccNo \t Balance");
		for(int i=0; i<test.size(); i++) {
			System.out.println(test.get(i).getOwnerName()+"\t "+test.get(i).getAccountNumber()+"\t "+test.get(i).getBalance());
		}
		System.out.println();
		
		//add a new bank account
		test.addAccount(new BankAccount("Foxtrot", 1006, 6000));
		
		//Print all accounts
		System.out.println("After adding Foxtrot:\nOwner \t AccNo \t Balance");
		for(int i=0; i<test.size(); i++) {
		System.out.println(test.get(i).getOwnerName()+"\t "+test.get(i).getAccountNumber()+"\t "+test.get(i).getBalance());
		}
		System.out.println();
		
		//removal of a bank account
		test.deleteAccount(1001);
		
		//Print all accounts
		System.out.println("After deleting Alpha:\nOwner \t AccNo \t Balance");
		for(int i=0; i<test.size(); i++) {
		System.out.println(test.get(i).getOwnerName()+"\t "+test.get(i).getAccountNumber()+"\t "+test.get(i).getBalance());
		}
		System.out.println();
		
		test.sort();
		//Print all accounts
		System.out.println("Final sorted list:\nOwner \t AccNo \t Balance");
		for(int i=0; i<test.size(); i++) {
		System.out.println(test.get(i).getOwnerName()+"\t "+test.get(i).getAccountNumber()+"\t "+test.get(i).getBalance());
		}
		System.out.println();
				
		
	}
}