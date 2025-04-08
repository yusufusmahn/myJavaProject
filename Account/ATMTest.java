package ATMMachineTest;

import Account.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {
    @Test
    public void ATMTestThatGetAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");

        assertEquals("ACCOUNT1000000000", account1.getAccountNumber());

    }

    @Test
    public void ATMTestThatGetFullNameMethodAfterAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        assertEquals("yusuf usman", account1.getFullName());

    }

    @Test
    public void ATMTestThatGetBalanceMethodAfterAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        assertEquals(0.0, account1.getBalance(), 0.0);
    }

    @Test
    public void ATMTestThatGetPinMethodAfterAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        assertTrue(account1.checkPin("1357"));
    }

    @Test
    public void ATMTestThatDepositMethodAfterAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        account1.deposit(100.0);
        assertEquals(100.0, account1.getBalance(), 0.000);
    }

    @Test
    public void ATMTestThatWithdrawMethodAfterAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        account1.deposit(100.0);
        assertEquals(100.0, account1.getBalance(), 0.000);
        account1.withdraw(50.0);
        assertEquals(50.0, account1.getBalance(), 0.000);
    }

    @Test
    public void ATMTestThatTransferMethodAfterAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        Account account2 = new Account("ACCOUNT1000000001","luka", "dom", "2581");
        account1.deposit(100.0);
        assertEquals(true, account1.transfer(account2, 100.0));
        assertEquals(0.0, account1.getBalance(), 0.000);
        assertEquals(100.0, account2.getBalance(), 0.000);

    }

    @Test
    public void ATMTestThatChangePinMethodAfterAccountCreationWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        account1.changePin("1234");
        assertEquals(true, account1.checkPin("1234"));
    }

    @Test
    public void ATMTestThatTransferMethodWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        Account account2 = new Account("ACCOUNT1000000001","luka", "dom", "2581");
        assertEquals(false, account1.transfer(account2, 100.0));
        assertEquals(0.0, account1.getBalance(), 0.000);
        assertEquals(0.0, account2.getBalance(), 0.000);

    }

    @Test
    public void ATMTestThatWithdrawMethodWorks() {
        Account account1 = new Account("ACCOUNT1000000000","yusuf", "usman", "1357");
        account1.deposit(100.0);
        account1.withdraw(150.0);
        assertEquals(100.0, account1.getBalance(), 0.000);
    }


  }
