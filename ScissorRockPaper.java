/*
 * Week 3
 * Title: Exercise 4 - Scissor-Rock-Paper
 * Description: program that simulates the Scissor-Rock-Paper game
 * Author: Theodorus Dapamede (SID.470239731)
 */
public class ScissorRockPaper {
	public static void main(String[]args){
		int computer = (int)(Math.random()*2.9);
		String input = args[0]; // enter value: "scissor", "paper", or "rock"
		int human=999; //initializing with default arbitrary value
		int outcome=999; //initializing with default arbitrary value
		if(input.equalsIgnoreCase("scissor"))
			human = 0; //mapping user input to integer
		else if(input.equalsIgnoreCase("rock"))
			human = 1;
		else if(input.equalsIgnoreCase("paper"))
			human = 2;
		else
			System.out.print("Please enter correct value.");
		
		if(computer==human)
			outcome = 0; //always draw
		else if((computer==0)&&(human!=0)){ //computer = scissor
			if(human==1)
				outcome = 1;
			else if(human==2)
				outcome = 2;
			else
				outcome = 999;
		}
		else if((computer==1)&&(human!=1)){ //computer = rock
			if(human==0)
				outcome = 2;
			else if(human==2)
				outcome = 1;
			else
				outcome = 999;
		}
		else if((computer==2)&&(human!=2)){
			if(human==0)
				outcome = 1;
			else if (human==1)
				outcome = 2;
			else
				outcome = 999;
		}
		else
			System.out.print("Invalid value.");
		
		switch(outcome){ //prints the final outcome
		case 0: System.out.print("DRAW!");break;
		case 1: System.out.print("User WINS! Computer LOSES!");break;
		case 2: System.out.print("Computer WINS! User LOSES!");break;
		default: break;
		}
	}

}
