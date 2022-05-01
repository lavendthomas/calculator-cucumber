package memory.service;

import common.UnexpectedExpressionException;
import memory.CircularLinkedList;
import memory.memento.ScreenMementoDTO;
import org.junit.jupiter.api.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
class MemoryMediatorTest {
    private final MemoryMediator memoryMediator = new MemoryMediator();
    private final CircularLinkedListService ACTUAL_EMBEDDED_VALUE_TO_TEST = memoryMediator.getNavigationListService();

    private static final String SELECTED_MODE = "dummy mode";
    private static final String EXPECTED_FIRST_SAVED_VALUE = "1+1 = 2 : "+SELECTED_MODE;
    private static final String EXPECTED_SECOND_SAVED_VALUE = "2+2 = 4 : "+SELECTED_MODE;
    private static final String EXPECTED_LAST_SAVED_VALUE = "4+4 = 8 : "+SELECTED_MODE;
    private static final String EXPECTED_NOT_EXISTING_VALUE = "1+1 = 3 : "+SELECTED_MODE;

    @BeforeEach
    void setUp() {
        // retrieveCircularList();

        memoryMediator.cleanCircularList();
        ACTUAL_EMBEDDED_VALUE_TO_TEST.addNode(new ScreenMementoDTO("1+1", "2", SELECTED_MODE));
        ACTUAL_EMBEDDED_VALUE_TO_TEST.addNode(new ScreenMementoDTO("2+2", "4", SELECTED_MODE));
        ACTUAL_EMBEDDED_VALUE_TO_TEST.addNode(new ScreenMementoDTO("4+4", "8", SELECTED_MODE));
    }

    @Test
    void retrieve_saved_datas_true() {
        assertTrue(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_FIRST_SAVED_VALUE));
        assertTrue(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_SECOND_SAVED_VALUE));
    }

    @Test
    void retrieve_saved_datas_false() {
        assertFalse(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_NOT_EXISTING_VALUE));
    }

    @Test
    void navigate_in_tha_list() {
        // retrieve circularList from Facade
        CircularLinkedList item = memoryMediator.getCircularListFromLastItem();
        if (item == null) fail();

        // navigate like someone doing undo / redo
        assertEquals(item.getValue(), EXPECTED_LAST_SAVED_VALUE);
        assertEquals(item.getPrevious().getValue(), EXPECTED_SECOND_SAVED_VALUE);
        assertEquals(item.getPrevious().getPrevious().getValue(), EXPECTED_FIRST_SAVED_VALUE);
        assertEquals(item.getPrevious().getNext().getPrevious().getValue(), EXPECTED_SECOND_SAVED_VALUE);

        // check circularity of the list from right to left
        assertEquals(item.getValue(), item.getPrevious().getPrevious().getPrevious().getValue());

        // check circularity of the list from left to right
        assertEquals(item.getValue(), item.getNext().getNext().getNext().getValue());
    }

    @Test
    void create_new_empty_list() {
        memoryMediator.cleanCircularList();
        assertFalse(ACTUAL_EMBEDDED_VALUE_TO_TEST.containsValue(EXPECTED_FIRST_SAVED_VALUE));
    }

    @Test
    void retrieve_from_null_file() {
        try {
            assertEquals(memoryMediator.getNavigationListService().getLength(), 3);
            memoryMediator.retrieveCircularList(null);
            assertEquals(memoryMediator.getNavigationListService().getLength(), 0);
        } catch (IOException e) {
            Assertions.fail("IOException");
        } catch (UnexpectedExpressionException e) {
            Assertions.fail("UnexpectedExpressionException");
        }

    }

}