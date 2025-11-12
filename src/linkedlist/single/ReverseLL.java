package src.linkedlist.single;

import java.util.Stack;

public class ReverseLL {

    static class Node{
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


    static Node reverseLLBrute(Node head){
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp!=null){
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while(!stack.isEmpty()){
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;

    }

    static Node reverserLLOptimal(Node head){
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;

        }

        return prev;
    }
    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

//        Node middleNode = findMiddleBrute(head);
//        Node resultNode = reverseLLBrute(head);

        Node resultNode = reverserLLOptimal(head);

        while(resultNode!=null){

            System.out.println(resultNode.data);
            resultNode = resultNode.next;
        }


    }



}
