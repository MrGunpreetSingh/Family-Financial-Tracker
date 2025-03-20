import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinancialReport {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Financial Report");

        ComboBox<String> periodSelector = new ComboBox<>();
        periodSelector.getItems().addAll("Weekly", "Monthly");
        periodSelector.setValue("Weekly");

        TextArea reportArea = new TextArea();
        Button generateReport = new Button("Generate Report");
        generateReport.setOnAction(e -> {
            double totalIncome = CSVManager.getTotalIncome();
            double totalExpenses = CSVManager.getTotalExpenses();
            double netSavings = totalIncome - totalExpenses;

            String report = "Financial Report (" + periodSelector.getValue() + ")\n" +
                            "Total Income: $" + totalIncome + "\n" +
                            "Total Expenses: $" + totalExpenses + "\n" +
                            "Net Savings: $" + netSavings + "\n" +
                            "------------------------------\n";

            for (String entry : CSVManager.loadExpenses()) {
                report += entry + "\n";
            }

            reportArea.setText(report);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(periodSelector, generateReport, reportArea);

        Scene scene = new Scene(layout, 500, 400);
        window.setScene(scene);
        window.show();
    }
}
