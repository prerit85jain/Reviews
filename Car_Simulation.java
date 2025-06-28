package Reviews;
import java.util.Scanner;
import java.util.Arrays;

public class Car_Simulation {

    private static final int PARKING_CAPACITY = 10;
    private static final String[] parkingSpots = new String[PARKING_CAPACITY];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Parking Simulation Menu ---");
            System.out.println("1. Park a car");
            System.out.println("2. Unpark a car");
            System.out.println("3. Show parking status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number. Please enter a number from 1 to 4.");
                System.out.print("Enter your choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    parkCar(scanner);
                    break;
                case 2:
                    unparkCar(scanner);
                    break;
                case 3:
                    showParkingStatus();
                    break;
                case 4:
                    System.out.println("Exiting simulation.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void parkCar(Scanner scanner) {
        System.out.print("Enter car license plate: ");
        String licensePlate = scanner.nextLine();

        int emptySpotIndex = -1;
        for (int i = 0; i < parkingSpots.length; i++) {
            if (parkingSpots[i] == null) {
                emptySpotIndex = i;
                break;
            }
        }

        if (emptySpotIndex != -1) {
            parkingSpots[emptySpotIndex] = licensePlate;
            System.out.println("Car " + licensePlate + " parked successfully at spot " + (emptySpotIndex + 1));
        } else {
            System.out.println("Sorry, the parking lot is full.");
        }
    }

    public static void unparkCar(Scanner scanner) {
        System.out.print("Enter spot number to unpark: ");
        
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid spot number. Please enter a number.");
            System.out.print("Enter spot number to unpark: ");
            scanner.next();
        }
        int spotNumber = scanner.nextInt();
        scanner.nextLine();

        if (spotNumber < 1 || spotNumber > PARKING_CAPACITY) {
            System.out.println("Invalid spot number. Please choose a spot from 1 to " + PARKING_CAPACITY + ".");
            return;
        }

        int index = spotNumber - 1;
        if (parkingSpots[index] != null) {
            String licensePlate = parkingSpots[index];
            parkingSpots[index] = null;
            System.out.println("Car " + licensePlate + " unparked from spot " + spotNumber);
        } else {
            System.out.println("Spot " + spotNumber + " is already empty.");
        }
    }

    public static void showParkingStatus() {
        System.out.println("\n--- Current Parking Status ---");
        boolean allSpotsEmpty = true;
        for (int i = 0; i < parkingSpots.length; i++) {
            if (parkingSpots[i] != null) {
                System.out.println("Spot " + (i + 1) + ": " + parkingSpots[i]);
                allSpotsEmpty = false;
            } else {
                System.out.println("Spot " + (i + 1) + ": [Empty]");
            }
        }

        if(allSpotsEmpty) {
            System.out.println("The parking lot is completely empty.");
        }

        System.out.println("\n--- Capacity ---");
        long occupiedSpots = Arrays.stream(parkingSpots).filter(s -> s != null).count();
        System.out.println("Total spots: " + PARKING_CAPACITY);
        System.out.println("Occupied spots: " + occupiedSpots);
        System.out.println("Free spots: " + (PARKING_CAPACITY - occupiedSpots));
    }
}
