package nonPrimitiveTypecasting;
import java.util.*;

public class CarDriver {
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println("Enter which engine to fit? ");
		System.out.println("1. Petrol Engine");
		System.out.println("2. Diesel Engine");
		System.out.print("Enter your choice: ");
		byte userChoice = userInput.nextByte();
		userInput.nextLine();
		Engine engine = null;
		switch (userChoice) {
		case 1:
			PetrolEngine petrolEngine = new PetrolEngine();
			engine = petrolEngine;
			break;
		case 2:
			engine = new DieselEngine();
			break;
		default:
			PetrolEngine petrolEngine2 = new PetrolEngine();
			engine = petrolEngine2;
			break;
		}
		car.engine = engine;
		
		System.out.println("Engine in car: "+car.engine.getClass());
//		engine.startEngine();
		
		switch (userChoice) {
		case 1:
//			engine.startEngine();    //Parent engine cannot access child member startEngine()
			PetrolEngine petrolEngine = (PetrolEngine)engine;
			petrolEngine.startEngine();
			break;
		case 2:
			DieselEngine dieselEngine = (DieselEngine) engine;
			dieselEngine.startEngine();
			break;
		default:
			PetrolEngine petrolEngine2 = (PetrolEngine)engine;
			petrolEngine2.startEngine();
			break;
		}
	}
}
