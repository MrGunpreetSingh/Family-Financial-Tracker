import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.List;

public class TransactionHistory {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Transaction History");

        ListView<String> transactionList = new ListView<>();
        transactionList.getItems().addAll(CSVManager.loadTransactions());

        Button btnDelete = new Button("🗑 Delete Selected");
        btnDelete.setOnAction(e -> {
            String selected = transactionList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                CSVManager.deleteTransaction(selected);
                transactionList.getItems().remove(selected);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(transactionList, btnDelete);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
