package src.linkedlist.hard;

public class RotateLL {

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


    static Node rotateRight(Node head,int k){
        if(head==null || head.next==null) return head;
        for(int i=0;i<k;i++){
            Node temp = head;
            while(temp.next.next!=null) temp = temp.next;
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head= end;
        }
        return head;
    }

    static Node rotateRightOptimal(Node head,int k){
        if(head==null|| head.next==null ||k==0) return head;
        Node temp = head;
        int length = 1;
        while(temp.next!=null){
            ++length;
            temp = temp.next;
        }
        temp.next = head;
        k = k%length;
        int end = length-k;
        while(end--!=0) temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;
    }

    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node newHead = rotateRightOptimal(head,2);
        while(newHead!=null){
            System.out.print(newHead.data);
            if(newHead.next!=null) System.out.print("->");
            newHead = newHead.next;
        }

    }
}
