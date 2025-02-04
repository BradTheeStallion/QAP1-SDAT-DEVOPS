public class BankAccount {
    private String accountId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private double balance;

    public BankAccount(String accountId, String customerName, String email, String phoneNumber, double balance) {
        this.accountId = accountId;
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
}