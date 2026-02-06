package project20280.stacksqueues;

import project20280.interfaces.Stack;
import project20280.list.DoublyLinkedList;
import project20280.tree.LinkedBinaryTree;

public class LinkedStack<E> implements Stack<E> {

    DoublyLinkedList<E> ll;

    public LinkedStack() {
        // TODO
        ll = new DoublyLinkedList<>();
    }
    public static void main(String[] args) {

    }


    @Override
    public int size() {
        return ll.size();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public void push(E e) {
        // TODO
        ll.addFirst(e);
    }

    @Override
    public E top() {
        // TODO
        return ll.get(size() -1);
    }

    @Override
    public E pop() {
        // TODO
        return ll.removeFirst();
    }
    /*
    push adds to the front, while remove adds from the end, even if it's a stack so that the

     */


    public String toString() {
        return ll.toString();
    }
}
