package vehicleRentalApplication;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public Inventory() {
        vehicles.put("B001", new Bike("B001", "MountainBike"));
        vehicles.put("B002", new Bike("B002", "CityCruiser"));
        vehicles.put("C001", new Car("C001", "SedanLX"));
        vehicles.put("C002", new Car("C002", "HatchbackS"));
        vehicles.put("T001", new Truck("T001", "HaulerPro", 500));
        vehicles.put("T002", new Truck("T002", "CargoMax", 750));
    }

    public void displayAvailable() {
        System.out.println("Available Vehicles:");
        System.out.printf("%-5s %-6s %-15s%n", "ID", "Type", "Model");
        for (Vehicle v : vehicles.values()) {
            String type = v.getClass().getSimpleName();
            System.out.printf("%-5s %-6s %-15s%n",
                              v.getId(), type, v.getModel());
        }
    }

    public Vehicle rentById(String id) {
        return vehicles.remove(id);
    }

    public boolean isEmpty() {
        return vehicles.isEmpty();
    }
}