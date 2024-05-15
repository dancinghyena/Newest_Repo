package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class JavaApplication13 {

    
    public static void main(String[] args) {
        
        User newUser = new User(fileCRUD.getNewUserID(), "username4", "email4@gmail.com", "pass4", "bio 4");
        fileCRUD.addUser(newUser);
        
        Post newPost = new Post(UserManager.getLoggedInUsername() , LocalDate.now(), LocalTime.now(), "post content", fileCRUD.getNewPostID());
        fileCRUD.addPost(newPost);
    }
    
}