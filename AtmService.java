package Atm;
import java.util.Scanner;

public class AtmService {
    private static Scanner in;
    private static float balance = 0; // initial balance to 0 for everyone
    private static int anotherTransaction;

    public static void main(String args[]){
        in = new Scanner(System.in);
        transaction();
    }

    private static void transaction(){
        int choice;

        System.out.println("Select an option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Exit");
        choice = in.nextInt();

        switch(choice){
            case 1:
                float amount;
                System.out.print("Please withdraw amount : ");
                amount = in.nextFloat();
                if(amount > balance || amount < 500){
                    System.out.println("You have insufficient Balance\n\n");
                    anotherTransaction();
                } else {
                    balance = balance - amount;
                    System.out.println("You have withdrawn "+amount);
                    System.out.println("Account Balance : "+balance);
                    anotherTransaction();
                }
                break;

            case 2:  //case 2 depositing
                float deposit;
                System.out.print("Please deposit ammount : ");
                deposit = in.nextFloat();
                balance = deposit + balance;
                System.out.println("Amount deposited : "+deposit);
                System.out.println("Account Balance : "+balance);
                anotherTransaction();
                break;

            case 3:
                System.out.println("Your balance is "+balance+"\n");
                anotherTransaction();
                break;

            case 4:
                System.out.println("Exiting. Thanks for using!");
                break;

            default:
                System.out.println("Invalid option:\n\n");
                anotherTransaction();
                break;
        }
    }

    private static void anotherTransaction(){
        System.out.println("Do you want another transaction?\n\nPress----\n 1. for another transaction\n 2. To exit");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction();
        } else if(anotherTransaction == 2){
            System.out.println("Thanks for choosing.");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
        System.out.println();
    }
}
