package memory.service;

import common.UnexpectedExpressionException;
import memory.CircularLinkedList;
import memory.memento.ResultOriginator;
import memory.memento.ScreenMementoDTO;
import java.io.*;
import static memory.memento.ScreenMementoDTO.marshaller;

/**
 * The MemoryMediator make several third parties work together.
 *
 * CircularLinkedListService :
 * - Provide Navigation and
 * - memory capacity configuration
 *
 * Memento :
 * - retrieveCircularList read a file to handle it's CircularLinkedList content
 * - saveCircularList save the CircularLinkedList content to a file
 * - add and clean
 */
public class MemoryMediator {

    private final CircularLinkedListService navigationListService;
    private final ResultOriginator mementoOriginator;

    MemoryMediator(){
        navigationListService = new CircularLinkedListService();
        mementoOriginator = new ResultOriginator();
    }

    /**
     * Access the service that handle Circular linked list
     * @return CircularLinkedListService
     */
    public CircularLinkedListService getNavigationListService() {
        return navigationListService;
    }

    void cleanCircularList() {
        navigationListService.clean();
    }

    CircularLinkedList getCircularListFromLastItem() {
        return navigationListService.getTail();
    }

    ResultOriginator getMementoOriginator() {
        return mementoOriginator;
    }

    void addItem(ScreenMementoDTO val) {
        navigationListService.addNode(val);
        mementoOriginator.keepStatusUpdated(navigationListService.getItems());
    }

    /**
     * Load memory from a file
     * @param memorized
     * @throws IOException
     * @throws UnexpectedExpressionException
     */
    void retrieveCircularList(File memorized) throws IOException, UnexpectedExpressionException {
        cleanCircularList();
        String memorizedLine;

        if(memorized != null){

            BufferedReader reader = new BufferedReader(new FileReader(memorized));
            while ((memorizedLine = reader.readLine()) != null)
                addItem(marshaller(memorizedLine));
        }
    }

    /**
     * save memory to a provided file
     * @param fileToMemorize
     * @throws FileNotFoundException
     */
    void saveHistory(File fileToMemorize) throws FileNotFoundException {
        mementoOriginator.save(fileToMemorize);
    }

    /**
     * load the memory content
     * @return String
     */
    String loadHistory() {
        return mementoOriginator.getMementoContent().toString();
    }

}
