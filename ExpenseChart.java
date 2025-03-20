import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Map;

public class ExpenseChart {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Expense Chart");

        PieChart pieChart = new PieChart();
        Map<String, Double> expenses = CSVManager.getCategoryExpenses();

        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            pieChart.getData().add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        VBox layout = new VBox(pieChart);
        Scene scene = new Scene(layout, 500, 400);
        window.setScene(scene);
        window.show();
    }
}
