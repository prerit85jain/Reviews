package vehicleRentalApplication;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Vehicle> rentedVehicles = new ArrayList<>();

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void rentVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
    }

    public double returnAll(int days) {
        double total = 0;
        for (Vehicle v : rentedVehicles) {
            total += v.calculateRent(days);
        }
        rentedVehicles.clear();
        return total;
    }

    public String getName() {
        return name;
    }
}