import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

class User {

    private static final String FILENAME = "users.txt";

    public static String getUsername(String username) {
        try {
            Scanner scanner = new Scanner(new File(FILENAME));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                if (tokens[0].equals(username)) {
                    scanner.close();
                    return tokens[0];
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean setUsername(String username, String password) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true));
            writer.write(username + "," + password);
            writer.newLine();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getPassword(String username) {
        try {
            Scanner scanner = new Scanner(new File(FILENAME));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                if (tokens[0].equals(username)) {
                    scanner.close();
                    return tokens[1];
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean setPassword(String username, String password) {
        try {
            Scanner scanner = new Scanner(new File(FILENAME));
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                if (tokens[0].equals(username)) {
                    builder.append(username).append(",").append(password).append("\\n");
                } else {
                    builder.append(line).append("\\n");
                }
            }
            scanner.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
            writer.write(builder.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void Message(String message) {
        System.out.println(message);
    }
}
