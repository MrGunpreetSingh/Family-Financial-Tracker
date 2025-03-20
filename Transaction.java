import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction {
    private final StringProperty date;
    private final StringProperty category;
    private final StringProperty amount;
    private final StringProperty notes;

    public Transaction(String date, String category, String amount, String notes) {
        this.date = new SimpleStringProperty(date);
        this.category = new SimpleStringProperty(category);
        this.amount = new SimpleStringProperty(amount);
        this.notes = new SimpleStringProperty(notes);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public String toCSV() {
        return date.get() + "," + category.get() + "," + amount.get() + "," + notes.get();
    }
}
