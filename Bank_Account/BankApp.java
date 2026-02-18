package Bank_Account;

import java.util.*;

public class BankApp {
    public static void main(String[] args) {
        ArrayList<BankAccount> bank = new ArrayList<>();
        Scanner sr = new Scanner(System.in);
        BankAccount account = null;
        System.out.println("Welcome to our bank!!!");
        System.out.println("Type of Account");
        System.out.println("1.Saving Account : ");
        System.out.println("2.Current Account : ");
        int choice = sr.nextInt();
        sr.nextLine();
        System.out.println("Enter Your Account Number : ");
        int accountNo = sr.nextInt();
        sr.nextLine();
        System.out.println("Enter Account Holder Name : ");
        String name = sr.nextLine();
        System.out.println("Enter the Balance : ");
        double balance = sr.nextDouble();
        sr.nextLine();
        if (choice == 1) {
            account = new SavingsAccount(accountNo, name, balance);
        } else if (choice == 2) {
            account = new CurrentAccount(accountNo, name, balance);
        } else {
            System.out.println("Invalid account type.");
            return;
        }
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Account Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = sr.nextInt();

            if (option == 1) {
                System.out.print("Enter deposit amount: ");
                double amt = sr.nextDouble();
                account.deposit(amt);
            } else if (option == 2) {
                System.out.print("Enter withdrawal amount: ");
                double amt = sr.nextDouble();
                account.withdraw(amt);
            } else if (option == 3) {
                account.displayAccountDetails();
            } else if (option == 4) {
                System.out.println("Thank you for banking with us!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        sr.close();
    }

}
