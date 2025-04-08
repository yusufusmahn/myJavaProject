package Account;

public class Account {
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String pin;
    private double balance;


    public Account(String accountNumber, String firstName, String lastName, String pin) {


        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.balance = 0.0;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean checkPin(String pinNumber) {
        return this.pin.equals(pinNumber);

    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }


    public boolean transfer(Account beneficiary, double amount) {
        if(amount <= balance) {
            balance -= amount;
            beneficiary.deposit(amount);
            return true;
        }
        return false;
    }


    public void changePin(String newPin) {
        this.pin = newPin;
    }






}
