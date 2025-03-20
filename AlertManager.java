import javafx.scene.control.Alert;

public class AlertManager {

    public static void checkSpending() {
        double totalIncome = CSVManager.getTotalIncome();
        double totalExpenses = CSVManager.getTotalExpenses();
        double savingsGoal = CSVManager.loadSavingsGoal();

        if (totalExpenses > (totalIncome - savingsGoal)) {
            showAlert("Warning", "Your expenses exceed your available budget after savings!");
        }
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
