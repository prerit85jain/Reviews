package vehicleRentalApplication;

public class Car extends Vehicle {
    private double insurancePerDay = 50;

    public Car(String id, String model) {
        super(id, model, 200);
    }

    @Override
    public double calculateRent(int days) {
        return (baseRate + insurancePerDay) * days;
    }
}