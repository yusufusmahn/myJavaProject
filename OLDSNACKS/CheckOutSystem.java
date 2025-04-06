package OLDSNACKS;


import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutSystem{
    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);

        double vatRate = 0.075;
        String productName;
        int quantity;
        int price;
        int quantityTotal;
        int total = 0;

        ArrayList<String> myProductName = new ArrayList <>();
        ArrayList<Integer> myQuantity = new ArrayList <>();
        ArrayList<Integer> myPrice = new ArrayList <>();

        System.out.println("Enter Customers Name: ");
        String name = keyboard.nextLine();

        while(true){

            System.out.println("What did the user buy: ");
            productName = keyboard.nextLine();
            myProductName.add(productName);


            System.out.println("How many pieces: ");
            quantity = keyboard.nextInt();keyboard.nextLine();
            myQuantity.add(quantity);

            if (quantity <= 0){
                System.out.println("invalid quantity entered, kindly enter a positive number: ");
                quantity = keyboard.nextInt();keyboard.nextLine();

            }

            System.out.println("How much per unit: ");
            price = keyboard.nextInt();keyboard.nextLine();
            myPrice.add(price);


            if (price <= 0){
                System.out.println("invalid price entered, kindly enter a positive number: ");
                price = keyboard.nextInt();keyboard.nextLine();

            }


            System.out.println();
            System.out.println("Do u want to add more items(yes or no): ");
            String addItems = keyboard.nextLine();
            while (!addItems.equalsIgnoreCase("no") && !addItems.equalsIgnoreCase("yes")){
                System.out.println("incorrect input kindly enter (yes or no): ");
                addItems = keyboard.nextLine();

            }


            if (!addItems.equalsIgnoreCase("yes")){

                break;

            }
        }


        System.out.println();

        System.out.println("Cashiers name: ");
        String cashiersName = keyboard.nextLine();

        System.out.println("how much discount did customer get: ");
        double discountGotten = keyboard.nextDouble();
        discountGotten /= 100;

        if (discountGotten < 0){
            System.out.println("invalid discount entered, kindly enter a positive number or zero for no discount: ");
            discountGotten = keyboard.nextDouble();keyboard.nextLine();

        }


        for(int i = 0; i < myProductName.size(); i++){
            quantityTotal = myQuantity.get(i) * myPrice.get(i);
            total += quantityTotal;
        }


        double discount = total * discountGotten;
        double discountTotal = total - discount;
        double vat = discountTotal * vatRate;
        double totality = discountTotal + vat;

        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("TEL: 08169025215");
        System.out.println("LOCATION: 312, herbert macaulay way, sabo yaba, lagos");
        System.out.println("Date: 04-JAN-2025    09:28:23 pm");
        System.out.println("Cashier : "+cashiersName);
        System.out.println("Customer Name: "+name);
        System.out.println("==========================================================");
        System.out.printf("%-10s%-10s%-10s%-10s%n","ITEM","QTY","PRICE","Total(NG)");
        System.out.println("----------------------------------------------------------");

        for(int i = 0; i < myProductName.size(); i++){
            quantityTotal = myQuantity.get(i) * myPrice.get(i);
            System.out.printf("%-10s%-10d%-10d%-10d%n",myProductName.get(i),myQuantity.get(i),myPrice.get(i),quantityTotal);
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("Sub total: %-10d%n ",total);
        System.out.printf("Discount: %-10.2f%n ",discount);
        System.out.printf("VAT : %-10.2f%n ",vat);
        System.out.println("==========================================================");
        System.out.printf("Bill total: %-10.2f%n ",totality);
        System.out.println("==========================================================");
        System.out.printf("This is not a reciept kindly pay: %-10.2f%n ",totality);
        System.out.println("==========================================================");
        System.out.println();

        System.out.println("How much did the customer give to you: ");
        int amount = keyboard.nextInt();

        while(amount <= totality){
            System.out.println("Amount cannot be zero and amount cannot be less than total bill for items purchased, kindly enter a valid amount: ");
            amount = keyboard.nextInt();

        }


        double balance = amount - totality;


        System.out.println();
        System.out.println("SEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("TEL: 08169025215");
        System.out.println("LOCATION: 312, herbert macaulay way, sabo yaba, lagos");
        System.out.println("Date: 04-JAN-2025    09:28:23 pm");
        System.out.println("Cashier : "+cashiersName);
        System.out.println("Customer Name: "+name);
        System.out.println("==========================================================");
        System.out.printf("%-10s%-10s%-10s%-10s%n","ITEM","QTY","PRICE","Total(NG)");
        System.out.println("----------------------------------------------------------");

        for(int i = 0; i < myProductName.size(); i++){
            quantityTotal = myQuantity.get(i) * myPrice.get(i);
            System.out.printf("%-10s%-10d%-10d%-10d%n",myProductName.get(i),myQuantity.get(i),myPrice.get(i),quantityTotal);
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("Sub total: %-10d%n ",total);
        System.out.printf("Discount: %-10.2f%n ",discount);
        System.out.printf("VAT: %-10.2f%n ",vat);
        System.out.println("==========================================================");
        System.out.printf("Bill total: %-10.2f%n ",totality);
        System.out.printf("Amount Paid: %-10d%n ",amount);
        System.out.printf("balance: %-10.2f%n ",balance);
        System.out.println("==========================================================");
        System.out.println("THANK YOU FOR YOUR PATRONAGE");
        System.out.println("==========================================================");




    }



}