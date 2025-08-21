import java.util.*;

abstract class Account {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getDetails() {
        return accountNumber + " - " + holderName + " - Balance: " + balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate / 100;
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void addSavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        accounts.put(accountNumber, new SavingsAccount(accountNumber, holderName, balance, interestRate));
    }

    public void addCurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        accounts.put(accountNumber, new CurrentAccount(accountNumber, holderName, balance, overdraftLimit));
    }

    public boolean deposit(String accountNumber, double amount) {
        Account acc = accounts.get(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account acc = accounts.get(accountNumber);
        if (acc != null) {
            return acc.withdraw(amount);
        }
        return false;
    }

    public String getAccountDetails(String accountNumber) {
        Account acc = accounts.get(accountNumber);
        if (acc != null) {
            return acc.getDetails();
        }
        return "Account not found";
    }

    public void applyInterestToSavings() {
        for (Account acc : accounts.values()) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Account Details");
            System.out.println("6. Apply Interest to Savings");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Account Number: ");
                String accNum = scanner.next();
                System.out.print("Holder Name: ");
                String name = scanner.next();
                System.out.print("Initial Balance: ");
                double balance = scanner.nextDouble();
                System.out.print("Interest Rate (%): ");
                double rate = scanner.nextDouble();
                bank.addSavingsAccount(accNum, name, balance, rate);
            } else if (choice == 2) {
                System.out.print("Account Number: ");
                String accNum = scanner.next();
                System.out.print("Holder Name: ");
                String name = scanner.next();
                System.out.print("Initial Balance: ");
                double balance = scanner.nextDouble();
                System.out.print("Overdraft Limit: ");
                double limit = scanner.nextDouble();
                bank.addCurrentAccount(accNum, name, balance, limit);
            } else if (choice == 3) {
                System.out.print("Account Number: ");
                String accNum = scanner.next();
                System.out.print("Deposit Amount: ");
                double amount = scanner.nextDouble();
                bank.deposit(accNum, amount);
            } else if (choice == 4) {
                System.out.print("Account Number: ");
                String accNum = scanner.next();
                System.out.print("Withdraw Amount: ");
                double amount = scanner.nextDouble();
                boolean success = bank.withdraw(accNum, amount);
                if (!success) {
                    System.out.println("Insufficient funds or overdraft limit exceeded.");
                }
            } else if (choice == 5) {
                System.out.print("Account Number: ");
                String accNum = scanner.next();
                System.out.println(bank.getAccountDetails(accNum));
            } else if (choice == 6) {
                bank.applyInterestToSavings();
                System.out.println("Interest applied to all savings accounts.");
            } else if (choice == 7) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
