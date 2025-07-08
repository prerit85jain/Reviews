package vehicleRentalApplication;

public abstract class Vehicle implements Rentable {
    protected String id;
    protected String model;
    protected double baseRate;

    public Vehicle(String id, String model, double baseRate) {
        this.id = id;
        this.model = model;
        this.baseRate = baseRate;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRate() {
        return baseRate;
    }

    @Override
    public abstract double calculateRent(int days);
}