import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CategoryManager {
    public static void display() {
        Stage window = new Stage();
        window.setTitle("Manage Categories");

        ListView<String> categoryList = new ListView<>();
        categoryList.getItems().addAll(CSVManager.loadCategories());

        TextField categoryInput = new TextField();
        categoryInput.setPromptText("Enter new category");

        Button addButton = new Button("Add Category");
        addButton.setOnAction(e -> {
            String category = categoryInput.getText();
            if (!category.isEmpty()) {
                CSVManager.saveCategory(category);
                categoryList.getItems().add(category);
                categoryInput.clear();
            }
        });

        Button deleteButton = new Button("Delete Selected");
        deleteButton.setOnAction(e -> {
            String selected = categoryList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                CSVManager.deleteCategory(selected);
                categoryList.getItems().remove(selected);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(categoryList, categoryInput, addButton, deleteButton);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
