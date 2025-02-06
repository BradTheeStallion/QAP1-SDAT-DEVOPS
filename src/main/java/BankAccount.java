import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount {
    private static int lastAccountNumber = 1000;
    private final String accountId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private BigDecimal balance;

    private static synchronized String generateAccountId() {
        lastAccountNumber++;
        return String.format("ACC%d", lastAccountNumber);
    }

    public BankAccount(String customerName, String email, String phoneNumber, double balance) {
        this.accountId = generateAccountId();
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = BigDecimal.valueOf(balance).setScale(2, RoundingMode.HALF_UP);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        BigDecimal depositAmount = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP);
        this.balance = this.balance.add(depositAmount);
        System.out.printf("Deposit of $%.2f successful. New balance: $%.2f%n", amount, this.balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }
        BigDecimal withdrawalAmount = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP);
        if (withdrawalAmount.compareTo(this.balance) > 0) {
            System.out.printf("Insufficient funds. Current balance: $%.2f%n", this.balance);
            return false;
        }
        this.balance = this.balance.subtract(withdrawalAmount);
        System.out.printf("Withdrawal of $%.2f successful. Remaining balance: $%.2f%n", amount, this.balance);
        return true;
    }

    public boolean transferTo(BankAccount recipient, double amount) {
        if (recipient == null) {
            System.out.println("Invalid recipient account");
            return false;
        }
        if (this == recipient) {
            System.out.println("Cannot transfer to the same account");
            return false;
        }
        if (withdraw(amount)) {
            recipient.deposit(amount);
            System.out.printf("Transfer of $%.2f to %s successful.%n", amount, recipient.getAccountId());
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
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance.doubleValue();
    }

    public void setBalance(double balance) {
        this.balance = BigDecimal.valueOf(balance).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format(
                "Account Details:\n" +
                        "ID: %s\n" +
                        "Name: %s\n" +
                        "Email: %s\n" +
                        "Phone: %s\n" +
                        "Balance: $%.2f",
                accountId, customerName, email, phoneNumber, balance
        );
    }
}