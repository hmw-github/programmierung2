package kapitel9.tablemanager;

import javafx.application.Application;
import kapitel9.tablemanager.ui.TableManager;

/**
 * Start JavaFX application by calling launch with TableManager class...
 * OR: define main() in TableManager and call launch without class...
 */
public class Main {
    public static void main(String[] args) {
        Application.launch(TableManager.class, args);
    }
}
