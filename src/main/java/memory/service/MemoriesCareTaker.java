package memory.service;

import common.UnexpectedExpressionException;
import memory.memento.ScreenMementoDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Handle de Mementos.
 * Interface to the Memory mediator
 */
public interface MemoriesCareTaker {

    MemoryMediator memoryMediator = new MemoryMediator();

    default void keepComponentValue(String expr, String res, String mode) {
        if (expr == null || res == null) return;
        ScreenMementoDTO txt = new ScreenMementoDTO(expr, res, mode);
        memoryMediator.addItem(txt);
    }

    default void loadCircularList(File memorized) throws IOException, UnexpectedExpressionException {
        if (memorized == null) return;
        memoryMediator.cleanCircularList();
        memoryMediator.retrieveCircularList(memorized);
    }

    default void saveToFile(File fileToMemorize) throws FileNotFoundException {
        memoryMediator.saveHistory(fileToMemorize);
    }

    default String loadMemory() {
        return memoryMediator.loadHistory();
    }

    default CircularLinkedListService history() {
        return memoryMediator.getNavigationListService();
    }

}
