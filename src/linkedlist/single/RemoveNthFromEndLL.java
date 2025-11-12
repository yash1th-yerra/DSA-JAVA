package src.linkedlist.single;

import java.util.Arrays;
import java.util.List;

public class RemoveNthFromEndLL {
    static class Node {
        int data;
        Node next;

        // Constructor for Node with data and next node
        Node(int data1, Node next1) {
            data = data1;
            next = next1;
        }

        // Constructor for Node with only data (next = null)
        Node(int data1) {
            data = data1;
            next = null;
        }
    }
    static Node deleteNthFromEnd(Node head,int N){
        if(head==null ) return null;

        int cnt =0;
        Node temp = head;
        while(temp!=null) {
            cnt++;
            temp = temp.next;
        }

        if(cnt==N) return head.next;
        int res = cnt-N;
        temp = head;
        for(int i=1;i<res;i++){
            temp = temp.next;
        }
        temp.next= temp.next.next;
        return head;
    }
    static Node deleteNthFromEndOptimal(Node head,int N){
        if(head==null) return null;

        Node fast=head,slow= head;
        for(int i=0;i<=N;i++) fast = fast.next;

        while(fast!=null ){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
    static void main() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        // Create linked list manually
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));


        head = deleteNthFromEndOptimal(head, N);

        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
