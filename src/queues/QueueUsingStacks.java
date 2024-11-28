package src.queues;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue element into the queue
    void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue element from the queue
    int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            // Move all elements from s1 to s2, reversing the order
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // Peek the front element of the queue
    int peek() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            // Move all elements from s1 to s2, reversing the order
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Check if the queue is empty
    boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
