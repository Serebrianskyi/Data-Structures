package list;

import java.util.Objects;

public class DoubleNode<T> {
    private T value;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(T value, DoubleNode next, DoubleNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode(T value) {
        this.value = value;
        next = null;
        prev = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DoubleNode)) {
            return false;
        }
        DoubleNode<?> that = (DoubleNode<?>) o;
        return Objects.equals(value, that.value) &&
            Objects.equals(next, that.next) &&
            Objects.equals(prev, that.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next, prev);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
}
