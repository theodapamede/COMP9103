package AMR17S2;

public class Address {
	//Fields
	private String address;
	private String street;
	private String suburb;
	private String state;
	private int postcode;
	
	//Constructors
	public Address(String s) {
		String[] temp = s.split(",");
		if(temp.length==4) {
			try {
				street = temp[0].trim();
				suburb = temp[1].trim();
				state = temp[2].trim();
				if(temp[3].trim().matches("\\d{4}")) {
					postcode = Integer.parseInt(temp[3].trim());
					address = s;
				}
				else {
					address = null;
				}
			}
			catch(Exception e) {
				address = null;
			}
		}
	}
	
	//Methods
	public String getAddress() {
		return String.format("%s, %s, %s, %d", street, suburb, state, postcode);
	}
	
	public boolean checkAddress() {
		if(address != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
