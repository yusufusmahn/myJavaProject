package Account;

import java.util.ArrayList;

public class BankOperations {
    private int accountGeneratorCounter = 30807;
    private ArrayList<Account> allAccounts = new ArrayList<>();


    public void createAccount(String firstName, String lastName, String pin) {

        String accountNumber = firstName + accountGeneratorCounter;
        Account account = new Account(accountNumber, firstName, lastName, pin);
        allAccounts.add(account);
        System.out.println("Account Created!!! Your Account Number is " + accountNumber);
        accountGeneratorCounter++;

    }

    public Account authentication(String accountNumber, String pin) {

        Account account = findAccount(accountNumber);
        if (account != null && account.checkPin(pin)) {
            return account;
        }
        return null;
    }


}


