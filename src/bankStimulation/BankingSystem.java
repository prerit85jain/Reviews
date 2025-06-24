package bankStimulation;
import java.util.Scanner;

public class BankingSystem {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double balance = 0;
        int choice;

        do{
            System.out.println("Deposit Money");
            System.out.println("Withdraw Money");
            System.out.println("Check Balance");
            System.out.println("Exit");
             choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                balance += amount;
                System.out.println("Deposited ₹" + amount);
        }
        else if (choice == 2){
            System.out.print("Enter amount to withdraw:");
            double amount = scanner.nextDouble();
            if(amount <= balance){
                balance -= amount;
                System.out.println("Withdrawn"+ amount);
            } 
            else{
                System.out.println("Not sufficient balance");
            }
        }

            else if (choice == 3){
                System.out.println("Your current balance" + balance);
            }
            else if (choice != 4) {
                System.out.println("Invalid choice");
            }
        } 
        while (choice != 4);
            
            System.out.println("Banking App");
        }
        
    }


