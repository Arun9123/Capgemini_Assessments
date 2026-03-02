package has_a.bi;

public class DriverClass {

	public static void main(String[] args) {
		Car car= new Car();  //car created
		Engine engine= new Engine();  //engine created
		car.engine=engine;  //engine assigned to car
		System.out.println("car.col: "+car.col);
		System.out.println("car.engine: "+car.engine);
		System.out.println("car.engine.noOfCyl: "+ car.engine.noOfCyl);
		engine.car=car;  //car assigned to engine
		Engine yeCarMeJoEngineHai = car.engine;
		Car car2 = yeCarMeJoEngineHai.car;
		System.out.println("Car of engine of car: "+car2);
		System.out.println("Colour of car of engine of car: "+car2.col);
	}
}
