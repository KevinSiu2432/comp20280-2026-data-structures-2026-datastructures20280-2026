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
        if (head == null){
            throw new IllegalArgumentException("cannot get from an empty list");
        }

        if (i < 0 || i >= size){
            throw new IllegalArgumentException("index does not exist");
        }

        int count = 0;
        Node<E> curr = head;

        while (count < i){
            curr = curr.next;
            count++;
        }


        return curr.getData();
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
        if (i == 0){
            addFirst(e);
            return;
        }
        if (i == size){
            addLast(e);
            return;
        }

        Node<E> curr = head;
        Node<E> prev = null;
        int count = 0;

        while (count < i){
            prev = curr;
            curr = curr.next;
            count++;
        }

        prev.next = new Node<E>(e, curr);
        size++;
    }

    @Override
    public E remove(int i) {
        // TODO
        if (i == 0){
            return(removeFirst());
        }
        if (i == size -1){
            return(removeLast());
        }

        Node<E> curr = head;
        Node<E> prev = null;
        int count = 0;

        while (count < i){
            prev = curr;
            curr = curr.next;
            count++;
        }

        E data = curr.getData();
        prev.next = curr.next;
        curr.next = null;
        size--;


        return data;
    }

    public void rotate() {
        // TODO
        if (size > 1){
            throw new IllegalArgumentException("Cannot cycle 1 element");
        }
        tail = tail.next;
        head = head.next;
        return;
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
        if (head == null){
            return null;
        }

        //there is only 1 node,
        if (size == 1){

            E data = head.getData();
            head = null;
            tail = null;
            size--;

            return data;
        }

        E data = head.getData();
        head = head.next;
        tail.next = head;
        size--;

        return data;
    }

    @Override
    public E removeLast() {
        // TODO
        if (head == null){
            throw new IllegalArgumentException("cannot remove from an empty list");
        }
        if (size == 1){
            return(removeFirst());
        }

        Node<E> curr = head;
        // curr will stop before tail
        while (curr.next != tail) {
            curr = curr.next;
        }
        E data = tail.getData();

        curr.next = head;
        tail = curr;
        size--;
        return data;
    }

    @Override
    public void addFirst(E e) {
        // TODO
        //same as addLast logic.
        if (head == null){
            Node<E> newNode = new Node<E>(e, null);
            newNode.next = newNode;

            head = newNode;
            tail = newNode;
            size++;
            return;
        }else{
            Node<E> newNode = new Node<E>(e, head);
            head = newNode;
            tail.next = head;
            size++;
            return;
        }
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

        ll.addFirst(10);
        ll.addFirst(230);
        ll.addLast(0);
        ll.addLast(40);

        System.out.println(ll);
        System.out.println(ll.remove(2));
        System.out.println(ll);
    }
}
