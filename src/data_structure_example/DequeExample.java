package data_structure_example;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        System.out.println(deque); // [3, 1, 2]
        deque.removeLast();
        System.out.println(deque); // [3, 1]
        deque.removeFirst();
        System.out.println(deque); // [1]
    }
}
