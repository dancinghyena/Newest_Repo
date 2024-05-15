package application;
import java.time.LocalDate;
import java.time.LocalTime;

public class Post 
{
    private String postAuthorName; //same as username
    private final LocalDate postCreationDate;
    private final LocalTime postCreationTime;
    private String postContent;
    private int postID;

    public Post(String postAuthorName, String postContent, int postID) {
        this.postAuthorName = postAuthorName;
        this.postCreationDate = LocalDate.now();
        this.postCreationTime = LocalTime.now();
        this.postContent = postContent;
        this.postID = 0;
    }
    public Post(String postAuthorName, LocalDate postCreationDate, LocalTime postCreationTime, String postContent, int postID) {
        this.postAuthorName = postAuthorName;
        this.postCreationDate = postCreationDate;
        this.postCreationTime = postCreationTime;
        this.postContent = postContent;
        this.postID = 0;
    }

    // Getter and setter methods for postContent
    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    // Getter method for dateCreated
    public LocalDate getpostCreationDate() {
        return postCreationDate;
    }
    
    public LocalTime getpostCreationTime() {
        return postCreationTime;
    }

        // Method to convert user object to comma-separated string
    public String toCSVString() {
        return postAuthorName + ",,," + postCreationDate + ",,," + postCreationTime + ",,," + postContent + ",,," + postID;
    }
    
}