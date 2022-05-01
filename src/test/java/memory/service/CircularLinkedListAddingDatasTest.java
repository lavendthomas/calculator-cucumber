package memory.service;

import memory.CircularLinkedList;
import memory.memento.ScreenMementoDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CircularLinkedListAddingDatasTest {

    private final MemoryMediator memoryMediator = new MemoryMediator();
    private final CircularLinkedListService CL_SERVICE = memoryMediator.getNavigationListService();
    private final String SELECTED_MODE = "dummy mode";
    private final ScreenMementoDTO ONE_FIRST_VALUE = new ScreenMementoDTO("1","1", SELECTED_MODE);
    private final ScreenMementoDTO SECOND_VALUE = new ScreenMementoDTO("2","2", SELECTED_MODE);
    private final ScreenMementoDTO THIRD_VALUE = new ScreenMementoDTO("3","3", SELECTED_MODE);

    @Test
    @Order(1)
    void setUp() {
        memoryMediator.cleanCircularList();
    }

    @Test
    @Order(2)
    public void add_first_node() {
        assertEquals(CL_SERVICE.getLength(), 0);
        memoryMediator.addItem(ONE_FIRST_VALUE);
        assertEquals(CL_SERVICE.getLength(), 1);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), head.getNext().getValue(), tail.getValue());
        assertEquals(head.getIndex(), valueOf(ONE_FIRST_VALUE.getResult()));

    }

    @Test
    @Order(3)
    public void add_second_node() {
        assertEquals(CL_SERVICE.getLength(), 1);
        memoryMediator.addItem(SECOND_VALUE);
        assertEquals(CL_SERVICE.getLength(), 2);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), tail.getNext().getValue(), ONE_FIRST_VALUE.toString());
        assertEquals(tail.getValue(), head.getNext().getValue(), SECOND_VALUE.toString());
        assertEquals(tail.getIndex(), valueOf(SECOND_VALUE.getResult()));

    }

    @Test
    @Order(4)
    public void add_third_node() {
        assertEquals(CL_SERVICE.getLength(), 2);
        memoryMediator.addItem(THIRD_VALUE);
        assertEquals(CL_SERVICE.getLength(), 3);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), ONE_FIRST_VALUE.toString());
        assertEquals(tail.getValue(), THIRD_VALUE.toString());
        assertEquals(tail.getIndex(), valueOf(THIRD_VALUE.getResult()));
        assertEquals(tail.getPrevious().getValue(), SECOND_VALUE.toString());
        assertEquals(head.getNext().getValue(), SECOND_VALUE.toString());

    }

    @Test
    @Order(5)
    public void add_last_node() {
        ScreenMementoDTO LAST_VALUE = new ScreenMementoDTO("4","4", SELECTED_MODE);
        assertEquals(CL_SERVICE.getLength(), 3);
        memoryMediator.addItem(LAST_VALUE);
        assertEquals(CL_SERVICE.getLength(), 4);

        CircularLinkedList head = CL_SERVICE.getHead();
        CircularLinkedList tail = CL_SERVICE.getTail();

        assertEquals(head.getValue(), ONE_FIRST_VALUE.toString());
        assertEquals(tail.getValue(), LAST_VALUE.toString());
        assertEquals(tail.getPrevious().getValue(), THIRD_VALUE.toString());
        assertEquals(head.getNext().getValue(), SECOND_VALUE.toString());

    }

}