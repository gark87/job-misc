package com.moon.linked_list;

/**
 * Immutable singly linked list implementation.
 *
 * @author John Doe The Programmer
 */
public class SinglyLinkedList<T> {
    private final T data;
    private SinglyLinkedList<T> next;

    public SinglyLinkedList(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public SinglyLinkedList<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedList<T> next) {
        this.next = next;
    }
}
