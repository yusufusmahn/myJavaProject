package ATMMachineTest;
import Account.Account;
import Account.BankOperations;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankOperationsTest {
    @Test
    public void ATMTestThatSizeMethodWorks() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        assertEquals(1, bank.accountSize());

    }

    @Test
    public void ATMTestAccountCreationWorksAndDetailsMatches() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.findAccount("yusuf30807");
        assertEquals("yusuf usman", account.getFullName());
        assertTrue(account.checkPin("1111"));
        assertEquals("yusuf30807", account.getAccountNumber());
        assertEquals(1, bank.accountSize());
    }


    @Test
    public void ATMTestAccountAuthentificationWorks() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30807", "1111");
        assertEquals("yusuf usman", account.getFullName());

    }

    @Test
    public void ATMTestAccountAuthentificationFailWorks() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30807", "9999");
        assertNull(account);
    }

    @Test
    public void ATMTestAccountAuthentificationFailWorksWithoutPin() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30801", "9999");
        assertNull(account);
    }

    @Test
    public void ATMTestAccountAuthentificationPassWorksWithCorrectDetails() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30807", "1111");
        assertNotNull(account);
    }



    @Test
    public void ATMTestToCloseAccount() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30807", "1111");
        bank.closeAccount(account);
        assertEquals(0, bank.accountSize());
        assertNull(bank.findAccount("yusuf30807"));
    }


    @Test
    public void ATMTestDepositIncreasesBalance() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30807", "1111");
        bank.deposit(account, 1000.0);
        assertEquals(1000.0, account.getBalance(),1000.00);
    }


    @Test
    public void ATMTestWithdrawMethodDecreasesBalance() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30807", "1111");
        bank.deposit(account, 1000.0);
        bank.withdraw(account, 100.0);
        assertEquals(900.0, account.getBalance(),900.00);
    }

    @Test
    public void ATMTestCheckBalanceWorks() {
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account = bank.authentication("yusuf30807", "1111");
        bank.deposit(account, 1000.0);
        bank.withdraw(account, 100.0);
        assertEquals(900.0, account.getBalance(),900.00);
    }

    @Test
    public void testThatTransferWorks(){
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        bank.createAccount("bode", "lawal", "2121");
        Account account1 = bank.authentication("yusuf30807", "1111");
        Account account2 = bank.authentication("yusuf30808", "2121");
        bank.deposit(account1, 100.0);
        bank.transfer(account2, "yusuf30808",45.0);
        assertEquals(55.0, account1.getBalance(),55.00);

    }


    @Test
    public void testThatPinResetWorks(){
        BankOperations bank = new BankOperations();
        bank.createAccount("yusuf", "usman", "1111");
        Account account1 = bank.authentication("yusuf30807", "1111");
        bank.resetPin(account1, "1234");
        assertTrue(account1.checkPin("1234"));
    }


}
