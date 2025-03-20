import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyAlerts {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("My Alerts");

        TextArea alertArea = new TextArea();
        alertArea.setEditable(false);

        double totalIncome = CSVManager.getTotalIncome();
        double totalExpenses = CSVManager.getTotalExpenses();
        double savingsGoal = CSVManager.loadSavingsGoal();

        String alertMessage = "No Alerts! Your savings are on track.";

        if (totalExpenses > (totalIncome - savingsGoal)) {
            alertMessage = "⚠ Warning: Your spending is exceeding your savings goal!";
        }

        alertArea.setText(alertMessage);

        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(new Label("Spending Alert:"), alertArea, closeBtn);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
