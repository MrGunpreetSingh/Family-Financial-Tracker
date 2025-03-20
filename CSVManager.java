import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CSVManager {
    private static final String TRANSACTION_FILE = "transactions.csv";
    private static final String INCOME_FILE = "income.csv";
    private static final String CATEGORY_FILE = "categories.csv";
    private static final String SAVINGS_GOAL_FILE = "savings_goal.csv";

    public static List<String> loadTransactions() {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TRANSACTION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public static void addExpense(LocalDate date, String category, double amount, String notes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TRANSACTION_FILE, true))) {
            bw.write(date + "," + category + "," + amount + "," + notes + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTransaction(String transaction) {
        List<String> transactions = loadTransactions();
        transactions.remove(transaction);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TRANSACTION_FILE))) {
            for (String t : transactions) {
                bw.write(t + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Double> getCategoryExpenses() {
        Map<String, Double> categoryExpenses = new HashMap<>();
        List<String> transactions = loadTransactions();

        for (String entry : transactions) {
            String[] parts = entry.split(",");
            if (parts.length >= 3) {
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);
                categoryExpenses.put(category, categoryExpenses.getOrDefault(category, 0.0) + amount);
            }
        }
        return categoryExpenses;
    }

    public static List<String> loadExpenses() {
        return loadTransactions();
    }

    public static List<String> loadIncome() {
        List<String> incomeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INCOME_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                incomeList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return incomeList;
    }

    public static void addIncome(LocalDate date, double amount) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INCOME_FILE, true))) {
            bw.write(date + "," + amount + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteIncome(String incomeEntry) {
        List<String> incomeList = loadIncome();
        incomeList.remove(incomeEntry);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INCOME_FILE))) {
            for (String entry : incomeList) {
                bw.write(entry + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getTotalExpenses() {
        double total = 0.0;
        for (String entry : loadTransactions()) {
            String[] parts = entry.split(",");
            if (parts.length >= 3) {
                total += Double.parseDouble(parts[2]);
            }
        }
        return total;
    }

    public static double getTotalIncome() {
        double total = 0.0;
        for (String entry : loadIncome()) {
            String[] parts = entry.split(",");
            if (parts.length >= 2) {
                total += Double.parseDouble(parts[1]);
            }
        }
        return total;
    }

    public static void saveSavingsGoal(double goal) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SAVINGS_GOAL_FILE))) {
            bw.write(String.valueOf(goal));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double loadSavingsGoal() {
        try (BufferedReader br = new BufferedReader(new FileReader(SAVINGS_GOAL_FILE))) {
            return Double.parseDouble(br.readLine());
        } catch (IOException | NumberFormatException e) {
            return 0.0;
        }
    }

    public static List<String> loadCategories() {
        List<String> categories = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CATEGORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                categories.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static void saveCategory(String category) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CATEGORY_FILE, true))) {
            bw.write(category + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCategory(String category) {
        List<String> categories = loadCategories();
        categories.remove(category);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CATEGORY_FILE))) {
            for (String cat : categories) {
                bw.write(cat + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
