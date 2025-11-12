package src.linkedlist.single;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoopLL {
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int lengthOfLoopBrute(Node head){
        Map<Node,Integer> visited = new HashMap<>();
        int timer = 0;

        Node temp = head;
        while(temp!=null){
            if(visited.containsKey(temp)) {
                int loopLength = timer-visited.get(temp);
                return loopLength;
            }
            visited.put(temp,timer);
            temp = temp.next;
            timer++;
        }
        return 0;

    }


    static int lengthOfLoopOptimal(Node head){
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // cycle detected
                return countLoopLength(slow);
                   // starting point
            }
        }

        return 0;
    }

    static int countLoopLength(Node slow){
        int length=1;
        Node temp = slow;
        while(temp.next!=slow){
            temp = temp.next;
            length++;
        }
        return length;
    }

    static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth= new Node(4);
        Node fifth= new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third;

        System.out.println(lengthOfLoopOptimal(head));
        System.out.println(lengthOfLoopBrute(head));

    }
}
