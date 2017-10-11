package AMR17S2;

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
		mileage = -1;
		points = -1;
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
	
	private boolean validName() {
		int a = 0;
		int b = 0;
		if(name != null && !name.isEmpty()) {
			String[] checkName = name.split(" ");
			for(int i=0; i<checkName.length; i++) { //Per word check
				for(int j=0; j<checkName[i].length();j++) { //Per letter in word check
					if(!Character.isAlphabetic(checkName[i].charAt(j))||!Character.isUpperCase(checkName[i].charAt(0))) {
						a=1;
						break;
					}
					else {
						b=1;
					}
				}
			}
		}
		if(a==0 && b==1) return true;
		else return false;
	}
	
	private boolean validName(String s) {
		int a = 0;
		int b = 0;
		if(s != null && !s.isEmpty()) {
			String[] checkName = s.split(" ");
			for(int i=0; i<checkName.length; i++) { //Per word check
				for(int j=0; j<checkName[i].length();j++) { //Per letter in word check
					if(!Character.isAlphabetic(checkName[i].charAt(j))||!Character.isUpperCase(checkName[i].charAt(0))) {
						a=1;
						break;
					}
					else {
						b=1;
					}
				}
			}
		}
		if(a==0 && b==1) return true;
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
		if(mileage==-1) {
			mileage=0;
			mileage=km;
		}
		else {
			mileage = mileage + km;
		}
		MemberTier level = new MemberTier();
		if(points==-1) {
			points=0;
			points=mileage*level.tierRate(tier);
		}
		else {
			points = points + (mileage*level.tierRate(tier));
		}
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
	public int getAge() {
		Birthday date = new Birthday(birthday);
		int age = date.getAge();
		return age;
	}
	
	//setters
	public void addName(String s) {
		if(validName(s)) {
			name = s;
		}
	}
	
	public void addBirthday(String s) {
		Birthday date = new Birthday(s);
		if(date.checkBirthday()) {
			birthday=s;
		}
		else birthday=null;
	}
	
	public void addTier(String s) {
		if(points==-1 && s.equals("Silver") || s.equals("Gold") || s.equals("Platinum")) {
			tier=s;
		}
		else {
			if(points < MemberTier.gold && s.equals("Silver")) tier=s;
			else if(points >= MemberTier.gold && points < MemberTier.platinum && s.equals("Gold")) tier=s;
			else if(points >= MemberTier.platinum && s.equals("Platinum")) tier=s;
			else tier = null;
		}
	}
	
	public void addMileage(double km) {
		if(km>0 && mileage==-1) { //if mileage is default value
			mileage = 0;
			mileage = km;
		}
		else if(km>0 && mileage>=0) {
			mileage = mileage + km;
		}
	}
	
	public void addPoints(double p) {
		if(p>0 && points==-1) { //if points is default value
			points = 0;
			points = p;
		}
		else if(p>0 && points>=0) {
			points = points + p;
		}
	}
	
	public void addAddress(String s) {
		Address loc = new Address(s);
		if(loc.checkAddress()) address=s;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(number!=null && !number.isEmpty()) {
			sb.append("number    "+number+"\n");
		}
		if(name!=null && !name.isEmpty()) {
			sb.append("name      "+name+"\n");
		}
		if(birthday!=null && !birthday.isEmpty()) {
			sb.append("birthday  "+birthday+"\n");
		}
		if(tier!=null && !tier.isEmpty()) {
			sb.append("tier      "+tier+"\n");
		}
		if(mileage>=0) {
			sb.append(String.format("mileage   %.2fkm\n", mileage));
		}
		if(points>=0) {
			sb.append(String.format("points    %.2f\n", points));
		}
		if(address!=null && !address.isEmpty()) {
			sb.append("address   "+address+"\n");
		}
		return sb.toString();
	}
}
