// public class test2 {

// }
import java.util.Scanner;

class User {
    private String username; // intializing the variables
    private String password; // intializing the variables

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { // getters method
        return username;
    }

    public String getPassword() { // getters method
        return password;
    }
}

class UserManager {
    private User[] users;
    private int userCount;

    public UserManager(int capacity) {
        this.users = new User[capacity]; // how many accounts stored?
        this.userCount = 0;
    }

    public boolean signUp(String username, String password) {
        if (username.trim().isEmpty() || password.isEmpty()) {
            System.out.println("Please enter both username and password.");
            return false;
        }

        if (findUser(username) == -1) {
            User newUser = new User(username, password);
            users[userCount++] = newUser;
            System.out.println("Sign up successful!"); // registrating the account
            return true;
        } else {
            System.out.println("Username already exists. Please choose another.");
            return false;
        }
    }

    public boolean login(String username, String password) {
        int userIndex = findUser(username);

        if (username.trim().isEmpty() || password.isEmpty()) {
            System.out.println("Please enter both username and password.");
            return false;
        }

        if (userIndex != -1) {
            User user = users[userIndex];
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful!"); // login indicator
                return true;
            } else {
                System.out.println("Incorrect password. Please try again."); // wrong password indicator
                return false;
            }
        } else {
            System.out.println("User not found. Please sign up.");
            return false;
        }

    }

    private int findUser(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username)) { // finding user
                return i;
            }
        }
        return -1; // User not found
    }
}

class Myhome {
    public void homepage(String[] args) {
        Scanner intscan = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("PQA MEMORIZATION");
            System.out.println("[1] FOR CVSU VISION");
            System.out.println("[2] FOR CVSU MISSION");
            System.out.println("[3] FOR CVSU QUALITY POLICY");
            System.out.println("[4] FOR EXIT");
            int choice = intscan.nextInt();

            switch (choice) {
                case 1:

                    String[] visionLines = {
                            "The premier university in historic Cavite globally recognized",
                            "for excellence in character development,",
                            "academics, research, innovation and sustainable community engagement."
                    };

                    for (String line : visionLines) {
                        String[] words = line.split(" ");
                        for (String word : words) {
                            System.out.print(word + " ");
                            try {
                                Thread.sleep(700);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    String[] missionLines = {
                            "Cavite State University shall provide excellent, equitable and relevant educational",
                            "opportunities in the arts, sciences and technology through quality instruction and",
                            "responsive research and development activities. it shall produce professional, skilled",
                            "and morally upright individuals for global competitiveness."
                    };

                    for (String line : missionLines) {
                        String[] words = line.split(" ");
                        for (String word : words) {
                            System.out.print(word + " ");
                            try {
                                Thread.sleep(700);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }

                    break;
                case 3:
                    String[] qualitypolicyLines = {
                            "We Commit to the highest standards of education, value our stakeholder, Strive for",
                            "continual improvement of our products and services, and Uphold the university's tenets",
                            "of truth, excellence and service to produce globally competitve and morally upright individuals"
                    };

                    for (String line : qualitypolicyLines) {
                        String[] words = line.split(" ");
                        for (String word : words) {
                            System.out.print(word + " ");
                            try {
                                Thread.sleep(700);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("BYE");
                    System.exit(0);
                    break;

            }

        }
    }
}

public class Login_and_Signup_Form_Cvsu_pqa {

    public static void main(String[] args) {
        UserManager userManager = new UserManager(10);
        Scanner scanner = new Scanner(System.in);
        Myhome myObject = new Myhome();

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String signUpUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String signUpPassword = scanner.nextLine();
                    userManager.signUp(signUpUsername, signUpPassword);
                    break; // signup
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    userManager.login(loginUsername, loginPassword);
                    myObject.homepage(args);
                    break; // login
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break; // terminating the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
