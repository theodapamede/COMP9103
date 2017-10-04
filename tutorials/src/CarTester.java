
public class CarTester {
	public static void main(String[]args) {
		Car a = new Car("Alpha", 20, 0, 40, 20);
		Car b = new Car("Bravo", 30, 0, 30, 10);
		Car c = new Car("Charlie", 50, 0, 10, 20);
		
		Race cars = new Race();
		cars.addCar(a);
		cars.addCar(b);
		cars.addCar(c);
		
		cars.startRace(100);
		
		String winner = cars.getWinner();
		System.out.println(winner);
	}
}
