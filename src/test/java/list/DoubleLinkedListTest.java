package list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleLinkedListTest {

    @Test
    public void size() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setPrev(node2);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(node1);
        int expectedSize = 3;
        int actualSize = doubleLinkedList.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void EmptyListSize() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        int expectedSize = 0;
        int actualSize = doubleLinkedList.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void add() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setPrev(node2);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(node1);
        doubleLinkedList.add(node4);
        int expectedSize = 4;
        int actualSize = doubleLinkedList.size();
        assertEquals(expectedSize, actualSize);

    }

    @Test
    public void get() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);

        node1.setNext(node2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setPrev(node2);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(node1);
        DoubleNode expected = node2;
        DoubleNode actual = doubleLinkedList.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);

        node1.setNext(node2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setPrev(node2);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(node1);

        DoubleNode expectedNext = doubleLinkedList.get(1).getNext();
        doubleLinkedList.remove(1);
        assertEquals(expectedNext,node3);
    }

    @Test
    public void clear() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);

        node1.setNext(node2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setPrev(node2);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(node1);
        doubleLinkedList.clear();
        int actualSize = doubleLinkedList.size();
        int expectedSize = 0;


        assertEquals(expectedSize,actualSize);
    }
}
