package src.linkedlist.doubleLL;

public class DeleteAllOccurencesOfKey {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node deleteAllOccurences(Node head,int k){
        if(head==null) return null;
        Node temp = head;
        while(temp!=null) {
            if(temp.data==k){
                if(temp==head){
                    head = head.next;
                    if(head!=null) head.prev= null;
                }else{
                    temp.prev.next = temp.next;
                    if(temp.next!=null){
                        temp.next.prev = temp.prev;
                    }
                }
            }
            temp = temp.next;
        }

        return head;
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }
    static void main() {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node fifth = new Node(4);
        Node sixth = new Node(2);
        Node seventh = new Node(5);

        head.next = second;

        second.prev = head;
        second.next = third;

        third.prev = second;
        third.next = fourth;

        fourth.prev = third;
        fourth.next = fifth;

        fifth.prev = fourth;
        fifth.next = sixth;

        sixth.prev = fifth;
        sixth.next = seventh;

        seventh.prev = sixth;

        System.out.print("Original list: ");
        printList(head);

        int k = 2;
        head = deleteAllOccurences(head, k);

        System.out.print("\nList after deleting all " + k + "s: ");
        printList(head);
    }
}
