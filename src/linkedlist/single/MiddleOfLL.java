package src.linkedlist.single;

public class MiddleOfLL {
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
    static Node findMiddleBrute(Node head){
        if(head==null || head.next==null) return head;

        Node temp = head;
        int count=0;

        while(temp!=null){
            count++;
            temp = temp.next;
        }

        int mid = count/2 +1;
        temp = head;

        while(temp!=null){
            mid = mid-1;
            if(mid==0) break;
            temp = temp.next;
        }
        return temp;
    }


    static Node findMiddleOptimal(Node head){
        Node slow = head,fast = head;
        while(fast!=null && fast.next!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

//        Node middleNode = findMiddleBrute(head);
        Node middleNode = findMiddleOptimal(head);



        System.out.println(middleNode.data);

    }
}
