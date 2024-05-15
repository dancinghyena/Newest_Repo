package application;


public class User 
{
    private int userID;
    private String username;
    private String email;
    private String password;
    private String bio;
    
    public User()
    {
        
    }
    
    public User(String username, String password, String email, String bio) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
    }
    
    
    
    public User(int userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.password = password;
    }
    
    public User(int userID, String username, String password, String email, String bio) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
    }
    
    
    public void setbio(String bio) {
        this.bio = bio;
    }
    public String getbio () {
        return bio;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    

        // Method to convert user object to comma-separated string
    public String toCSVString() {
        return userID + ",,," + username + ",,," + email + ",,," + password + ",,," + bio;
    }


}