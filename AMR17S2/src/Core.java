/**
 * The core system:
 * - Collection of all members
 * @author Theo Dapamede
 *
 */
import java.util.*;
import java.io.*;

public class Core {
	//Fields
	private ArrayList<MemberBio> memberDB;
	public static final String DASHSHORT = new String(new char[7]).replace("\0", "-");
	public static final String DASHLONG = new String(new char[31]).replace("\0", "-");
	public File instructions;
	public File members;
	public File report;
	public File results;

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
		if(!member.getName().equals("INVALID")) memberDB.add(member);
	}
	
	/*
	 * Delete members by number
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
	public String query(String s) {
		String[]command = s.split(" ");
		if(command[0].equals("query") && command[1].equals("tier") && (command[2].equalsIgnoreCase("Silver")||command[2].equalsIgnoreCase("Gold")||command[2].equalsIgnoreCase("Platinum"))) {
			ArrayList<MemberBio> queryTier = new ArrayList<MemberBio>();
			for(MemberBio m : memberDB) {
				if(m.getTier().equalsIgnoreCase(command[2])) {
					queryTier.add(m);
				}
			}
			//Sort
			this.sort();
			System.out.println(DASHSHORT+"query tier "+command[2]+DASHSHORT);
			this.printAll(queryTier);
			System.out.println(DASHLONG);			
			System.out.println();
		}
		else if(command[0].equals("query") && command[1].equals("age") && command[2].equalsIgnoreCase("mileage")) {
			int total = memberDB.size();
			double one=0, two=0, three=0, four=0, five=0;
			System.out.println(DASHSHORT+"query age mileage"+DASHSHORT);
			System.out.println("Total Airline Members: "+total);
			System.out.println("Age based mileage distribution");
			System.out.printf("(0, 8]: %.2f\n", one);
			System.out.printf("(8, 18]: %.2f\n", two);
			System.out.printf("(18, 65]: %.2f\n", three);
			System.out.printf("(65, -]: %.2f\n", four);
			System.out.printf("Unknown: %.2f\n", five);
			System.out.println(DASHLONG);
		}
		return null;
	}
	
	/*
	 * Sort
	 */
	public void sort() {
		int itemSorted;
		for(itemSorted=1; itemSorted<memberDB.size(); itemSorted++){
			MemberBio temp = memberDB.get(itemSorted);
			int loc = itemSorted-1;
			while(loc>=0 && memberDB.get(loc).getName().compareTo(temp.getName()) > 0){ //using compareTo() to sort based on names
				memberDB.set((loc+1), memberDB.get(loc));
				loc--;
			}
			memberDB.set((loc+1), temp);
		}
	}
	
	/*
	 * Others
	 */
	public MemberBio get(int i) {
		return memberDB.get(i);
	}
	
	public int size() {
		return memberDB.size();
	}
	
	
	//print list of all members
	public String printAll() {
		for(int i=0; i<memberDB.size(); i++) {
			String name = memberDB.get(i).getName();
			String tier = memberDB.get(i).getTier();
			int number = memberDB.get(i).getNumber();
			String birthday = memberDB.get(i).getBirthday();
			String address = memberDB.get(i).getAddress();
			double mileage = memberDB.get(i).getMileage();
			double points = memberDB.get(i).getPoints();
			System.out.printf("number\t%05d%n"
					+ "name\t%s%n"
					+ "birthday %s%n"
					+ "tier\t%s%n"
					+ "mileage\t%.2fkm%n"
					+ "points\t%.2f%n"
					+ "address\t%s%n%n",number,name,birthday,tier,mileage,points,address);
		}
		return null;
	}
	
	public String printAll(ArrayList<MemberBio> db) {
		for(int i=0; i<db.size(); i++) {
			String name = db.get(i).getName();
			String tier = db.get(i).getTier();
			int number = db.get(i).getNumber();
			String address = db.get(i).getAddress();
			double mileage = db.get(i).getMileage();
			double points = db.get(i).getPoints();
			System.out.printf("number\t%05d%n"
					+ "name\t%s%n"
					+ "tier\t%s%n"
					+ "mileage\t%.2fkm%n"
					+ "points\t%.2f%n"
					+ "address\t%s%n%n",number,name,tier,mileage,points,address);
		}
		return null;
	}
	
}
