package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SocialMediaApp extends Application {
    private UserManager userManager = new UserManager();
    private User currentUser = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("I-Sun Social Media Platform");

        // Main layout
        BorderPane mainLayout = new BorderPane();

        // Scene setup
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);

        // Show login/register screen
        showLoginRegisterScreen(mainLayout);

        primaryStage.show();
    }

    private void showLoginRegisterScreen(BorderPane mainLayout) {
        VBox loginRegisterLayout = new VBox(10);

        // Register Section
        Label registerLabel = new Label("Register");
        TextField regUsername = new TextField();
        regUsername.setPromptText("Username");
        PasswordField regPassword = new PasswordField();
        regPassword.setPromptText("Password");
        TextField regEmail = new TextField();
        regEmail.setPromptText("Email");
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            String username = regUsername.getText();
            String password = regPassword.getText();
            String email = regEmail.getText();
            userManager.registerUser(username, password, email);
        });

        // Login Section
        Label loginLabel = new Label("Login");
        TextField loginUsername = new TextField();
        loginUsername.setPromptText("Username");
        PasswordField loginPassword = new PasswordField();
        loginPassword.setPromptText("Password");
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = loginUsername.getText();
            String password = loginPassword.getText();
            if (userManager.loginUser(username, password)) {
                currentUser = new User(username, password, ""); // Email is not used here for simplicity
                showUserScreen(mainLayout);
            }
        });

        // Adding to layout
        loginRegisterLayout.getChildren().addAll(registerLabel, regUsername, regPassword, regEmail, registerButton,
                loginLabel, loginUsername, loginPassword, loginButton);
        mainLayout.setCenter(loginRegisterLayout);
    }

    private void showUserScreen(BorderPane mainLayout) {
        VBox userLayout = new VBox(10);

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            currentUser = null;
            showLoginRegisterScreen(mainLayout);
        });

        Button createPostButton = new Button("Create Post");
        createPostButton.setOnAction(e -> showCreatePostScreen(mainLayout));

        Button viewPostsButton = new Button("View Posts");
        viewPostsButton.setOnAction(e -> showViewPostsScreen(mainLayout));

        userLayout.getChildren().addAll(new Label("Welcome, " + currentUser.getUsername()), logoutButton, createPostButton, viewPostsButton);
        mainLayout.setCenter(userLayout);
    }

    private void showCreatePostScreen(BorderPane mainLayout) {
        VBox createPostLayout = new VBox(10);

        TextField postTitle = new TextField();
        postTitle.setPromptText("Post Title");
        TextArea postContent = new TextArea();
        postContent.setPromptText("Post Content");
        Button postButton = new Button("Post");
        postButton.setOnAction(e -> {
            String title = postTitle.getText();
            String content = postContent.getText();
            currentUser.createPost(title, content);
            showUserScreen(mainLayout);
        });

        createPostLayout.getChildren().addAll(postTitle, postContent, postButton);
        mainLayout.setCenter(createPostLayout);
    }

    private void showViewPostsScreen(BorderPane mainLayout) {
        VBox viewPostsLayout = new VBox(10);

        for (User user : userManager.getUsers()) {
            for (Post post : user.getPosts()) {
                VBox postLayout = new VBox(5);
                postLayout.getChildren().addAll(
                        new Label("Title: " + post.getTitle()),
                        new Label("Content: " + post.getPostContent()),
                        new Label("Author: " + post.getAuthorName()),
                        new Label("Likes: " + post.getPostLikes())
                );

                TextField commentField = new TextField();
                commentField.setPromptText("Add a comment");
                Button commentButton = new Button("Comment");
                commentButton.setOnAction(e -> {
                    String comment = commentField.getText();
                    post.addComment(comment, currentUser.getUsername());
                    showViewPostsScreen(mainLayout);
                });

                Button likeButton = new Button("Like");
                likeButton.setOnAction(e -> {
                    post.likePost(currentUser.getUsername());
                    showViewPostsScreen(mainLayout);
                });

                postLayout.getChildren().addAll(commentField, commentButton, likeButton);
                viewPostsLayout.getChildren().add(postLayout);
            }
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showUserScreen(mainLayout));

        viewPostsLayout.getChildren().add(backButton);
        mainLayout.setCenter(viewPostsLayout);
    }
}