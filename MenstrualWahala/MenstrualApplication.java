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
  