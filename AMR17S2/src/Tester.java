
public class Tester {
	public static void main(String[]args) {
		Core jet = new Core();
		MemberBio a = new MemberBio(1001, "Charlie");
		MemberBio b = new MemberBio(1002, "Brave");
		MemberBio c = new MemberBio(1003, "Alpha");
		MemberBio d = new MemberBio(1004, "WilliadkdD Matata");
		
		jet.addMember(a);
		jet.addMember(b);
		jet.addMember(c);
		jet.addMember(d);

		double n = 10000;
		for(int i=0; i<jet.size(); i++) {
			jet.get(i).earnMileage(n);
			n += 20000;
		}
		System.out.println("Initial");
		jet.printAll();
		jet.sort();
		System.out.println("\nAfter sorted");
		jet.printAll();
		
		jet.query("query tier silver");
		jet.query("query age mileage");
	}
}
