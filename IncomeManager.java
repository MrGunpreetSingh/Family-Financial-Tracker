import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class IncomeManager {
    public static void display() {
        Stage window = new Stage();
        window.setTitle("Manage Income");

        ListView<String> incomeList = new ListView<>();
        incomeList.getItems().addAll(CSVManager.loadIncome());

        TextField amountInput = new TextField();
        amountInput.setPromptText("Enter income amount");

        Button addButton = new Button("Add Income");
        addButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountInput.getText());
                LocalDate date = LocalDate.now();
                CSVManager.addIncome(date, amount);
                incomeList.getItems().add(date + ", " + amount);
                amountInput.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input!");
                alert.show();
            }
        });

        Button deleteButton = new Button("Delete Selected");
        deleteButton.setOnAction(e -> {
            String selected = incomeList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                CSVManager.deleteIncome(selected);
                incomeList.getItems().remove(selected);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(incomeList, amountInput, addButton, deleteButton);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
