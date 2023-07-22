import java.util.Scanner;

public class ATMInterface {
    private static double balance = 50000.0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");
        showMenu();

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney(scanner);
                    break;
                case 3:
                    depositMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for uing the ATM");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
    }

    private static void checkBalance() {
        System.out.println("Your account balance is: $" + balance);
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful... Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful... New balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }
}