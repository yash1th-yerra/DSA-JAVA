package src.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto the stack
    void push(int x) {
        // Push the element into q2
        q2.add(x);

        // Push all elements of q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop the top element from the stack
    int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.poll();
    }

    // Peek the top element from the stack
    int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    // Check if the stack is empty
    boolean isEmpty() {
        return q1.isEmpty();
    }
}
class Main3{
    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
    }

}
