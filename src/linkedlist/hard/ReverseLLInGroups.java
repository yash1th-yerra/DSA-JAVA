package src.linkedlist.hard;

public class ReverseLLInGroups {
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


    static Node reverseLinkedList(Node head){
        if(head==null || head.next==null) return head;
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


    static Node getKNode(Node temp,int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }


    static Node kReverse(Node head,int k){
        Node temp = head;
        Node prevLast = null;
        while(temp!=null){
            Node kthNode = getKNode(temp,k);
            if(kthNode==null){
                if(prevLast!=null){
                    prevLast.next =temp;
                }
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);
            if(temp==head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void main() {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = kReverse(head, 2);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }


}
