import java.util.Scanner;
import java.util.ArrayList;
public class W5_homework_1b {
	public static void main(String[]args){
		System.out.print("Input valid name: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayList<String> array = new ArrayList<String>();
		int a=0;
		while(input.length()>0){
			for(int i=0; i<input.length(); i++){
				if(!Character.isAlphabetic(input.charAt(i))){
					a = 1;
				}
				else if(Character.isUpperCase(input.charAt(0))){
					String names[] = input.split(" ");
					for(int j=0; j<names.length; j++){
						for(int k=0; k<names[j].length(); k++){
							if(Character.isUpperCase(names[j].charAt(0))){
								a=2;
							}
							else a=1;
						}
					}
				}
				else a=1;
			}
			if(a==2){
				array.add(input);
			}
			else{
				System.out.println(input+" is not a valid name!");
			}
			input = scan.nextLine();
		}
		Object[] array2 = array.toArray();
		for(int i=0; i<array2.length; i++){
			System.out.println(array2[i]);
		}
		scan.close();
	}

}
