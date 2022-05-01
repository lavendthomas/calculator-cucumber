package memory;

import memory.memento.ScreenMementoDTO;

/**
 * A double linked list implementation with index and value
 */
public class CircularLinkedList implements Cloneable {

    private final ScreenMementoDTO nodeValue;
    private final int index;
    private CircularLinkedList next;
    private CircularLinkedList previous;

    public CircularLinkedList(ScreenMementoDTO value, int index) {
        this.nodeValue = value;
        this.index = index;
    }

    public void setNext(CircularLinkedList node) {
        this.next = node;
    }

    public void setPrevious(CircularLinkedList previous) {
        this.previous = previous;
    }

    public CircularLinkedList getNext() {
        return next;
    }

    public CircularLinkedList getPrevious() {
        return previous;
    }

    public String getValue() {
        return nodeValue.toString();
    }

    public ScreenMementoDTO getDTO() {
        return nodeValue;
    }

    public int getIndex() { return index; }

    @Override
    public CircularLinkedList clone() {
        try {
            return (CircularLinkedList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
