package src.linkedlist.doubleLL;

public class FindPairsWithGivenSum {

    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static void findPairsBrute(Node head, int k) {
        Node ptr1 = head;
        int count = 0;
        while (ptr1 != null) {
            Node ptr2 = ptr1.next;
            while (ptr2 != null) {
                if (ptr1.data + ptr2.data == k) {
                    System.out.println(ptr1.data + " " + ptr2.data);
                    count++;
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
        if (count == 0) System.out.println(0);
    }

    static void findPairsOptimal(Node head, int k) {
        if (head == null) return;
        Node left = head, right = head;
        while (right.next != null) right = right.next;
        int count = 0;
        while (left != right && left.data < right.data) {
            int sum = left.data + right.data;
            if (sum == k) {
                System.out.println(left.data + " " + right.data);
                count++;
                left = left.next;
                right = right.prev;
            } else if (sum < k) left = left.next;
            else right = right.prev;
        }
        if (count == 0) System.out.println(0);
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
        Node fourth = new Node(4);
        Node fifth = new Node(9);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;

        System.out.print("Doubly Linked List: ");
        printList(head);

        int k = 5;
        System.out.println("\nBrute Force Pairs:");
        findPairsBrute(head, k);

        System.out.println("\nOptimal Pairs:");
        findPairsOptimal(head, k);
    }
}
