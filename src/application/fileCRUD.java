package application;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class fileCRUD {
    ////for users.txt
    public static List<User> readUsers(){
        List<User> users = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",,,");
                int userID = Integer.parseInt(parts[0]);
                String username = parts[1];
                String email = parts[2];
                String password = parts[3];
                String bio = parts[4];
                users.add(new User(userID, username, email, password, bio));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        //Print the ArrayList of User objects:
//        for (User user : users) {
//            System.out.println(user);
        return users;
        }
    //for new user    
    private static int lastUserID = 0; //default value if file is empty

    public static int getNewUserID(){
        
        
        try {
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",,,");
            lastUserID = Integer.parseInt(parts[0]);
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return lastUserID + 1;
    }
    
    public static void addUser(User user) {
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
            writer.newLine(); // Move to the next line
            writer.write(user.toCSVString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    ////for posts.txt
    public static List<Post> readPosts(){
        List<Post> posts = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("posts.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",,,");
                String postAuthorName = parts[0];
                LocalDate postCreationDate = LocalDate.parse(parts[1]);
                LocalTime postCreationTime = LocalTime.parse(parts[2]);
                String postContent = parts[3];
                int postID = Integer.parseInt(parts[4]);
                posts.add(new Post(postAuthorName, postCreationDate, postCreationTime, postContent, postID));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        //Print the ArrayList of User objects:
//        for (User user : users) {
//            System.out.println(user);
        return posts;
        }
    //for new post  
    private static int lastPostID = 0; //default value if file is empty
    
    public static int getNewPostID(){
        
        
        try {
        BufferedReader reader = new BufferedReader(new FileReader("posts.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",,,");
            lastPostID = Integer.parseInt(parts[4]);
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return lastPostID + 1;
    }
    
    public static void addPost(Post post) {
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("posts.txt", true));
            writer.newLine(); // Move to the next line
            writer.write(post.toCSVString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    