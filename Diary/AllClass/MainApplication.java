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
            input = userInput.nextLine().trim();
            if(input.equalsIgnoreCase("cancel")) {
                return null;
            }
            if(input.matches("^[a-zA-Z]{5}$")) {
                return input;

            }else{
                System.out.println("Invalid Username or username not found! username should be atleast 5 characters, only letters");
            }
        }

    }


    private static String getPasswordInput() {
        while(true) {
            String input = userInput.nextLine().trim();
            if(input.equalsIgnoreCase("cancel")) {
                return null;
            }
            if(input.matches("^[a-zA-Z0-9]{8}$")) {
                return input;
            }else{
                System.out.println("Invalid Password or password incorrect! password should be atleast 8 characters, containing only letters and numbers");
            }
        }
    }


    private static String getEntryIdInput() {
        while(true) {
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
        System.out.println("Select Username (at least 5 characters, letters only) or 'cancel' to go back: ");
        String username = getUsernameInput();
        if(username == null) return;

        if (diaries.findByUserName(username) != null) {
            System.out.println("A diary with this username already exists!");
            return;
        }

        System.out.println("Select Password (at least 8 characters, letters and numbers only) or 'cancel' to go back: ");
        String password = getPasswordInput();
        if(password == null) return;

        diaries.add(username, password);
        System.out.println("Your diary has been created! for user: " + username);


    }


    private static void findDiary() {
        System.out.println("Enter username used to register or 'cancel' to go back: ");
        String username = getUsernameInput();
        if(username == null) return;

        diary = diaries.findByUserName(username);
        if (diary == null) {
            System.out.println("No diary found for username: " + username);
            return;
        }

        System.out.println("Enter password used to register or 'cancel' to go back: ");
        String password = getPasswordInput();
        if(password == null) return;


        if(diary.isLocked()){
            diary.unlockDiary(password);
            if(diary.isLocked()){
                System.out.println("Incorrect password! Cannot unlock diary.");
                return;
            }
            System.out.println("Diary unlocked successfully.");

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
        System.out.println("Enter entry title (or 'cancel' to go back): ");
        String title = getEntryTitleInput();
        if(title == null) return;

        System.out.println("Enter entry body (or 'cancel' to go back): ");
        String body = getEntryBodyInput();
        if(body == null) return;

        diary.createEntry(title, body);

        Entry lastEntryId = diary.getLatestEntryId();

        System.out.println("Your entry has been created!");
        System.out.println("ENTRY ID is: " + lastEntryId.getId());
        System.out.println("Created: " + lastEntryId.getDateCreated());


    }

    public static void findEntryUsingId() {
        System.out.println("Enter entry ID (or 'cancel' to go back): ");
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
        System.out.println("Enter id of entry to update: ");
        String id = getEntryIdInput();
        if(id == null) return;

        Entry entry = diary.findEntryById(Integer.parseInt(id));
        if (entry == null) {
            System.out.println("No entry found with ID: " + id);
            return;
        }

        System.out.println("Enter update to add to title entry: ");
        String newTitle = getEntryTitleInput();
        System.out.println("Enter update to add to body entry: ");
        String newBody = getEntryBodyInput();

        diary.updateEntry(Integer.parseInt(id),newTitle, newBody);
        System.out.println("Your entry has been updated!");
    }


    private static void deleteEntry() {
        System.out.println("Enter id to delete entry: ");
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
        System.out.println("Enter username to delete diary: ");

        String username = getUsernameInput();
        if(username == null) return;

        Diary diary = diaries.findByUserName(username);
        if (diary == null) {
            System.out.println("No diary found for username: " + username);
            return;
        }

        System.out.println("Enter password to delete diary: ");
        String password = getPasswordInput();

        diaries.delete(username, password);
        System.out.println("Diary deleted successfully!");

    }


}
