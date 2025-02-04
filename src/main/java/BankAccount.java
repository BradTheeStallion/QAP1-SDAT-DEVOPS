public class BankAccount {
    private static int lastAccountNumber = 1000;
    private final String accountId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private double balance;

    private static String generateAccountId() {
        lastAccountNumber++;
        return String.format("ACC%d", lastAccountNumber);
    }

    public BankAccount(String customerName, String email, String phoneNumber, double balance) {
        this.accountId = generateAccountId();;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        this.balance += amount;
        System.out.printf("Deposit of $%.2f successful. New balance: $%.2f%n", amount, this.balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }
        if (amount > this.balance) {
            System.out.printf("Insufficient funds. Current balance: $%.2f%n", this.balance);
            return false;
        }
        this.balance -= amount;
        System.out.printf("Withdrawal of $%.2f successful. Remaining balance: $%.2f%n", amount, this.balance);
        return true;
    }

    public boolean transferTo(BankAccount recipient, double amount) {
        if (recipient == null) {
            System.out.println("Invalid recipient account");
            return false;
        }
        if (withdraw(amount)) {
            recipient.deposit(amount);
            return true;
        }
        return false;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Account[id=%s, name=%s, email=%s, phone=%s, balance=$%.2f]",
                accountId, customerName, email, phoneNumber, balance);
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", " [email protected]", "1234567890", 1000);
        BankAccount account2 = new BankAccount("Bob", " [email protected]", "0987654321", 500);
        System.out.println(account1);
        System.out.println(account2);
        account1.deposit(500);
        account2.withdraw(200);
        account1.transferTo(account2, 300);
        System.out.println(account1);
        System.out.println(account2);
    }
}