package myDiary;

import java.util.Scanner;


public class MainApplication {
    private static Scanner userInput = new Scanner(System.in);
    private static Diary diary = null;
    private static Diaries diaries = new Diaries();


    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            displayMainMenu();
            String input = userInput.nextLine().trim();

            switch (input) {
                case "1":
                    createDiary();
                    break;
                case "2":
                    findDiary();
                    break;
                case "3":
                    deleteDiary();
                    break;
                case "4":
                    System.out.println("Thank you for using the Diary App. Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }

    }


    private static void displayMainMenu() {
        System.out.println("\n==================================================");
        System.out.println("       WELCOME TO THE DIARY APPLICATION!");
        System.out.println("""
        ========== ==== MAIN MENU === =========================
        =======================================================
            1. Create Diary
            2. Find Diary
            3. Delete Diary
            4. Exit
        =======================================================
        Choose an option (1-4):
        """);
    }



    private static String getUsernameInput() {
        String input;
        while(true) {
            System.out.print("Select Username (at least 8 characters, letters only) or 'cancel' to go back: ");
            input = userInput.nextLine().trim();
            if(input.equalsIgnoreCase("cancel")) {
                return null;
            }
            if(input.length() <= 8 && input.matches("^[a-zA-Z]+$")) {
                return input;

            }else{
                System.out.println("Invalid Username! Please use at least 8 characters, only letters");
            }
        }

    }


    private static String getPasswordInput() {
        while(true) {
            System.out.print("Select Password (at least 10 characters, letters and numbers only) or 'cancel' to go back: ");
            String input = userInput.nextLine().trim();
            if(input.equalsIgnoreCase("cancel")) {
                return null;
            }
            if(input.length() <= 10 && input.matches("^[a-zA-Z0-9]+$")) {
                return input;
            }else{
                System.out.println("Invalid Password! Please use at least 10 characters, containing only letters and numbers");
            }
        }
    }


    private static String getEntryIdInput() {
        while(true) {
            System.out.print("Enter entry ID (or 'cancel' to go back): ");
            String input = userInput.nextLine().trim();
            if (input.equalsIgnoreCase("cancel")) {
                return null;
            }
            if (input.matches("[0-9]")) {
                return input;
            } else {
                System.out.println("Invalid entry ID! Please try again.");

            }
        }
    }


    private static String getEntryTitleInput() {
        while(true) {
            System.out.print("Enter entry title (or 'cancel' to go back): ");
            String input = userInput.nextLine().trim();
            if(input.equalsIgnoreCase("cancel")) {
                return null;
            }
            if(input.matches("^[a-zA-Z]+")) {
                return input;
            }else{
                System.out.println("Invalid title! Please try again.");
            }
        }
    }


    private static String getEntryBodyInput() {
        String input;
        while(true) {
            System.out.print("Enter entry body (or 'cancel' to go back): ");
            input = userInput.nextLine().trim();
            if(input.equalsIgnoreCase("cancel")) {
                return null;
            }
            if(!input.isEmpty()) {
                return input;
            }else{
                System.out.println("Invalid body details!!! use letters and numbers! Please try again.");
            }
        }
    }

    private static void createDiary() {
        String username = getUsernameInput();
        if(username == null) return;

        if (diaries.findByUserName(username) != null) {
            System.out.println("A diary with this username already exists!");
            return;
        }

        String password = getPasswordInput();

        diaries.add(username, password);
        System.out.println("Your diary has been created! for user: " + username);


    }


    private static void findDiary() {
        String username = getUsernameInput();

        diary = diaries.findByUserName(username);
        if (diary == null) {
            System.out.println("No diary found for username: " + username);
            return;
        }

        String password = getPasswordInput();

        if(diary.isLocked()){
            diary.unlockDiary(password);
            if(diary.isLocked()){
                System.out.println("Incorrect password! Cannot unlock diary.");
                return;
            }
            System.out.println("Diary unlocked successfully.");

        }else if(!diary.verifyPassword(password)){
            System.out.println("Incorrect password! Cannot verify diary.");
            return;
        }
        diaryMenu();
    }

    private static void diaryMenu() {
        boolean inDiary = true;
        while (inDiary) {
            System.out.println("\n====================================");
            System.out.println("Diary Menu for =====" + " " + diary.getUsername() + " " + "=====");
            System.out.println("""
                    ============================================
                    1. Create Entry
                    2. Find Entry With ID
                    3. Update Entry
                    4. Delete Entry
                    5. Lock Diary
                    Choose an option (1-5)
                    ============================================
                    """);
            String choice = userInput.nextLine().trim();
            switch (choice) {
                case "1":
                    createEntry();
                    break;
                    case "2":
                        findEntryUsingId();
                        break;
                        case "3":
                            updateEntry();
                            break;
                            case "4":
                                deleteEntry();
                                break;
                                case "5":
                                    diary.lockDiary();
                                    System.out.println("Diary locked successfully.");
                                    inDiary = false;
                                    break;
                                        default:
                                            System.out.println("Invalid choice! Please try again.");
            }
        }
    }


    private static void createEntry() {
        String title = getEntryTitleInput();
        String body = getEntryBodyInput();

        diary.createEntry(title, body);

        Entry lastEntryId = diary.getLatestEntryId();
        System.out.println("Your entry has been created!");
        System.out.println("ENTRY ID is: " + lastEntryId.getId());
        System.out.println("Created: " + lastEntryId.getDateCreated());


    }

    public static void findEntryUsingId() {
        String id = getEntryIdInput();
        if(id == null) return;

        Entry entry = diary.findEntryById(Integer.parseInt(id));

        if (entry == null) {
            System.out.println("No entry found with ID: " + id);
            return;
        }
        System.out.println("============================================");
        System.out.println("\nEntry ID: " + entry.getId());
        System.out.println("Title: " + entry.getTitle());
        System.out.println("Body: " + entry.getBody());
        System.out.println("Created: " + entry.getDateCreated());
        System.out.println("============================================");
    }


    private static void updateEntry() {
        String id = getEntryIdInput();
        if(id == null) return;

        Entry entry = diary.findEntryById(Integer.parseInt(id));
        if (entry == null) {
            System.out.println("No entry found with ID: " + id);
            return;
        }

       String newTitle = getEntryTitleInput();
       String newBody = getEntryBodyInput();

        diary.updateEntry(Integer.parseInt(id),newTitle, newBody);
        System.out.println("Your entry has been updated!");
    }


    private static void deleteEntry() {
        String id = getEntryIdInput();
        if(id == null) return;

        Entry entry = diary.findEntryById(Integer.parseInt(id));
        if (entry == null) {
            System.out.println("No entry found with ID: " + id);
            return;
        }
        diary.deleteEntry(Integer.parseInt(id));
        System.out.println("Your entry has been deleted!");
    }



    private static void deleteDiary() {
        String username = getUsernameInput();
        if(username == null) return;

        Diary diary = diaries.findByUserName(username);
        if (diary == null) {
            System.out.println("No diary found for username: " + username);
            return;
        }

        String password = getPasswordInput();

        diaries.delete(username, password);
        System.out.println("Diary deleted successfully!");

    }


}
