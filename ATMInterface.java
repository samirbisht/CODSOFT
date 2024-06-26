import java.util.Scanner;

class ATM {
    private double balance;
    private final double WITHDRAWAL_LIMIT = 1000.00;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You have successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
        checkBalance();
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance && amount <= WITHDRAWAL_LIMIT) {
            balance -= amount;
            System.out.println("You have successfully withdrawn $" + amount);
        } else if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal limit is $" + WITHDRAWAL_LIMIT + ". Please enter a smaller amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Please enter a smaller amount.");
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
        checkBalance();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(5000.00);  // Initial balance

        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
