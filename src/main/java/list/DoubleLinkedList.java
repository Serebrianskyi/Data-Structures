package list;

public class DoubleLinkedList implements MyList {

    private DoubleNode node;

    public DoubleLinkedList(DoubleNode node) {
        this.node = node;
    }

    public DoubleLinkedList() {
    }

    public int size() {
        int size = 0;
        DoubleNode pointer = node;

        if (pointer != null) {
            size = 1;
        } else {
            return 0;
        }
        while (pointer.getNext() != null) {
            size++;
            pointer = pointer.getNext();
        }
        return size;
    }

    public void add(Object item) {
        DoubleNode temp = (DoubleNode) item;
        if (node == null) {
            node = new DoubleNode(item);
        } else {
            temp.setNext(node);
            temp.setPrev(node.getPrev());
            node.setPrev(temp);
            node = temp;
        }

    }

    public DoubleNode get(int index) {
        DoubleNode pointer = node;
        int count = 0;
        if (size() - 1 < index) {
            return null;
        } else if (size() == index) {
            return null;
        }
        while (pointer.getNext() != null) {

            if (count == index) {
                return pointer;
            }
            count++;
            pointer = pointer.getNext();
        }
        return pointer;
    }

    public DoubleNode remove(int index) {
        DoubleNode pointer = node;
        if (get(index) != null) {
            if (index == 0) {
                pointer = pointer.getNext();
                pointer.setPrev(null);
                node = pointer;
            } else if (index == size() - 1) {
                pointer = node.getPrev();
                pointer.setNext(null);
                node = pointer;
            } else {
                pointer = get(index);
                DoubleNode tempPrev = pointer.getPrev();
                DoubleNode tempNext = pointer.getNext();
                tempPrev.setNext(tempNext);
                tempNext.setPrev(tempPrev);
            }
        }
        return pointer;
    }

    public void clear() {
        node = null;
    }


    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setPrev(node2);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(node1);
        System.out.println(doubleLinkedList.size());
        System.out.println(doubleLinkedList.get(0).getValue());
        System.out.println(doubleLinkedList.get(1).getValue());
        System.out.println(doubleLinkedList.get(2).getValue());
        doubleLinkedList.remove(3);
        System.out.println();
        System.out.println(doubleLinkedList.get(0).getValue());
        System.out.println(doubleLinkedList.get(1).getValue());
        doubleLinkedList.clear();
        doubleLinkedList.add(node1);
        System.out.println(doubleLinkedList.get(0).getValue());


    }


}
