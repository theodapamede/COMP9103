package amr17s2;

import java.util.*;

public class MembersDB {
	//Fields
	private ArrayList<Member> database;
	
	//Constructors
	public MembersDB() {
		database = new ArrayList<Member>();
	}
	
	//Methods
	
	//AddMember
	public void addMember(String s) {
		Member member = new Member(s);
		if(member.isValidToAdd()) {
			database.add(member);
		}
	}
	
	public void addMember(Member m) {
		if(m.isValidToAdd()){
			database.add(m);
		}
	}
	
	//DeleteMember
	public void deleteMember(String param) {
		param = param.trim();
		int i = 0;
		while (i < database.size()) {
			if(database.get(i).getName().equalsIgnoreCase(param)) {
				database.remove(i);
			}
			else if(database.get(i).getNumber().equalsIgnoreCase(param)) {
				database.remove(i);
			}
			else {
				i++;
			}
		}
	}
	//DeleteMember if given number
//	public void deleteMember(int number) {
//		int i = 0;
//		while(i < database.size()) {
//			if(database.get(i).getNumber()==number) {
//				database.remove(i);
//			}
//			else {
//				i++;
//			}
//		}
//	}
	
	//toString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Member m : database) {
			sb.append(m.toString());
			sb.append("\n\n");
		}
		return sb.toString();
	}
	
	public ArrayList<Member> getDatabase(){
		return database;
	}
	
	public void setDatabase(ArrayList<Member> database) {
		this.database = database;
	}
	
	public int size() {
		return database.size();
	}
	
	public Member get(int index) {
		return database.get(index);
	}
	
	public void sort() {
		int itemSorted;
		for(itemSorted=1; itemSorted<database.size(); itemSorted++){
			Member temp = database.get(itemSorted);
			int loc = itemSorted-1;
			while(loc>=0 && database.get(loc).getName().compareTo(temp.getName()) > 0){ //using compareTo() to sort based on names
				database.set((loc+1), database.get(loc));
				loc--;
			}
			database.set((loc+1), temp);
		}
	}

}
