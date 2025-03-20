import javafx.scene.Scene;
import java.io.File;

public class DarkMode {
    private static boolean isDarkMode = false;

    public static void toggleDarkMode(Scene scene) {
        File darkModeFile = new File("darkmode.css");

        if (!darkModeFile.exists()) {
            System.out.println("WARNING: darkmode.css not found.");
            return;
        }

        String darkTheme = darkModeFile.toURI().toString();

        if (isDarkMode) {
            scene.getStylesheets().clear(); 
        } else {
            scene.getStylesheets().add(darkTheme);
        }
        isDarkMode = !isDarkMode;
    }
}
