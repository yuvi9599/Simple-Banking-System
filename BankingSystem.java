package SimpleBankingSystems;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Simple Banking System =====");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Display account details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    displayAccountDetails(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.next();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    private static void depositMoney(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }

    private static void checkBalance(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account != null) {
            System.out.println("Current Balance: $" + account.getBalance());
        }
    }

    private static void displayAccountDetails(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account != null) {
            account.displayAccountDetails();
        }
    }

    private static Account findAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        for (Account account : accounts) {
            if (accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
}

