package Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prototype {
    private static Scanner userSelect = new Scanner(System.in);
    private static BankOperations bank = new BankOperations();

    public static void main(String[] args) {
        int choice = 0;
        while (true) {
            while (true) {
                getMenu();
                try {
                    String initialInput = userSelect.nextLine().trim();
                    if (initialInput.isEmpty()) {
                        throw new IllegalArgumentException("Incorrect Input");
                    }
                    choice = Integer.parseInt(initialInput);

                    if (choice < 1 || choice > 8) {
                        throw new IllegalArgumentException("Incorrect Choice");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect Input: ");
                    userSelect.nextLine();

                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect Input: ");
                }
            }


            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    closeAccount();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    transfer();
                    break;
                case 7:
                    resetPin();
                    break;
                case 8:
                    System.out.println("THANK YOU FOR BANKING WITH US!!!");
                    return;
                default:
                    System.out.println(" Invalid choice Selected!!!");
                    break;
            }

        }
    }


    private static String getName() {
        while (true) {
            System.out.println("Enter Name: ");
            String name = userSelect.nextLine().trim();
            if(name.matches("^[a-zA-Z]+")) {
                return name;
            } else {
                System.out.println("Invalid Name, only use letters(a-zA-Z))!!!");
            }
        }
    }

    private static String getPin() {
        while (true) {
            System.out.println("Enter 4-Digit Pin: ");
            String pin = userSelect.nextLine().trim();
            if (pin.matches("[0-9]{4}")) {
                return pin;
            } else {
                System.out.println("Pin Not Entered ");
            }
        }
    }


    private static double getAmount() {
        while (true) {
            try {
                System.out.println("Enter Amount: ");
                String amount = userSelect.nextLine().trim();
                Double value = Double.parseDouble(amount);
                if (value > 0 && value <= 2000000) {
                    return value;
                } else {
                    System.out.println(" Invalid Amount!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println(" enter Amount again!!!");
            }

        }
    }

    private static void createAccount() {
        String firstName = getName();
        String lastName = getName();
        String pin = getPin();
        String confirmPin = getPin();

        while (!pin.equals(confirmPin)) {
            System.out.println("Pins dont match Pin: ");
            confirmPin = getPin();
        }
        bank.createAccount(firstName, lastName, pin);
    }


    private static Account authenticate() {
        String accounNumber;
        while (true) {
            System.out.println("Enter Account Number: ");
            accounNumber = userSelect.nextLine().trim();
            if (accounNumber.isEmpty()) {
                System.out.println(" Invalid Account Number!!!");
                continue;
            }
            if (bank.findAccount(accounNumber) != null) break;
            System.out.println("Account Number not found!!!");
        }

        String pin = getPin();
        Account account = bank.authentication(accounNumber, pin);
        while (account == null) {
            System.out.println(" Invalid pin!!!");
            pin = getPin();
            account = bank.authentication(accounNumber, pin);
        }
        return account;
    }


    private static void closeAccount() {
        Account account = authenticate();
        bank.closeAccount(account);
    }


    private static void deposit() {
        Account account = authenticate();
        double amount = getAmount();
        bank.deposit(account, amount);

    }


    private static void withdraw() {
        Account account = authenticate();
        double amount = getAmount();
        while (amount > account.getBalance()) {
            System.out.println("You can't withdraw !!!");
            amount = getAmount();
        }
        bank.withdraw(account, amount);

    }

    private static void checkBalance() {
        Account account = authenticate();
        bank.checkBalance(account);
    }

    private static void transfer() {
        Account account = authenticate();
        String beneficiary;
        while (true) {
            System.out.println("Enter Beneficiary's Account: ");
            beneficiary = userSelect.nextLine().trim();
            if (beneficiary.isEmpty()) {
                System.out.println(" Invalid Beneficiary!!!");
                continue;
            }
            if (bank.findAccount(beneficiary) != null) break;
            System.out.println(" Invalid Beneficiary!!!");
        }

        double amount = getAmount();
        while (amount > account.getBalance()) {
            System.out.println("You can't transfer !!!");
            amount = getAmount();
        }
        bank.transfer(account, beneficiary, amount);

    }

    private static void resetPin() {
        Account account = authenticate();

        System.out.println("==========================================");
        System.out.println("\nPIN Reset For Account " + account.getAccountNumber());
        System.out.println("NOTE: Your new pin must be different from current pin: ");
        System.out.println("==========================================");

        String newPin;
        System.out.println("Enter New Pin: ");
        while (true) {
            newPin = getPin();
            if (account.checkPin(newPin)){
                System.out.println("New pin cannot be same with current pin!!!");
            }else{
                break;
            }
        }

        System.out.println("confirm new pin: ");
        String confirmPin = getPin();
        while (!confirmPin.equals(newPin)) {
            System.out.println("Confirm PIN doesn't match with new pin: ");
            confirmPin = getPin();

        }

        bank.resetPin(account, newPin);
        System.out.println("==========================================");
        System.out.println("\nPIN Reset Succesful for Account " + account.getAccountNumber());
        System.out.println("==========================================");
    }


    private static void getMenu() {

        System.out.println("""
                             \nWelcome to Banke Bank ATM
                 ===========================================
                 1. Create a Bank Account
                 2. Close Account
                 3. Deposit
                 4. Withdraw
                 5. Balance
                 6. Transfer
                 7. Change Pin
                 8. Exit
                 ============================================ 
                 Select an option to continue:
                """);
    }
}


