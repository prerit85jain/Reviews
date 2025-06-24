package carParkingLot;
import java.util.Scanner;

public class ParkingLot {
	static int capacity = 6;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			displayOptions();
			String option = sc.next();
			
			checkOption(option);
			
			System.out.print("Want to exit(y/n) ");
			String exit = sc.next();
			if(exit.equals("y")) {
				break;
			}
			System.out.println("+-----------------------------------------------------------------------+");
		}
		sc.close();
	}

	private static void displayOptions() {
		System.out.println("Select one option from:");
		System.out.println("1. Want to park the car");
		System.out.println("2. Want to unpark the car");
		System.out.println("3. Want to check remaining capacity");
		System.out.print("Enter option: ");
	}
	private static void checkOption(String option) {
		switch(option) {
			case "1":
				if(capacity<=0) {
					System.out.println("Sorry capacity is full!");
				}else {
					System.out.println("Congrats! Car parked succesfully");
					capacity--;
				}
				break;
			case "2":
				if(capacity>=6) {
					System.out.println("Parking is empty!");
				}else {
					System.out.println("Congrats! Car unparked succesfully");
					capacity++;
				}
				break;
			case "3":
				if(capacity==6) {
					System.out.println("Parking lot is empty");
				}else {
					System.out.println("Remaining capacity is "+capacity);
				}
				break;
			case "4":
			default:
				System.out.println("Wrong Input!");
		}
	}
}
