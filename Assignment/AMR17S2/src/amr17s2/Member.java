package amr17s2;

public class Member {
	//Fields
	private String number;
	private String name;
	private String birthday;
	private String tier;
	private double mileage;
	private double points;
	private String address;
	//Constructor
	
	public Member() {
		number = null;
		name = null;
		birthday = null;
		tier = null;
		mileage = 0;
		points = 0;
		address = null;
	}
	
	public Member(String s) {
	}
	
	public Member(String num, String nm, String bd, String ti, double mile, double pnts, String add) {
		number = num;
		name = nm;
		birthday = bd;
		tier=ti;
		mileage = mile;
		points = pnts;
		address = add;
	}
	
	//Methods
	public boolean isValidToAdd() {
		return validNumber() && validName();
	}
	
//	private boolean validName() {
//		if(name != null && name.matches("[a-zA-Z")) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	private boolean validName() {
		int a = 0;
		if(name != null && !name.isEmpty()) {
			String[] checkName = name.split(" ");
			for(int i=0; i<checkName.length; i++) { //Per word check
				for(int j=0; j<checkName[i].length();j++) { //Per letter in word check
					if(!Character.isAlphabetic(checkName[i].charAt(j))||!Character.isUpperCase(checkName[i].charAt(0))) {
						a=1;
						break;
					}
					else {
						a=2;
					}
				}
			}
		}
		if(a==2) return true;
		else return false;
	}
	
	private boolean validNumber() {
		if(number != null && !number.isEmpty() && number.matches("\\d{5}")) {
			return true;
		}
		else {
			return false;
		}
	}

	public void earnMileage(double km) {
		if(tier==null) {
			tier="Silver";
		}
		mileage = mileage + km;
		MemberTier level = new MemberTier();
		points = points + (mileage*level.tierRate(tier));
		this.updateTier();
	}
	
	public void redeemMileage(double points) {
		this.points = this.points-points;
		this.updateTier();
	}
	
	private void updateTier() {
		MemberTier level = new MemberTier();
		tier = level.tier(this.points);
	}
	
	//getters
	public String getNumber() {
		return this.number;
	}
	public String getName() {
		return this.name;
	}
	public String getBirthday() {
		return this.birthday;
	}
	public String getTier() {
		return this.tier;
	}
	public double getMileage() {
		return this.mileage;
	}
	public double getPoints() {
		return this.points;
	}
	public String getAddress() {
		return this.address;
	}
	
	public String toString() {
		return String.format(""
				+ "Number: %s\n"
				+ "Name: %s\n"
				+ "Birthday: %s\n"
				+ "Tier: %s\n"
				+ "Mileage: %.2fkm\n"
				+ "Points: %.2f\n"
				+ "Address: %s", number,name,birthday,tier,mileage,points,address);
	}
	
}
