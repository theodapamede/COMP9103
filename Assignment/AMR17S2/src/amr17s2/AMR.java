package AMR17S2;

public class AMR {
	public static void main(String[]args) {
		if(args.length == 4) {
			Control run = new Control(args);
			run.readMembers();
			run.readInstruction();
			run.writeResult();
		}
	}
}
