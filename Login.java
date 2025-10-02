import java.io.Console;

public class Login {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "12345";

    public static boolean authenticate() {
        Console console = System.console();

        if (console == null) {
            System.out.println("Console is not available. Please run in terminal.");
            return false;
        }

        int attempts = 0;
        while (attempts < 3) {
            String username = console.readLine("Enter username: ");
            char[] passwordArray = console.readPassword("Enter password: ");
            String password = new String(passwordArray);

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("✅ Login successful!\n");
                return true;
            } else {
                attempts++;
                System.out.println("❌ Incorrect username or password. Attempt " + attempts + " of 3.\n");
            }
        }
        System.out.println("🚫 Access denied. Too many failed attempts.");
        return false;
    }
}
