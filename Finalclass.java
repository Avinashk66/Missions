// Final class - cannot be extended
final class Bank {
    private String bankName;

    Bank(String name) {
        this.bankName = name;
    }

    public void displayBank() {
        System.out.println("Bank Name: " + bankName);
    }

    // A final method - cannot be overridden
    public final void interestRate() {
        System.out.println("General Interest Rate: 5%");
    }
}

// A normal class (not final)
class Customer {
    private String name;
    private int accountNumber;
    private Bank bank;

    Customer(String name, int accountNumber, Bank bank) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.bank = bank;
    }

    public void displayCustomer() {
        System.out.println("Customer Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        bank.displayBank();
        bank.interestRate();
    }
}

public class FinalClassExample2 {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank");
        Customer c1 = new Customer("Avinash", 12345, bank);
        Customer c2 = new Customer("Kumar", 67890, bank);

        c1.displayCustomer();
        System.out.println();
        c2.displayCustomer();
    }
}
