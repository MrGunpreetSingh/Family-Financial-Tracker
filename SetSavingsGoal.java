import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class SetSavingsGoal {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Set Savings Goal");

        Label lblGoal = new Label("Enter your monthly savings goal:");
        TextField txtGoal = new TextField();

        double existingGoal = CSVManager.loadSavingsGoal();
        if (existingGoal != -1) {
            txtGoal.setText(String.valueOf(existingGoal));
        }

        Button btnSave = new Button("Save Goal");
        btnSave.setOnAction(e -> {
            try {
                double goal = Double.parseDouble(txtGoal.getText());
                CSVManager.saveSavingsGoal(goal);
                window.close();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid goal amount!");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, lblGoal, txtGoal, btnSave);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 150);
        window.setScene(scene);
        window.showAndWait();
    }
}
