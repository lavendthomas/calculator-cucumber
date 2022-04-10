package memories;

import memories.navigation.CircularLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static memories.navigation.CircularListMediator.*;

/**
 * Handle de Mementos.
 * Give capabilities to navigate through the history
 */
public interface MemoriesCareTaker {

    ResultOriginator stringResult = new ResultOriginator();

    default void keepComponentValue(String expr, String res) {
        ScreenMementoDTO txt = new ScreenMementoDTO(expr, res);
        stringResult.keepStatusUpdated(txt);
        addItem(txt);
    }

    default void saveToFile(File fileToMemorize) throws FileNotFoundException {
        saveHistory(fileToMemorize);
    }

    default void clean() {
        cleanCircularList();
    }

    default void add(ScreenMementoDTO item) {
        addItem(item);
    }

    default void left() {
        navigateLeft();
    }

    default void right() {
        navigateRight();
    }

    default CircularLinkedList getCircularList() {
        return getCurrent();
    }

    default void loadCircularList(File memorized) throws IOException {
        clean();
        retrieveCircularList(memorized);
    }

}
