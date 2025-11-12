package src.linkedlist.single;

import java.util.HashMap;
import java.util.Map;

public class DetectLoopInLL {

    static class Node  {
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }


    }

    static boolean isLoop(Node head){
        Map<Node,Integer> visited = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            if(visited.containsKey(temp)) return true;
            visited.put(temp,1);
            temp = temp.next;
        }
        return false;


    }

    static boolean isLoopOptimal(Node head){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) return true;
        }
        return false;

    }



    static void main() {
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

        if(isLoopOptimal(head)) System.out.println("loop detected");
        else System.out.println("loop doesn't exists");

    }
}
