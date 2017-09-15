/**
 * Class for member's data
 * 
 * @author Theo Dapamede
 *
 */
public class MemberBio {
	// Fields
	private int number; // check leading zeroes!
	private String name;
	private String birthday; // check format!
	private String address;
	private double mileage; //[km] 2 decimal point accuracy
	private double points; // 2 decimal point accuracy
	private String tier;


	// Constructors
	public MemberBio() {
		number = 0;
		name = null;
		birthday = null;
		address = null;
		mileage = 0;
		points = 0;
		MemberTier level = new MemberTier();
		tier = level.tier(points);
	}
	
	public MemberBio(int number, String name, String birthday, String address, double mileage, double points) {
		this.number = number;
		//SysCheck Name
		SystemCheck checkName = new SystemCheck();
		if(checkName.nameCheck(name)) {
			this.name = name;
		}
		//SysCheck Birthday
		SystemCheck checkDate = new SystemCheck();
		if(checkDate.dateCheck(birthday)) {
			this.birthday = birthday;
		}
		this.address = address;
		this.mileage = mileage;
		this.points = points;
		MemberTier level = new MemberTier();
		tier = level.tier(points);
	}
	
	// Methods
	public int getNumber() {
		return this.number;
	}
	public String getName() {
		return this.name;
	}
	public String getBirthday() {
		return this.birthday;
	}
	public String getAddress() {
		return this.address;
	}
	public double getMileage() {
		return this.mileage;
	}
	public double getPoints() {
		return this.points;
	}
	public String getTier() {
		return this.tier;
	}
	
	public void earnMileage(double km) {
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
	
	public int ageCalc(String birthday) {
		if(birthday.contains("/")) {
			String dates[] = birthday.split("/");
			int year = Integer.parseInt(dates[2]);
			int age = 2017-year;
			return age;
		}
		else if(birthday.contains("-")) {
			String dates[] = birthday.split("-");
			int year = Integer.parseInt(dates[2]);
			int age = 2017-year;
			return age;
		}
		return 0;
		
	}
}
