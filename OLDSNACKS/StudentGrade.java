package OLDSNACKS;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int classTotal = 0;
        double classAverage = 0;
        int maxFails = 0;
        int maxPasses = 0;
        int hardestSubjectIndex = 0;
        int easiestSubjectIndex = 0;
        int overallHighestScore = Integer.MIN_VALUE;
        int overallLowestScore = Integer.MAX_VALUE;
        int overallHighestStudent = 0;
        int overallHighestSubject = 0;
        int overallLowestStudent = 0;
        int overallLowestSubject = 0;

        System.out.println("Enter the number of students to grade: ");
        int numberOfStudents = keyboard.nextInt();

        while (numberOfStudents <= 0 || numberOfStudents > 1000) {
            System.out.println("Invalid number entered. Kindly enter a positive number between 1 and 1000: ");
            numberOfStudents = keyboard.nextInt();
        }

        System.out.println("Enter the number of subjects: ");
        int numberOfSubjects = keyboard.nextInt();
        System.out.println("saving>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("saved succesfully");
        System.out.println();


        while (numberOfSubjects < 1 || numberOfSubjects > 20) {
            System.out.println("Invalid number entered. Kindly enter a positive number of subjects between 1 and 20: ");
            numberOfSubjects = keyboard.nextInt();
        }

        int[][] scores = new int[numberOfStudents][numberOfSubjects];
        int[] totalScores = new int[numberOfStudents];
        double[] average = new double[numberOfStudents];
        int[] highestScore = new int[numberOfSubjects];
        int[] lowestScore = new int[numberOfSubjects];
        int[] highestScoring = new int[numberOfSubjects];
        int[] lowestScoring = new int[numberOfSubjects];

        for (int j = 0; j < numberOfSubjects; j++) {
            highestScore[j] = Integer.MIN_VALUE;
            lowestScore[j] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Entering scores for Student " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println("Enter score for Subject " + (j + 1) + ": ");
                scores[i][j] = keyboard.nextInt();
                System.out.println("saving>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("saved succesfully");
                System.out.println();


                while (scores[i][j] < 1 || scores[i][j] > 100) {
                    System.out.println("Invalid score. Please enter a score between 1 and 100: ");
                    scores[i][j] = keyboard.nextInt();
                }

                totalScores[i] += scores[i][j];

                if (scores[i][j] > highestScore[j]) {
                    highestScore[j] = scores[i][j];
                    highestScoring[j] = i;
                }
                if (scores[i][j] < lowestScore[j]) {
                    lowestScore[j] = scores[i][j];
                    lowestScoring[j] = i;
                }

                if (scores[i][j] > overallHighestScore) {
                    overallHighestScore = scores[i][j];
                    overallHighestStudent = i;
                    overallHighestSubject = j;
                }
                if (scores[i][j] < overallLowestScore) {
                    overallLowestScore = scores[i][j];
                    overallLowestStudent = i;
                    overallLowestSubject = j;
                }
            }
            average[i] = (double) totalScores[i] / numberOfSubjects;
            classTotal += totalScores[i];
        }

        classAverage = (double) classTotal / numberOfStudents;

        for(int i = 0; i < numberOfStudents; i++){
            for (int j = i + 1; j < numberOfStudents; j++){
                if (totalScores[i] < totalScores[j]){
                    int storeTotalScores = totalScores[i];
                    totalScores[i] = totalScores[j];
                    totalScores[j] = storeTotalScores;

                    double storeAverage = average[i];
                    average[i] = average[j];
                    average[j] = storeAverage;

                    int[] storeScores = scores[i];
                    scores[i] = scores[j];
                    scores[j] = storeScores;

                }
            }
        }


        System.out.println("==================================================================");
        System.out.printf("%-10s", "STUDENT");
        for (int j = 1; j <= numberOfSubjects; j++) {
            System.out.printf("%-10s", "SUB" + j);
        }

        System.out.printf("%-10s%-10s%-10s%n", "TOTAL", "AVERAGE", "POSITION");
        System.out.println("==================================================================");
        for (int i = 0; i < numberOfStudents; i++) {
            int position = i + 1;
            System.out.printf("%-10s", "Student " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.printf("%-10d", scores[i][j]);
            }
            System.out.printf("%-10d%-10.2f%-10d%n", totalScores[i], average[i], position);
        }
        System.out.println("===================================================================");
        System.out.println();
        System.out.println("====================================================================");

        System.out.println("\nSUBJECT SUMMARY");
        for (int j = 0; j < numberOfSubjects; j++) {
            int subjectPass = 0;
            int subjectFail = 0;
            int subjectTotalScore = 0;

            System.out.println("\nSUBJECT " + (j + 1));
            System.out.println("Highest scoring student: Student " + (highestScoring[j] + 1) + " with score: " + highestScore[j]);
            System.out.println("Lowest scoring student: Student " + (lowestScoring[j] + 1) + " with score: " + lowestScore[j]);

            for (int i = 0; i < numberOfStudents; i++) {
                subjectTotalScore += scores[i][j];
                if (scores[i][j] >= 60) {
                    subjectPass++;
                } else {
                    subjectFail++;
                }
            }

            double subjectAverage = (double) subjectTotalScore / numberOfStudents;
            System.out.println("Total score: " + subjectTotalScore);
            System.out.printf("Average score: %.2f%n", subjectAverage);
            System.out.println("Number of passes: " + subjectPass);
            System.out.println("Number of fails: " + subjectFail);

            if (subjectFail > maxFails) {
                maxFails = subjectFail;
                hardestSubjectIndex = j;
            }
            if (subjectPass > maxPasses) {
                maxPasses = subjectPass;
                easiestSubjectIndex = j;
            }
        }


        System.out.println();
        System.out.println("The hardest subject is Subject " + (hardestSubjectIndex + 1) + " with " + maxFails + " fails");
        System.out.println("The easiest subject is: Subject " + (easiestSubjectIndex + 1) + " with " + maxPasses + " passes");
        System.out.println("The overall highest score is scored by student "+ (overallHighestStudent + 1) + " in Subject " + (overallHighestSubject + 1) + " Scoring" + " " + overallHighestScore);
        System.out.println("The overall lowest score is scored by student "+ (overallLowestStudent + 1) + " in Subject " + (overallLowestSubject + 1) + " Scoring" + " " + overallLowestScore);
        System.out.println("=====================================================");

        int bestStudentIndex = 0;
        int worstStudentIndex = 0;
        int highestTotalScore = totalScores[0];
        int lowestTotalScore = totalScores[0];

        for (int i = 1; i < numberOfStudents; i++) {
            if (totalScores[i] > highestTotalScore) {
                highestTotalScore = totalScores[i];
                bestStudentIndex = i;
            }
            if (totalScores[i] < lowestTotalScore) {
                lowestTotalScore = totalScores[i];
                worstStudentIndex = i;
            }
        }


        System.out.println();
        System.out.println("\nCLASS SUMMARY");
        System.out.println("=====================================================");
        System.out.println("Best graduating student is: Student " + (bestStudentIndex + 1) + " with total score: " + highestTotalScore);
        System.out.println("=====================================================");
        System.out.println();
        System.out.println();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Worst graduating student is: Student " + (worstStudentIndex + 1) + " with total score: " + lowestTotalScore);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("Class total score is: " + classTotal);
        System.out.printf("Class average score is: %.2f%n", classAverage);
        System.out.println("=====================================================");
        System.out.println();

    }
}


