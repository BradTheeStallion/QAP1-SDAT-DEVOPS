import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("brad", "email", "1234567890", 0);
        account.deposit(100);
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("brad", "email", "1234567890", 100);
        assertTrue(account.withdraw(50));  // Check if withdrawal was successful
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("brad", "email", "1234567890", 50);
        assertFalse(account.withdraw(100));  // Withdrawal should fail
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testTransferTo() {
        BankAccount account1 = new BankAccount("brad", "email", "1234567890", 100);
        BankAccount account2 = new BankAccount("john", "email", "1234567890", 0);

        assertTrue(account1.transferTo(account2, 50));  // Transfer should succeed
        assertEquals(50.0, account1.getBalance(), 0.01);
        assertEquals(50.0, account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferToInsufficientFunds() {
        BankAccount account1 = new BankAccount("brad", "email", "1234567890", 0);
        BankAccount account2 = new BankAccount("john", "email", "1234567890", 0);

        assertFalse(account1.transferTo(account2, 50));  // Transfer should fail
        assertEquals(0.0, account1.getBalance(), 0.01);
        assertEquals(0.0, account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferToInvalidRecipient() {
        BankAccount account1 = new BankAccount("brad", "email", "1234567890", 100);
        BankAccount account2 = null;

        assertFalse(account1.transferTo(account2, 50));  // Transfer should fail
        assertEquals(100.0, account1.getBalance(), 0.01);
    }
}