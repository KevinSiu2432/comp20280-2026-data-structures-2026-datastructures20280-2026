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

    private  Node<E> header;
    private  Node<E> trailer;
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
        return (header.next != null);
    }

    @Override
    public E get(int i) {
        // TODO
        return null;
    }

    @Override
    public void add(int i, E e) {
        // TODO
    }

    @Override
    public E remove(int i) {
        // TODO
        return null;
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
        return null;
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

        System.out.println(ll.isEmpty());
        System.out.println(ll);
        ll.addFirst(11);
        System.out.println(ll.isEmpty());


        /*for (Integer e : ll) {
            System.out.println("value: " + e);
        }

         */
    }
}