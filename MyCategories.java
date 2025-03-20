import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class MyCategories {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("My Categories");

        ListView<String> categoryList = new ListView<>();
        categoryList.getItems().addAll(
            "Bills", "Groceries", "Entertainment", "Dining out", "Utilities", "Other"
        );

        TextField newCategoryField = new TextField();
        newCategoryField.setPromptText("New Category");

        Button addCategory = new Button("Add Category");
        addCategory.setOnAction(e -> {
            String newCat = newCategoryField.getText();
            if (!newCat.isEmpty()) {
                categoryList.getItems().add(newCat);
                newCategoryField.clear();
            }
        });

        VBox layout = new VBox(10, categoryList, newCategoryField, addCategory);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        window.setScene(new Scene(layout, 300, 400));
        window.show();
    }
}
