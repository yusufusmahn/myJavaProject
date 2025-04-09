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


    public void closeAccount(Account account) {
        if (account != null) {
            allAccounts.remove(account);
            accountGeneratorCounter--;
            System.out.println("Account Closed!!! for Account Number " + account.getAccountNumber());
        }
    }

    public void deposit(Account account, double amount) {
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited " + amount + " Successfully, New Balance: $" + account.getBalance());
        }

    }

    public void withdraw(Account account, double amount) {
        if (account != null) {
            account.withdraw(amount);
            System.out.println(("withdrawn " + amount + " Successfully, New Balance: $" + account.getBalance()));
        }

    }

    public void checkBalance(Account account) {
        if (account != null) {
            System.out.println("Account Balance: $: " + account.getBalance());
        }
    }


    public void transfer(Account account, String destination, double amount) {
        if (account != null) {
            Account beneficiaryAccount = findAccount(destination);
            if(beneficiaryAccount != null) {
                account.transfer(beneficiaryAccount, amount);
                System.out.println("Transfered " + amount + " Successfully, to " + beneficiaryAccount.getAccountNumber() + " New Balance is: $" + account.getBalance());
            }else{
                System.out.println("Insufficien Balance");
            }
        }else{
            System.out.println("Account not found!!!");
        }
    }


    public void resetPin(Account account, String newPin) {
        if (account != null) {
            account.changePin(newPin);
            System.out.println("PIN Changed Succesfully!!!");
        }
    }


    public Account findAccount(String accountNumber) {
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getAccountNumber().equals(accountNumber)) {
                return allAccounts.get(i);
            }
        }
        return null;
    }


    public int accountSize(){
        return allAccounts.size();
    }

}


