package AMR17S2;

import java.util.*;
import java.io.*;

public class Control {
	//Fields
	private File membersFile;
	private File instructionFile;
	private File resultsFile;
	private File reportFile;
	private MembersDB membersDB;
	
	//Constructors
	public Control(String[] s) {
		membersFile = new File(s[0]);
		instructionFile = new File(s[1]);
		resultsFile = new File(s[2]);
		reportFile = new File(s[3]);
		membersDB = new MembersDB();
	}
	
	//Methods
	
	//ReadMembersFile
	public void readMembers() {
		try {
			Scanner scan = new Scanner(membersFile);
			String name=null, tier=null, address=null, birthday=null, number=null;
			double mileage=-1, points=-1;
			while(scan.hasNextLine()) {
				String memberData = scan.nextLine();
				Scanner sc = new Scanner(memberData);
				String keyword, param;
				if(sc.hasNext()) {
					keyword = sc.next();
					if(sc.hasNextLine()) {
						param = sc.nextLine().trim();
						if(keyword.equalsIgnoreCase("number")) {
							number = param;
						}
						else if(keyword.equalsIgnoreCase("name")) {
							name = param;
						}
						else if(keyword.equalsIgnoreCase("tier")) {
							tier = param;
						}
						else if(keyword.equalsIgnoreCase("mileage")) {
							String[]miles = param.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
							mileage = Double.parseDouble(miles[0]);
						}
						else if(keyword.equalsIgnoreCase("points")) {
							points = Double.parseDouble(param);
						}
						else if(keyword.equalsIgnoreCase("address")) {
							Address loc = new Address(param);
							if(loc.checkAddress()) {
								address = param;
							}
						}
						else if(keyword.equalsIgnoreCase("birthday")) {
							Birthday date = new Birthday(param);
							if(date.checkBirthday()) {
								birthday = date.toString();
							}
						}
					}
				}
				else {
					Member newMember = new Member(number, name, birthday, tier, mileage, points, address);
					membersDB.addMember(newMember);
					number = null;
					name=null;
					tier=null;
					address=null;
					mileage=-1;
					points=-1;
					birthday=null;
				}
				
				sc.close();
			}
			scan.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//ReadInstructionFile
	public void readInstruction() {
		try {
			Scanner scan = new Scanner(instructionFile);
			while(scan.hasNextLine()){
				String instruction = scan.nextLine();
				Scanner sc = new Scanner(instruction);
				String keyword, param;
				if(sc.hasNext()) {
					keyword = sc.next();
					if(sc.hasNextLine()) {
						param = sc.nextLine().trim();
						if(keyword.equalsIgnoreCase("add")) {
							String[] temp = param.split(";");
							String[] numb = temp[0].trim().split("\\s");
							//check if there exists a member with the same number
							int exist = 0;
							int location = -1;
							for(int i=0; i<membersDB.size();i++) {
								if(membersDB.get(i).getNumber().equals(numb[1])) {
									exist = 1;
									location = i;
								}
							}
							if(exist==1) { //update existing member
								for(int i=1; i<temp.length;i++) {
									Scanner updater = new Scanner(temp[i]);
									String key = updater.next().trim();
									String input = updater.nextLine().trim();
									if(key.equalsIgnoreCase("tier")) {
										membersDB.get(location).addTier(input);
									}
									else if(key.equalsIgnoreCase("name")) {
										membersDB.get(location).addName(input);
									}
									else if(key.equalsIgnoreCase("birthday")) {
										membersDB.get(location).addBirthday(input);
									}
									else if(key.equalsIgnoreCase("mileage")) {
										String[]miles = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
										double mileage = Double.parseDouble(miles[0]);
										membersDB.get(location).addMileage(mileage);
									}
									else if(key.equalsIgnoreCase("points")) {
										double p = Double.parseDouble(input);
										membersDB.get(location).addPoints(p);
									}
									else if(key.equalsIgnoreCase("address")) {
										membersDB.get(location).addAddress(input);
									}
									updater.close();
								}
							}
							else { //add new member
								String name=null, tier=null, address=null, birthday=null, number=null;
								double mileage=-1, points=-1;
								for(int i=0; i<temp.length; i++) {
									Scanner adder = new Scanner(temp[i]);
									String kw = adder.next().trim();
									String input = adder.nextLine().trim();
									if(kw.equalsIgnoreCase("number")) {
										number = input;
									}
									else if(kw.equalsIgnoreCase("name")) {
										name = input;
									}
									else if(kw.equalsIgnoreCase("tier")) {
										tier = input;
									}
									else if(kw.equalsIgnoreCase("mileage")) {
										String[]miles = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
										mileage = Double.parseDouble(miles[0]);
									}
									else if(kw.equalsIgnoreCase("points")) {
										points = Double.parseDouble(input);
									}
									else if(kw.equalsIgnoreCase("address")) {
										Address loc = new Address(input);
										if(loc.checkAddress()) {
											address = input;
										}
									}
									else if(kw.equalsIgnoreCase("birthday")) {
										Birthday date = new Birthday(input);
										if(date.checkBirthday()) {
											birthday = date.toString();
										}
									}
									adder.close();
								}
								Member newMember = new Member(number, name, birthday, tier, mileage, points, address);
								membersDB.addMember(newMember);
							}
						}
						else if(keyword.equalsIgnoreCase("delete")) {
							Scanner sc2 = new Scanner(param);
							String toDelete = sc2.next();
							if(sc2.hasNextLine() && toDelete.equalsIgnoreCase("name") || toDelete.equalsIgnoreCase("number")) {
								param = sc2.nextLine().trim();
								membersDB.deleteMember(param);
								}
							sc2.close();
						}
						else if(keyword.equalsIgnoreCase("earn")) {
							String[] temp = param.split(";");
							String mileage = temp[1].trim();
							String[] num = temp[0].split(" ");
							String number = num[1];
							String[] mile = mileage.split(" ");
							mileage = mile[1]; //mileage is double with km unit
							mile = mileage.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
							double km = Double.parseDouble(mile[0]);
							Scanner scNumber = new Scanner(number);
							for(int i=0; i<membersDB.size(); i++) {
								if(membersDB.get(i).getNumber().equalsIgnoreCase(number)) {
									membersDB.get(i).earnMileage(km);
								}
							}
							scNumber.close();
						}
						else if(keyword.equalsIgnoreCase("redeem")) {
							String[] temp = param.split(";");
							String redeemPoints = temp[1].trim();
							String[] num = temp[0].split(" ");
							String number = num[1];
							String[] point = redeemPoints.split(" ");
							double points = Double.parseDouble(point[1]);
							Scanner scNumber = new Scanner(number);
							for(int i=0; i<membersDB.size(); i++) {
								if(membersDB.get(i).getNumber().equalsIgnoreCase(number)) {
									membersDB.get(i).redeemMileage(points);
								}
							}
							scNumber.close();
						}
						else if(keyword.equalsIgnoreCase("query")) {
							String[] temp = param.trim().split("\\s");
							if(temp[0].equalsIgnoreCase("tier")) {
								MembersDB queryTier = new MembersDB();
								for(int i=0;i<membersDB.size();i++) {
									if(membersDB.get(i).getTier()!=null && membersDB.get(i).getTier().equalsIgnoreCase(temp[1])) {
										queryTier.addMember(membersDB.get(i));
									}
								}
								queryTier.sort();
								this.writeReport(queryTier, temp[1]);
							}
							else if(temp[0].equalsIgnoreCase("age")) {
								int total = membersDB.size();
								MembersDB one = new MembersDB();   // (0..8]
								MembersDB two = new MembersDB();   // (8..18]
								MembersDB three = new MembersDB(); // (18..65]
								MembersDB four = new MembersDB();  // (65..-)
								MembersDB unknown = new MembersDB(); // unknown
								for(int i=0; i<membersDB.size(); i++) { //grouping based on age
									if(membersDB.get(i).getBirthday()!=null) {
										int age = membersDB.get(i).getAge();
										if(age<=8) {
											one.addMember(membersDB.get(i));
										}
										else if(age<=18) {
											two.addMember(membersDB.get(i));
										}
										else if(age<=65) {
											three.addMember(membersDB.get(i));
										}
										else if(age>65) {
											four.addMember(membersDB.get(i));
										}
									}
									else {
										unknown.addMember(membersDB.get(i));
									}
								}
								double sum1 = 0;
								double sum2 = 0;
								double sum3 = 0;
								double sum4 = 0;
								double sumUnknown = 0;
								for(int i=0; i<one.size(); i++) {
									if(one.get(i).getMileage()>=0) {
										sum1 = sum1 + one.get(i).getMileage();
									}
									else continue;
								}
								for(int i=0; i<two.size(); i++) {
									if(two.get(i).getMileage()>=0) {
										sum2 = sum2 + two.get(i).getMileage();
									}
									else continue;
								}
								for(int i=0; i<three.size(); i++) {
									if(three.get(i).getMileage()>=0) {
										sum3 = sum3 + three.get(i).getMileage();
									}
									else continue;
								}
								for(int i=0; i<four.size(); i++) {
									if(four.get(i).getMileage()>=0) {
										sum4 = sum4 + four.get(i).getMileage();
									}
									else continue;
								}
								for(int i=0; i<unknown.size(); i++) {
									if(unknown.get(i).getMileage()>=0) {
										sumUnknown = sumUnknown + unknown.get(i).getMileage();
									}
									else continue;
								}
								
								this.writeReport(total, sum1, sum2, sum3, sum4, sumUnknown);
							}
						}
					}
					else {
						continue;
					}
					sc.close();
				}
				else {
					continue;
				}
			}
			scan.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//WriteResultFile
	public void writeResult() {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(resultsFile));
			out.println(membersDB.toString());
			out.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//WriteReportFile
	private void writeReport(MembersDB queryTier, String s) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(reportFile, true));
			out.println("----query tier "+s+"----");
			out.println(queryTier.toString());
			out.println("------------------------\n");
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void writeReport(int total, double one, double two, double three, double four, double five) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(reportFile, true));
			out.println("----query age mileage----");
			out.printf("Total Airline Members: %d\n",total);
			out.println("Age based mileage distribution");
			out.printf("(0, 8]: %.0f\n"
					+ "(8, 18]: %.0f\n"
					+ "(18, 65]: %.0f\n"
					+ "(65, -): %.0f\n"
					+ "Unknown: %.0f\n", one,two,three,four,five);
			out.println("------------------------\n");
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
