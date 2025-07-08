package vehicleRentalApplication;

public class Bike extends Vehicle {
    public Bike(String id, String model) {
        super(id, model, 50);
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days;
    }
}