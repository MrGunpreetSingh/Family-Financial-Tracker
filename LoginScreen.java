import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {
    public static void display(Stage primaryStage) {
        primaryStage.setTitle("Login");

        Label lblHeading = new Label("🔐 Welcome! Please Login");
        lblHeading.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button btnLogin = new Button("Login");
        btnLogin.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals("admin") && password.equals("password")) {
                FinanceApp.showMainMenu(primaryStage);
            } else {
                lblHeading.setText("❌ Invalid Login. Try Again!");
            }
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(lblHeading, usernameField, passwordField, btnLogin);

        Scene scene = new Scene(layout, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
