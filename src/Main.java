import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelAidSystem system = new TravelAidSystem();

        while (true) {
            System.out.println("\nMENU OPTIONS \n1.Sign up \n2.Login \n3.Exit\n");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();

                System.out.println("Enter password:");
                String password = scanner.nextLine();

                if (TravelAidSystem.signup(username, password)) {
                    System.out.println("Sign up successful.");
                } else {
                    System.out.println("Sign up failed.");
                }
            } else if (choice == 2) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();

                System.out.println("Enter password:");
                String password = scanner.nextLine();

                if (TravelAidSystem.login(username, password)) {
                    System.out.println("Login successful.");
                } else {
                    System.out.println("Login failed.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
