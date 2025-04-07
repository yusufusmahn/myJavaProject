package OLDSNACKS;


import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner customerInput = new Scanner(System.in);
        String InitialInput = null;
        int[] cardNumber = null;

        while (InitialInput == null) {
            System.out.println("Hello, Kindly Enter Card Details To Verify: ");
            try {
                InitialInput = customerInput.nextLine();
                cardNumber = new int[InitialInput.length()];
                for (int i = 0; i < cardNumber.length; i++) {
                    cardNumber[i] = Integer.parseInt(InitialInput.charAt(i) + "");
                }
                if (InitialInput == null || InitialInput.equals("")) {
                    System.out.println("Please Enter a Valid Card Number");
                    InitialInput = null;
                }
            }catch (Exception e) {
                System.out.println("Invalid Card Number, Pleas Enter Card Number: ");
                customerInput.nextLine();
            }
        }

        int cardNumberLength = InitialInput.length();
        boolean isValidate = isValidateCreditCard(cardNumber);
        String cardType = getCreditCardType(cardNumber);

        System.out.println("**Credit Card Type: " + cardType);
        System.out.print("**Credit Card Number: ");
        for (int i = 0; i < cardNumberLength; i++) {
            System.out.print(cardNumber[i]);
        }
        System.out.println("\n**Credit Card Digit Length: " + cardNumberLength);
        if(isValidate) {
            System.out.println("**Credit Card Validitity Status: " + "Valid");

        }else{
            System.out.println("**Credit Card Validitity Status: " + "Invalid");

        }
    }


    public static String getCreditCardType(int[] cardNumber) {
        int length = cardNumber.length;
        if (length < 13 || length > 16) {
            return "INVALID CARD NUMBER";
        }

        int firstDigit = cardNumber[0];
        int secondDigit = cardNumber[1];


        if (firstDigit == 4 && (cardNumber.length == 13 || cardNumber.length == 16)) {
            return "Visa";
        }
        if (firstDigit == 5 && (cardNumber.length == 13 || cardNumber.length == 16)) {
            return "Mastercard";
        }

        if(firstDigit == 3 && secondDigit == 7 && (cardNumber.length == 13 || cardNumber.length == 16)){
            return "American Express Card";
        }

        if(firstDigit == 6 && (cardNumber.length == 13 || cardNumber.length == 16)){
            return "Discover Card";
        }

        return "INVALID CARD NUMBER";

    }


    public static int sumOfSecondDigitsRightToLeft(int[] number) {
        int sum = 0;
        for (int i = number.length - 2 ; i >= 0 ; i-=2) {
            int doubleIt = number[i] * 2;

            if(doubleIt > 9){
                doubleIt = (doubleIt / 10) + (doubleIt % 10);
            }
            sum += doubleIt;
        }
        return sum;
    }



    public static int sumOfOddIndexes(int[] number) {
        int sum = 0;
        for (int i = number.length - 1 ; i >= 0 ; i-=2) {
            sum += number[i];
        }
        return sum;
    }


    public static boolean isValidateCreditCard(int[] number) {
        int totalSum = sumOfOddIndexes(number) + sumOfSecondDigitsRightToLeft(number);
        boolean result = totalSum % 10 == 0;

        return result;

    }



}

