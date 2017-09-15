/**
 * The core system:
 * - Collection of all members
 * @author Theo Dapamede
 *
 */
import java.util.ArrayList;

public class Core {
	//Fields
	private ArrayList<MemberBio> memberDB;
	public static final String DASHSHORT = new String(new char[4]).replace("\0", "-");
	public static final String DASHLONG = new String(new char[25]).replace("\0", "-");

	//Constructors
	public Core() {
		memberDB = new ArrayList<MemberBio>();
	}
	//Methods
	
	/*
	 * Read from files
	 */
	
	
	/*
	 * Add valid members into system
	 */
	public void addMember(MemberBio member) {
		memberDB.add(member);
	}
	
	/*
	 * Delete members by number or name
	 */
	public void deleteMember(int number){
		int j = 0;
		for(int i=0; i<memberDB.size(); i++){
			if(memberDB.get(i).getNumber()==number){
				j = i;
			}
		}
		memberDB.remove(j);
	}
	
	/*
	 * Earn and Redeem points
	 */
	public void earnMileage(int number, double km) {
		for(MemberBio m : memberDB) {
			if(m.getNumber()==number) {
				m.earnMileage(km);
			}
		}
	}
	
	public void redeemMileage(int number, double points) {
		for(MemberBio m : memberDB) {
			if(m.getNumber()==number) {
				m.redeemMileage(points);
			}
		}
	}
	
	/*
	 * Query
	 */
	public String query(String[] command) {
		if(command[0].equals("query") && command[1].equals("tier") && command[2].equals("Silver")) {
			ArrayList<MemberBio> queryTier = new ArrayList<MemberBio>();
			for(MemberBio m : memberDB) {
				if(m.getTier().equals(command[2])) {
					queryTier.add(m);
				}
			}
			//Sort
			this.sort(queryTier);
			System.out.println(DASHSHORT+"query tier "+command[2]+DASHSHORT);
			for(MemberBio m : queryTier) {
				System.out.println(m);
			}
			System.out.println(DASHLONG);
			System.out.println();
		}
		else if(command[0].equals("query") && command[1].equals("age") && command[2].equals("mileage")) {
			int total = memberDB.size();
			double one=0, two=0, three=0, four=0, five=0;
			for(MemberBio m : memberDB) {
				int age = m.ageCalc(m.getBirthday());
				if(age>65) {
					four = four+m.getMileage();
				}
				else if(age>18) {
					three = three+m.getMileage();
				}
				else if(age>8) {
					two = two+m.getMileage();
				}
				else if(age>0) {
					one = one+m.getMileage();
				}
				else five = five+m.getMileage();
			}
			System.out.println(DASHSHORT+"query age mileage"+DASHSHORT);
			System.out.println("Total Airline Members: "+total);
			System.out.println("Age based mileage distribution");
			System.out.printf("(0, 8]: %f\n", one);
			System.out.printf("(8, 18]: %f\n", two);
			System.out.printf("(18, 65]: %f\n", three);
			System.out.printf("(65, -]: %f\n", four);
			System.out.printf("Unknown: %f\n", five);
			System.out.println(DASHLONG);
		}
		return null;
	}
	
	/*
	 * Sort
	 */
	public void sort(ArrayList<MemberBio> db) {
		int itemSorted;
		for(itemSorted=1; itemSorted<db.size(); itemSorted++){
			MemberBio temp = db.get(itemSorted);
			int loc = itemSorted-1;
			while(loc>=0 && db.get(loc).getName().compareTo(temp.getName()) < 0){ //using compareTo() to sort based on names
				db.set((loc+1), db.get(loc));
				loc--;
			}
			db.set((loc+1), temp);
		}
	}
}
