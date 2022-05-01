package memory.service;

import memory.CircularLinkedList;
import memory.memento.ScreenMementoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class CircularLinkedListRemovingFunctionalityTest {

    private final MemoryMediator memoryMediator = new MemoryMediator();
    private final CircularLinkedListService CL_SERVICE = memoryMediator.getNavigationListService();
    private final MemoryConfiguration configuration = new MemoryConfiguration();
    private final String SELECTED_MODE = "dummy mode";

    @BeforeEach
    void setUp() {
        CL_SERVICE.clean();
    }

    @Test
    void removeElement() {

        int OPERATION_MEMORY_SIZE = 3; //CONFIGURATION
        ScreenMementoDTO ONE_FIRST_VALUE = new ScreenMementoDTO("1","1", SELECTED_MODE);
        ScreenMementoDTO SECOND_VALUE = new ScreenMementoDTO("2","2", SELECTED_MODE);
        ScreenMementoDTO THIRD_VALUE = new ScreenMementoDTO("3","3", SELECTED_MODE);
        ScreenMementoDTO LAST_VALUE = new ScreenMementoDTO("4","4", SELECTED_MODE);

        CL_SERVICE.addNode(ONE_FIRST_VALUE);
        CL_SERVICE.addNode(SECOND_VALUE);
        CL_SERVICE.addNode(THIRD_VALUE);

        CircularLinkedList current = CL_SERVICE.getCurrentPosition();
        assertEquals(current.getDTO(), THIRD_VALUE);
        assertEquals(CL_SERVICE.getLength(), OPERATION_MEMORY_SIZE);

        CL_SERVICE.removeFormerNode();
        assertEquals(current.getDTO(), THIRD_VALUE);
        CL_SERVICE.addNode(LAST_VALUE);

        assertEquals(current.getDTO(), THIRD_VALUE);
        assertEquals(CL_SERVICE.getLength(), OPERATION_MEMORY_SIZE);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head, tail.getNext());
        assertEquals(tail, head.getPrevious());

        assertEquals(head.getDTO(), SECOND_VALUE);
        assertEquals(tail.getDTO(), LAST_VALUE);

    }

    @Test
    void addExtraElement() {
        long extraElementIndex = configuration.getGetOperationMemorySize()+1;
        ScreenMementoDTO EXPECTED_HEAD_TO_BE_DELETED = new ScreenMementoDTO(valueOf(0),valueOf(0), SELECTED_MODE);
        ScreenMementoDTO EXPECTED_HEAD_AFTER_EXTRA_ADD = new ScreenMementoDTO(valueOf(1),valueOf(1), SELECTED_MODE);
        ScreenMementoDTO EXPECTED_TAIL_AFTER_EXTRA_ADD = new ScreenMementoDTO(valueOf(extraElementIndex), valueOf(extraElementIndex), SELECTED_MODE);

        for (int i=0; i < configuration.getGetOperationMemorySize(); i++)
            CL_SERVICE.addNode(new ScreenMementoDTO(valueOf(i), valueOf(i), SELECTED_MODE));

        assertEquals(CL_SERVICE.getLength(), configuration.getGetOperationMemorySize());
        assertTrue(CL_SERVICE.containsValue(EXPECTED_HEAD_TO_BE_DELETED.toString()));

        CL_SERVICE.addNode(EXPECTED_TAIL_AFTER_EXTRA_ADD);

        assertFalse(CL_SERVICE.containsValue(EXPECTED_HEAD_TO_BE_DELETED.toString()));

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getDTO().toString(), EXPECTED_HEAD_AFTER_EXTRA_ADD.toString());
        assertEquals(tail.getDTO(), EXPECTED_TAIL_AFTER_EXTRA_ADD);

    }

    @Test
    void resizeMemory() {
        long definedMemorySize = 10;
        configuration.setGetOperationMemorySize(definedMemorySize);
        long extraElementIndex = configuration.getGetOperationMemorySize()+1;
        assertEquals(extraElementIndex, definedMemorySize+1);
    }

}
