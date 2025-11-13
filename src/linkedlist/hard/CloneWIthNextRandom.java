package src.linkedlist.hard;

import java.util.HashMap;

public class CloneWIthNextRandom {

    static class Node{
        Node next;
        Node random;
        int data;
        Node(int data,Node next,Node random){
            this.data = data;
            this.next = next;
            this.random = random;
        }

        Node(int data){
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }


    static Node cloneLL(Node head){
        if(head == null) return head;
        Node temp = head;
        HashMap<Node,Node> map= new HashMap<>();

        while(temp!=null){
            Node newNode = new Node(temp.data);
            map.put(temp,newNode);
            temp = temp.next;
        }

        temp= head;
        while(temp!=null){
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }



    //Optimal
    static void insertCopyInBetween(Node head){
        Node temp = head;
        while(temp!=null){
            Node nextElement = temp.next;
            Node copyNode = new Node(temp.data);
            copyNode.next = nextElement;
            temp.next = copyNode;
            temp = nextElement;
        }
    }

    static void connectRandomPointers(Node head){
        Node temp = head;
        while(temp!=null){
            Node copyNode = temp.next;
            if(temp.random!=null){
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random =null;
            }
            temp = temp.next.next;
        }
    }

    static Node getDeepCopyList(Node head){
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(temp!=null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp= temp.next;
        }

        return dummyNode.next;
    }

    static Node cloneLLOptimal(Node head){
        if(head==null) return head;
         insertCopyInBetween(head);
         connectRandomPointers(head);
         return getDeepCopyList(head);
    }




    // Function to print the cloned linked list
    public static void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: nullptr");
            }
            System.out.println();
            // Move to the next node in the list
            head = head.next;
        }
    }

    static void main() {
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        // Clone the linked list
        Node clonedList = cloneLLOptimal(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
    }
}
