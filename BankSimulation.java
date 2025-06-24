import java.util.Scanner;

public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance=0;
        while(true){
            System.out.println("Available Balance : "+balance);
            System.out.println("Press 1 for Deposit");
            System.out.println("Press 2 for Withdrawal");
            System.out.println("Press 0 for Exit");
            int input=sc.nextInt();
            if(input==1){
                System.out.println("Enter Amount");
                int amount=sc.nextInt();
                balance+=amount;
            }
            else if(input==2){
                System.out.println("Enter Amount");
                int amount=sc.nextInt();
                if(amount>balance){
                    System.out.println("Insufficient Balance");
                }
                else {
                    balance-=amount;
                }
            } else if (input==0) {
                System.out.println("Bye!");
                break;
            }
            else {
                System.out.println("Enter a valid input");
            }
        }
    }
}
