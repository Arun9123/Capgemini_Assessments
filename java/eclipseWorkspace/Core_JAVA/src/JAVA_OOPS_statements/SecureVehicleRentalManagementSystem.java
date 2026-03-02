package JAVA_OOPS_statements;

interface RentalOperations {
	void rentVehicle(int days) throws InvalidRentalException;
	double calculateTotalCost(int days);
}

abstract class VehicleRental implements RentalOperations {
	private String vehicleId;
	private String customerName;
	private double rentalCharge;

	public VehicleRental(String vehicleId, String customerName) {
		this.vehicleId = vehicleId;
		this.customerName = customerName;
		this.rentalCharge = 0.0;
	}

	protected abstract double getDailyRate();
	protected abstract double getSecurityCap();

	public String getCustomerName() {
		return customerName;
	}

	public double getRentalCharge() {
		return rentalCharge;
	}

	@Override
	public void rentVehicle(int days) throws InvalidRentalException {
		if (days <= 0) {
			throw new InvalidRentalException("Invalid Duration: Rental days must be greater than 0.");
		}
		double calculatedCost = calculateTotalCost(days);
		if (calculatedCost > getSecurityCap()) {
			throw new OverchargeException("Security Alert: System calculated cost (" + calculatedCost + ") exceeds allowed limit for " + vehicleId);
		}
		this.rentalCharge = calculatedCost;
		System.out.println("Success: " + vehicleId + " rented to " + customerName + 
				" for " + days + " days. Total: " + this.rentalCharge);
	}

	public void rentVehicle(int days, boolean addInsurance) throws InvalidRentalException {
		System.out.println("[Request]: Adding Insurance Package");
		rentVehicle(days); 
		if (addInsurance && this.rentalCharge > 0) {
			this.rentalCharge += 500; 
			System.out.println("Insurance added. Updated Total: " + this.rentalCharge);
		}
	}
}

class CarRental extends VehicleRental {
	public CarRental(String id, String name) {
		super(id, name);
	}

	@Override
	protected double getDailyRate() {
		return 2000.0; 
	}

	@Override
	protected double getSecurityCap() {
		return 50000.0; 
	}

	@Override
	public double calculateTotalCost(int days) {
		return days * getDailyRate();
	}
}

class BikeRental extends VehicleRental {
	public BikeRental(String id, String name) {
		super(id, name);
	}

	@Override
	protected double getDailyRate() {
		return 500.0; 
	}

	@Override
	protected double getSecurityCap() {
		return 5000.0; 
	}

	@Override
	public double calculateTotalCost(int days) {
		return days * getDailyRate();
	}
}

class InvalidRentalException extends Exception {
	public InvalidRentalException(String message) {
		super(message);
	}
}

class OverchargeException extends RuntimeException {
	public OverchargeException(String message) {
		super(message);
	}
}

public class SecureVehicleRentalManagementSystem {
	public static void main(String[] args) {
		System.out.println("VEHICLE RENTAL SYSTEM");
		VehicleRental car = new CarRental("XUV", "Anirban");
		VehicleRental bike = new BikeRental("KTM", "Subarna");
		System.out.println("Car Rental Operations");
		try {
			car.rentVehicle(5); 
			car.rentVehicle(3, true); 
		} catch (InvalidRentalException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Validation Check");
		try {
			System.out.println("Attempting to rent for negative days...");
			bike.rentVehicle(-25);
		} catch (InvalidRentalException e) {
			System.out.println("VALIDATION ERROR: " + e.getMessage());
		}
		System.out.println("Security Check");
		try {
			System.out.println("Attempting to rent Bike for 15 days (Cost: 7500, Cap: 5000)...");
			bike.rentVehicle(15); 

		} catch (OverchargeException e) {
			System.out.println("SECURITY EXCEPTION: " + e.getMessage());
		} catch (InvalidRentalException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}