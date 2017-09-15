/**
 * Tier system
 * @author Theo Dapamede
 *
 */
public class MemberTier {
	//Fields
	public static int silver = 0;
	public static int gold = 5000;
	public static int platinum = 10000;
	
	//Constructors
	public MemberTier() {}
	
	//Methods
	public String tier(double points) {
		if(points>=silver && points<gold) {
			return "Silver";
		}
		else if(points>=gold && points<platinum) {
			return "Gold";
		}
		else if(points>=platinum) {
			return "Platinum";
		}
		return null;
	}
	
	public double tierRate(String tier) {
		if(tier.equals("Silver")) return 0.25;
		else if(tier.equals("Gold")) return 0.5;
		else if(tier.equals("Platinum")) return 1;
		return 0;
	}
	
}
