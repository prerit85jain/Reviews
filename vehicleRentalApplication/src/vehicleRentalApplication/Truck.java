package vehicleRentalApplication;

public class Truck extends Vehicle {
    private double payloadWeight;  // in kilograms

    public Truck(String id, String model, double payloadWeight) {
        super(id, model, 250);
        this.payloadWeight = payloadWeight;
    }

    @Override
    public double calculateRent(int days) {
        double surcharge = 0.2 * payloadWeight;
        return (baseRate * days) + (surcharge * days);
    }
}