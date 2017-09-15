import java.util.ArrayList;
import java.util.Scanner;

public class W7_2 {
	//Instances
	private ArrayList<String> input;
	
	//Constructor
	public W7_2() {
		input = new ArrayList<String>();
	}
	
	//Methods
	public void scan() {
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		String word[] = text.split(" ");
		for(int i = 0; i<word.length; i++) {
			input.add(word[i]);
		}
		scan.close();
	}
	
	public int size() {
		return input.size();
	}
	
	public String get(int i) {
		return input.get(i);
	}
	
	public int find(String text) {
		for(int j=0; j<input.size(); j++) {
			if(input.get(j).equals(text)) {
				System.out.println(j);;
			}
		}
		return -1;
	}

	public ArrayList<String> modify(int[] parameter){
		ArrayList<String> modified = new ArrayList<String>();
		for(int i=0; i<parameter.length; i++) {
			int j = parameter[i];
			modified.add(input.get(j));
		}
		return modified;
	}
	
	//MAIN
	public static void main(String[]args) {
		System.out.println("Please input text:");
		W7_2 words = new W7_2();
		words.scan();
		for(int i=0; i<words.size(); i++) {
			System.out.println(words.get(i));
		}
		words.find("Hello");
		
	}
}
