package memory.service;

import memory.CircularLinkedList;
import memory.memento.ScreenMementoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A circular list service
 * accessed by CircularListFacade implementation, eventually (package scope)
 * provide some high level functionalities over circular linked node's list
 */
public class CircularLinkedListService {

    private final MemoryConfiguration configuration = new MemoryConfiguration();
    private static CircularLinkedList head;
    private static CircularLinkedList current;
    private static CircularLinkedList tail;
    private static int length;

    /**
     * Access point to the current position linked nodes list
     * @return CircularLinkedList
     */
    public CircularLinkedList getCurrentPosition() {
        return current;
    }

    /**
     * Move the current linked list's position to the previous element
     */
    public CircularLinkedList navigateLeft() {
        if (current != null)
            current = current.getPrevious();
        return current;
    }

    /**
     * Move the current linked list's position to the next element
     */
    public CircularLinkedList navigateRight() {
        if (current != null)
            current = current.getNext();
        return current;
    }

    /**
     * Move the current linked list's position to the last element
     */
    public CircularLinkedList navigateLast() {
        if (head != null) current = head;
        return current;
    }

    /**
     * Move the current linked list's position to the first element
     */
    public CircularLinkedList navigateFirst() {
        if (tail != null) current = tail;
        return current;
    }

    public long getMemorySize() {
        return configuration.getGetOperationMemorySize();
    }

    public void setMemorySize(long val) {
        this.configuration.setGetOperationMemorySize(val);
    }

    void addNode(ScreenMementoDTO value) {
        if (value == null) return;
        if (value.getExpression() == null || value.getResult() == null || value.getMode() == null) return;
        CircularLinkedList newNode;

        if (head == null) {
            newNode = new CircularLinkedList(value, 1);
            head = newNode;
        } else {
            if (length == configuration.getGetOperationMemorySize())
                removeFormerNode();
            else if (length > configuration.getGetOperationMemorySize())
                shrinkCircularList();

            newNode = new CircularLinkedList(value, tail.getIndex()+1);
            head.setPrevious(newNode);
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }

        tail = newNode;
        tail.setNext(head);
        current = tail;
        length += 1;
    }

    private void shrinkCircularList() {
        CircularLinkedList item = tail.clone();
        for (int i=0; i<length+1; i++)
            item = item.getPrevious();
        head = item;
    }

    void removeFormerNode() {
        CircularLinkedList newHead = head.getNext();
        newHead.setPrevious(tail);
        tail.setNext(newHead);
        head = newHead;
        length -= 1;
    }

    boolean containsValue(String value) {
        if (head == null) return false;
        else return search(value, head);
    }

    void clean() {
        length = 0;
        head = null;
        tail = null;
        current = null;
    }

    int getLength() {
        return length;
    }

    CircularLinkedList getTail() {
        return tail;
    }

    CircularLinkedList getHead() {
        return head;
    }

    public List<ScreenMementoDTO> getItems() {
        List<ScreenMementoDTO> items = new ArrayList<>();
        CircularLinkedList item = head.clone();
        items.add(item.getDTO());
        while (item.getIndex() != tail.getIndex()) {
            item = item.getNext();
            items.add(item.getDTO());
        }
        return items;
    }

    private boolean search(String value, CircularLinkedList nodeCursor) {
        do {
            if (nodeCursor.getValue().equals(value))
                return true;

            nodeCursor = nodeCursor.getNext();
        } while (nodeCursor != head);

        return false;
    }
}
