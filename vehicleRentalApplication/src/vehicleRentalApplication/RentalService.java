package vehicleRentalApplication;

import java.util.Scanner;

public class RentalService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        System.out.print("Enter Customer ID: ");
        String custId = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String custName = sc.nextLine();
        Customer customer = new Customer(custId, custName);

        while (!inventory.isEmpty()) {
            inventory.displayAvailable();

            System.out.print("Enter Vehicle ID to rent (or 'done' to finish): ");
            String choice = sc.nextLine().trim();
            if (choice.equalsIgnoreCase("done")) {
                break;
            }

            Vehicle v = inventory.rentById(choice);
            if (v != null) {
                customer.rentVehicle(v);
                System.out.println("Added " + v.getModel() + " to your rentals.\n");
            } else {
                System.out.println("Invalid ID or already rented. Try again.\n");
            }
        }

        System.out.print("Enter rental duration (days): ");
        int days = Integer.parseInt(sc.nextLine());

        double total = customer.returnAll(days);
        System.out.printf("%n%s owes: %.2f for %d day(s) of rentals%n",
                          custName, total, days);

        sc.close();
    }
}