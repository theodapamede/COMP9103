package amr17s2;

import java.util.*;
import java.io.*;

public class ControlTester {
	public static void main(String[]args) {
		MembersDB membersDB = new MembersDB();
		File membersFile = new File(args[0]);
		try {
			Scanner scan = new Scanner(membersFile);
			String name=null, tier=null, address=null, birthday=null, number=null;
			double mileage=0, points=0;
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
					mileage=0;
					points=0;
					birthday=null;
				}
				
				sc.close();
			}
			scan.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		File instructionFile = new File(args[1]);
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
							String name=null, tier=null, address=null, birthday=null, number=null;
							double mileage=0, points=0;
							String[] temp = param.split(";");
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
		
		
		
		File resultsFile = new File(args[2]);
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(resultsFile));
			out.println(membersDB.toString());
			out.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
