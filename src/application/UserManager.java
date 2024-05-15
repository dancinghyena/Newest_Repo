package application;
import java.util.ArrayList;
import java.util.List;

public class UserManager extends User  {
    private static String loggedInUsername;
    private List<User> users = fileCRUD.readUsers();

    public UserManager() {
        this.users = new ArrayList<>();
    }

   // Method to register a new user
public void registerUser(int userID, String username, String email, String password, String bio) {
    // Check if username or email already exists
    for (User user : users) {
        if (user.getUsername().equals(username)) {
            System.out.println("Username " + username + " is already taken. Please choose a different one.");
            return; // Exit the method without registering the user
        }
        if (user.getEmail().equals(email)) {
            System.out.println("Email " + email + " is already registered. Please use a different email.");
            return; // Exit the method without registering the user
        }
    }
    // If username and email are unique, register the user
    User newUser = new User(userID, username, email, password, bio);
    fileCRUD.addUser(newUser);
}




    // Method to check if a user with a given username and password exists
public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User " + username + " logged in successfully!");
                loggedInUsername = username;
                return true;
            }
        }
        System.out.println("Login failed. Invalid username or password.");
        return false;
    }

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public void setLoggedInUsername(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
    }



}