
class BankAccount {

    final int accountNumber;
    String accountHolder;
    double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    final void displayAccount() {
        System.out.println("Bank Account Details");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountDemo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1001, "Chioma", 50000);

        account.displayAccount();

    }
}