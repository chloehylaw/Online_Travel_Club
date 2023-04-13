import java.io.*;
import java.util.*;

class TravelAidSystem {
    private static boolean isUsernameTaken(String username) {
        String existingUsername = User.getUsername(username);
        return existingUsername != null && existingUsername.equals(username);
    }
    public static boolean signup(String username, String password) {
        if (Objects.equals(User.getUsername(username), username)) {
            System.out.println("Username already taken.");
            return false;
        }

        if (username.length() < 8 || username.length() > 12) {
            System.out.println("Error: Username must be between 8-12 characters.");
            return false;
        }

        if (!username.matches("[a-zA-Z0-9]+")) {
            System.out.println("Error: Username must contain only letters and numbers.");
            return false;
        }
        if (password.length() < 8 || password.length() > 12) {
            System.out.println("Error: Password must be between 8-12 characters.");
            return false;
        }
        if (!password.matches("[a-zA-Z0-9!@#$%^&*()_+]+") || !password.matches(".*[A-Z]+.*") || !password.matches(".*[!@#$%^&*()_+]+.*")) {
            System.out.println("Error: Password must contain only letters, numbers, and symbols. Must include at least one capital letter and one symbol.");
            return false;
        }

        if (!User.setUsername(username, password)) {
            System.out.println("Error creating user.");
            return false;
        }

        System.out.println("User created successfully.");
        return true;
    }

    public static boolean login(String username, String password) {

        if (Objects.equals(User.getPassword(username), password)) {
            //System.out.println("Login successful.");
            return true;
        } else {
            //System.out.println("Login failed.");
            return false;
        }
    }

    public static void logout() {
        System.out.println("Logout successful.");
    }
}
