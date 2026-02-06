package project20280.stacksqueues;

import project20280.interfaces.Stack;
import project20280.list.DoublyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    DoublyLinkedList<E> ll;

    public LinkedStack() {
        // TODO
        ll = new DoublyLinkedList<>();
    }
    public static void main(String[] args) {

        long n = 23;
        String s = convertToBinary(n);
        System.out.println(s);
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
        return ll.get(0);
    }

    @Override
    public E pop() {
        // TODO
        return ll.removeFirst();
    }
    /*
    push adds to the front, while remove adds from the end, even if it's a stack so that the
     */

    static String convertToBinary (long dec_num){
        Stack<Long> stack = new LinkedStack<>();

        while (dec_num > 0){
            stack.push(dec_num % 2);
            dec_num = dec_num / 2;
        }

        return stack.toString();
    }


    public String toString() {
        return ll.toString();
    }
}
