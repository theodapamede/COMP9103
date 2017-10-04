package amr17s2;

public class AMR17S2 {
	public static void main(String[]args) {
		if(args.length == 4) {
			Control run = new Control(args);
			run.readMembers();
			run.readInstruction();
			run.writeResult();
		}
	}
}
