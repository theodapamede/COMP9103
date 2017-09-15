public class Stuff {
	public static void main(String[]args) {
		String s = "Theo dapamede";
		String[] name = s.split(" ");
		int a = 0;
		for(int i=0; i<name.length; i++) { //Per word check
			for(int j=0; j<name[i].length();j++) { //Per letter in word check
				if(!Character.isAlphabetic(name[i].charAt(j))||!Character.isUpperCase(name[i].charAt(0))) {
					a=1;
					break;
				}
				else {
					a=2;
				}
			}
		}

		if(a==2){
			System.out.println("True");;
		}
		else{
			System.out.println("False");;
		}
	}
}

