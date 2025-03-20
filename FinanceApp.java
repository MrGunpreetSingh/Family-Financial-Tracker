import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinanceApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginScreen.display(primaryStage);
    }

    public static void showMainMenu(Stage primaryStage) {
        primaryStage.setTitle("Personal Financial Manager");

        Label lblTitle = new Label("💰 Welcome to Your Personal Finance Manager!");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button btnAddEntry = new Button("+ Add Entry");
        btnAddEntry.setOnAction(e -> AddEntry.display());

        Button btnSetSavingsGoal = new Button("⚙ Set Savings Goal");
        btnSetSavingsGoal.setOnAction(e -> SetSavingsGoal.display());

        Button btnTransactionHistory = new Button("📜 Transaction History");
        btnTransactionHistory.setOnAction(e -> TransactionHistory.display());

        Button btnFinancialReport = new Button("📊 Financial Report");
        btnFinancialReport.setOnAction(e -> FinancialReport.display());

        Button btnExpenseChart = new Button("💸 Expense Chart");
        btnExpenseChart.setOnAction(e -> ExpenseChart.display());

        Button btnMyAlerts = new Button("⚠ My Alerts");
        btnMyAlerts.setOnAction(e -> MyAlerts.display());

        Button btnMyCategories = new Button("📂 My Categories");
        btnMyCategories.setOnAction(e -> CategoryManager.display());

        Button btnIncome = new Button("💰 Income");
        btnIncome.setOnAction(e -> IncomeManager.display());

        Button btnDarkMode = new Button("🌙 Toggle Dark Mode");
        btnDarkMode.setOnAction(e -> DarkMode.toggleDarkMode(primaryStage.getScene()));

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
            lblTitle, btnAddEntry, btnSetSavingsGoal, btnTransactionHistory,
            btnFinancialReport, btnExpenseChart, btnMyAlerts, btnMyCategories,
            btnIncome, btnDarkMode
        );

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
