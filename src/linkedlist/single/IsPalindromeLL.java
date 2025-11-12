package src.linkedlist.single;

import java.util.Stack;

public class IsPalindromeLL {

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

    static boolean isPalindromeBrute(Node head){
        Node temp = head;
        Stack<Integer> st = new Stack<>();

        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.data!=st.peek()) return false;
            st.pop();
            temp = temp.next;
        }
        return true;
    }


    static Node reverseLinkedlist(Node head){
        if(head==null || head.next==null) return head;

        Node newHead= reverseLinkedlist(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    static boolean isPalindromeOptimal(Node head){
        if(head==null || head.next== null) return true;

        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverseLinkedlist(slow.next);
        Node first = head;
        Node second = newHead;
        while(second!=null){
            if(first.data!=second.data){
                reverseLinkedlist(newHead);
                return false;
            }
            first= first.next;
            second =second.next;

        }
        reverseLinkedlist(newHead);
        return true;
    }

    static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth= new Node(2);
        Node fifth= new Node(1);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        System.out.println(isPalindromeBrute(head));




    }
}
