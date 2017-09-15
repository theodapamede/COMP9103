
import java.util.Scanner;
public class W5_homework_1a {
	public static void main(String[]args){
		String paragraph = "This is the new paragraph. The fox is just so lazy. Welcome to the new version of java. We hope you enjoy your stay here.";
		String words[] = paragraph.split(" ");
		Scanner scan = new Scanner(System.in);
		System.out.println("Given word: ");
		String word = scan.next();
		int count=0;
		for(int i=0; i<words.length; i++){
			if(words[i].equalsIgnoreCase(word)){
				count++;
			}
		}
		System.out.println("Word count for '"+word+"' is "+count+".");
		scan.close();
	}
}
