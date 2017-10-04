import java.util.ArrayList;

public class Race {
	//Fields
	private ArrayList<Car> cars;
	
	//Constructors
	public Race() {
		cars = new ArrayList<Car>();
	}
	
	//Methods
	public void addCar(Car newCar) {
		cars.add(newCar);
	}
	
	public void startRace(double time) {
		for(Car c : cars) {
			c.move(time);
		}
	}
	
	public String getWinner() {
		Car winner = cars.get(0);
		for(int i=0; i<cars.size(); i++) {
			if(cars.get(i).getPosition() > winner.getPosition()) {
				winner = cars.get(i);
			}
		}
		return winner.getName();
	}
}
