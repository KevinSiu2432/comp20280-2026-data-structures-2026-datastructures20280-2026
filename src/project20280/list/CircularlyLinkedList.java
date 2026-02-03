package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

    private class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            data = e;
            next = n;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<E> tail = null;
    private Node<E> head = null;
    private int size = 0;


    public CircularlyLinkedList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        // TODO
        return null;
    }


    /**
     * Inserts the given element at the specified index of the list, shifting all
     * subsequent elements in the list one position further to make room.
     *
     * @param i the index at which the new element should be stored
     * @param e the new element to be stored
     */
    @Override
    public void add(int i, E e) {
        // TODO

    }

    @Override
    public E remove(int i) {
        // TODO
        return null;
    }

    public void rotate() {
        // TODO
    }

    private class CircularlyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) tail;

        @Override
        public boolean hasNext() {
            return curr != tail;
        }

        @Override
        public E next() {
            E res = curr.data;
            curr = curr.next;
            return res;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<E>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E removeFirst() {
        // TODO
        return null;
    }

    @Override
    public E removeLast() {
        // TODO
        return null;
    }

    @Override
    public void addFirst(E e) {
        // TODO
    }

    @Override
    public void addLast(E e) {
        // TODO
        // should use size == 0 check next time.
        if (head == null){
            Node<E> newNode = new Node<E>(e, null);

            newNode.next = newNode;
            head = newNode;
            tail = newNode;
            size++;
            return;
        }else {
            Node<E> newNode = new Node<E> (e, head);

            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = tail;
        do {
            curr = curr.next;
            sb.append(curr.data);
            if (curr != tail) {
                sb.append(", ");
            }
        } while (curr != tail);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();

        ll.addLast(10);
        System.out.println(ll);
        ll.addLast(1000);
        System.out.println(ll);
    }
}
