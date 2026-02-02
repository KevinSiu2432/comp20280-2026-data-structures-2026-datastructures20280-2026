package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    private static class Node<E> {
        private final E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.next = trailer;
    }

    private void addBetween(E e, Node<E> pred, Node<E> succ) {
        // TODO
        // pred == one before, succ is one after.
        Node<E> newNode = new Node<E>(e,pred,succ);

        pred.next = newNode;
        succ.prev = newNode;
        size++;
    }

    @Override
    public int size() {
        // TODO
        int count = 0;

        // if head does not exist, size is 0;
        if (header.next == null){
            return 0;
        }

        //start reading at head.
        Node<E> curr = header.next;

        while (curr != trailer){
            count++;
            curr = curr.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return (header.next == trailer);
    }

    @Override
    public E get(int i) {
        // TODO
        E data;
        Node<E> curr = header.next;

        int count = 0;

        while (curr != null && count < i){
            curr = curr.next;
            count++;
        }

        data = curr.getData();
        return data;
    }

    @Override
    public void add(int i, E e) {
        // TODO

        if (i < 0 || i > size){
            throw new IllegalArgumentException("index does not exist");
        }

        if (i == 0){
            addFirst(e);
            return;
        }
        Node<E> curr = header.next;
        int count = 0;

        while (curr != trailer && count < i){
            curr = curr.next;
            count++;
        }
        //now we are on the index
        Node<E> newNode = new Node<E> (e, curr.prev, curr);
        curr.prev.next = newNode;
        curr.prev = newNode;
        size++;
    }

    @Override
    public E remove(int i) {
        // TODO

        if (i < 0 || i >= size){
            throw new IllegalArgumentException("index does not exist");
        }

        Node<E> curr = header.next;
        int count = 0;
        E data;


        while (curr != trailer && count < i){
            curr = curr.next;
            count++;
        }

        Node<E> temp = curr;

        data = temp.getData();
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;


        size--;
        return data;
    }

    private class DoublyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) header.next;

        @Override
        public boolean hasNext() {
            return curr != trailer;
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
        return new DoublyLinkedListIterator<E>();
    }

    private E remove(Node<E> n) {
        // TODO
        return null;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.next.getData();
    }

    public E last() {
        // TODO

        return get(size-1);
    }

    @Override
    public E removeFirst() {
        // TODO
        if (isEmpty()){
            throw new IllegalArgumentException("cannot remove from empty list");
        }
        Node<E> curr = header.next;
        E data = curr.getData();

        header.next = curr.next;
        curr.next.prev = header;
        size--;
        return data;
    }

    @Override
    public E removeLast() {
        // TODO
        if (isEmpty()){
            throw new IllegalArgumentException("cannot remove from an empty list");
        }
        if (size == 1){
            return removeFirst();
        }


        Node<E> end = trailer.prev;
        E data = end.getData();

        trailer.prev = end.prev;
        end.prev.next = trailer;

        size--;
        return data;
    }

    @Override
    public void addLast(E e) {
        // TODO
        Node<E> oldTail = trailer.prev;
        Node<E> newTail = new Node<E>(e,oldTail,trailer);

        trailer.prev = newTail;
        oldTail.next = newTail;
        size++;
    }

    @Override
    public void addFirst(E e) {
        // TODO
        // in an empty DLL, header.next = trailer, but this is not true
        // if the list is not empty, header.next would be the head of the current list
        // which we should change and then repoint the header sentinel.
        Node<E> oldHead = header.next;

        Node<E> newHead = new Node<E>(e, oldHead, header.next);
        header.next = newHead;
        oldHead.prev = newHead;
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = header.next;
        while (curr != trailer) {
            sb.append(curr.data);
            curr = curr.next;
            if (curr != trailer) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();


        System.out.println(ll);
        ll.addFirst(11);
        ll.addFirst(20);
        ll.addFirst(400);

        System.out.println(ll);
        System.out.println(ll.last());




        /*for (Integer e : ll) {
            System.out.println("value: " + e);
        }

         */
    }
}