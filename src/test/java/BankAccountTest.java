import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("brad", "email", "123456", 0);
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("brad", "email", "123456", 100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testTransferTo() {
        BankAccount account1 = new BankAccount("brad", "email", "123456", 100);
        BankAccount account2 = new BankAccount("john", "email", "123456", 0);
        account1.transferTo(account2, 50);
        assertEquals(50, account1.getBalance());
        assertEquals(50, account2.getBalance());
    }

    @Test
    public void testTransferToInsufficientFunds() {
        BankAccount account1 = new BankAccount("brad", "email", "123456", 0);
        BankAccount account2 = new BankAccount("john", "email", "123456", 0);
        account1.transferTo(account2, 50);
        assertEquals(0, account1.getBalance());
        assertEquals(0, account2.getBalance());
    }

    @Test
    public void testTransferToInvalidRecipient() {
        BankAccount account1 = new BankAccount("brad", "email", "123456", 100);
        BankAccount account2 = null;
        account1.transferTo(account2, 50);
        assertEquals(100, account1.getBalance());
    }
}
