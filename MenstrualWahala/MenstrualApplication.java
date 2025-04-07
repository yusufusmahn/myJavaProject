package MenstrualWahalaClassAndApp;


import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class MenstrualApplication {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        LocalDate todaysDate = LocalDate.now();

        LocalDate lastPeriod = null;
        while (lastPeriod == null) {
            System.out.println("Enter First day of last period date: (YYYY-MM-DD)");
            String lastPeriodDate = userInput.nextLine();
            try {
                lastPeriod = LocalDate.parse(lastPeriodDate);
                if (lastPeriod.isAfter(todaysDate)) {
                    System.out.println("Menstrual cycle period cannot be after Today's Date");
                    lastPeriod = null;
                }
            }catch (Exception e) {

              System.out.println("Invalid Date Format(use this format to continue:(YYYY-MM-DD)");
            }
        }

        int menstrualCycleLength = 0;
        while (menstrualCycleLength <= 0) {
            System.out.println("Enter menstrual cycle length(eg 28 days): ");
            try {
                menstrualCycleLength = userInput.nextInt();
                if (menstrualCycleLength <= 0) {
                    System.out.println("Menstrual cycle length must be a positive integer");
                }
            }catch (Exception e) {
                System.out.println("Invalid menstrual cycle length provided(correct number:eg 28 days): ");
                userInput.nextLine();
            }

        }


 int menstrualPeriodLength = 0;
        while (menstrualPeriodLength <= 0) {
            System.out.println("Enter menstrual period(eg 5 days): ");
            try {
                menstrualPeriodLength = userInput.nextInt();
                if (menstrualPeriodLength <= 0) {
                    System.out.println("Menstrual period length must be a positive integer");
                }
            }catch (Exception e) {
                System.out.println("Enter a valid number: ");
                userInput.nextLine();
            }
        }


        MenstrualWahala menstrualWahala = new MenstrualWahala(lastPeriod,menstrualCycleLength,menstrualPeriodLength);


       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd"));

        System.out.println("============================================================================");
        System.out.println("\nMENSTRUAL CYCLE APP Result");
        System.out.println("============================================================================");
        System.out.println("Next Period: " +menstrualWahala.getNextPeriodStart().format(formatter) + " to " +menstrualWahala.getNextPeriodEnd().format(formatter));
        System.out.println("Ovulation Date: "+menstrualWahala.getOvulationPeriod().format(formatter));
        System.out.println("Fertile Range: "+menstrualWahala.getFertilePeriodStart().format(formatter) + " to " +menstrualWahala.getFertilePeriodEnd().format(formatter));
        System.out.println("Safe Period1: "+menstrualWahala.getSafePeriod1Start().format(formatter) + " to " +menstrualWahala.getSafePeriod1End().format(formatter));
        System.out.println("Safe Period2: "+menstrualWahala.getSafePeriod2Start().format(formatter) + " to " +menstrualWahala.getSafePeriod2End().format(formatter));



    }
}


  