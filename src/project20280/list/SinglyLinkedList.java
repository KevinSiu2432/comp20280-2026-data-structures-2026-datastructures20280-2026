package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

    private static class Node<E> {

        private final E element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;         // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            // TODO
            this.element = e;
            this.next = n;
        }

        // Accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            // TODO
            return next;
        }

        // Modifier methods

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            // TODO
            next = n;
        }
    } //----------- end of nested Node class -----------

    /**
     * The head node of the list
     */
    private Node<E> head = null;               // head node of the list (or null if empty)


    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    public SinglyLinkedList() {
    }              // constructs an initially empty list

    //@Override
    public int size() {
        // TODO
        if (head == null){
            return 0;
        }

        Node<E> curr = head;
        int count = 0;

        while (curr != null){
            curr = curr.next;
            count++;
        }
        return count;
    }

    //@Override
    public boolean isEmpty() {
        // TODO

        return (head == null);
    }

    @Override
    public E get(int position) {
        // TODO

        if (head == null){
            throw new IllegalArgumentException("LL is empty");
        }
        if (position > size){
            throw new IllegalArgumentException("Position not in LL");
        }

        int count = 0;
        Node<E> curr = head;

        while (curr != null && count < position){
            curr = curr.next;
            count++;
        }

        return curr.getElement();
    }

    @Override
    public void add(int position, E e) {
        // TODO
        if (position == 0){
            addFirst(e);
        }

        if (position > size){
            throw new IllegalArgumentException("Position does not exist");
        }

        Node<E> curr = head;
        Node<E> prev = null;

        int count =0;

        while (curr != null && count < position){
            prev = curr;
            curr = curr.next;
            count++;
        }

        prev.next = new Node<E>(e,curr);
        size++;
    }


    @Override
    public void addFirst(E e) {
        // TODO

        head = new Node<>(e, head);
        size++;
    }

    @Override
    public void addLast(E e) {
        // TODO
        Node<E> curr = head;
        while (curr.next != null){
            curr = curr.next;
        }

        curr.next = new Node<E>(e, null);
        size++;
    }

    @Override
    public E remove(int position) {
        // TODO
        if (position == 0){
            removeFirst();
        }
        if (position < 0 && position > size){
            throw new IllegalArgumentException("index does not exist");
        }
        if (head == null){
            throw new IllegalArgumentException("Nothing in the list to remove");
        }

        Node<E> curr = head;
        Node<E> prev = null;
        int count =0;

        while (curr != null && count < position){
            prev = curr;
            curr = curr.next;
            count++;
        }
        E data = curr.getElement();
        prev.next = curr.next;
        curr.next = null;

        size--;
        return data;
    }

    @Override
    public E removeFirst() {
        // TODO

        if (head == null){
            throw new IllegalArgumentException("Nothing in the list to remove");
        }

        E data = head.getElement();
        head = head.next;

        size--;
        return data;
    }

    @Override
    public E removeLast() {
        // TODO
        if (head == null){
            throw new IllegalArgumentException("Nothing in the list to remove");
        }
        Node<E> curr = head;
        Node<E> prev = null;

        while (curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        E data = curr.getElement();
        prev.next = null;

        size--;
        return data;
    }

    //@Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E res = curr.getElement();
            curr = curr.next;
            return res;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.getElement());
            if (curr.getNext() != null)
                sb.append(", ");
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
        System.out.println("ll " + ll + " isEmpty: " + ll.isEmpty());

        //LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(10);
        ll.addFirst(0);
        ll.addFirst(5);

        System.out.println(ll);
        ll.add(3,100);
        System.out.println(ll);
        System.out.println(ll.remove(2));
        System.out.println(ll);







    }
}
