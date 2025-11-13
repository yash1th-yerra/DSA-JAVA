package src.linkedlist.hard;

import java.util.ArrayList;
import java.util.Collections;

public class FlattenLL {

    static class Node{
        Node next;
        Node child;
        int data;
        Node(int data,Node next,Node child){
            this.data = data;
            this.next = next;
            this.child = child;
        }

        Node(int data){
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    static Node convertArrToLL(ArrayList<Integer> arr){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        for(int i=0;i<arr.size();i++){
            temp.child = new Node(arr.get(i));
            temp = temp.child;
        }
        return dummyNode.child;
    }
    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data+" ");
            if(head.child!=null) System.out.print("-> ");
            head = head.child;
        }
        System.out.println();
    }
    static void printOriginalLinkedList(Node head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            // If child exists, recursively
            // print it with indentation
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars
            // for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }


    static Node flattenListBrute(Node head){
        if(head==null || head.next==null) return head;
        ArrayList<Integer> arr = new ArrayList<>();
        while(head!=null){
            Node t2 = head;
            while(t2!=null){
                arr.add(t2.data);
                t2 = t2.child;
            }
            head = head.next;
        }
        Collections.sort(arr);

        return convertArrToLL(arr);
    }

    static Node merge(Node list1,Node list2){
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                res.child = list1;
                res = list1;
                list1 = list1.child;
            }
            else{
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        if(list1!=null){
            res.child =list1;
        }else{
            res.child = list2;
        }

        if(dummyNode.child!=null){
            dummyNode.child.next = null;
        }
        return dummyNode.child;
    }

    static Node flattenLLOptimal(Node head){
        if(head==null || head.next==null) return head;
        Node mergedHead = flattenLLOptimal(head.next);
        head = merge(head,mergedHead);
        return head;
    }



    static void main() {
        Node head = new Node(5);
        head.child = new Node(14);

        head.next = new Node(10);
        head.next.child = new Node(4);

        head.next.next = new Node(12);
        head.next.next.child = new Node(20);
        head.next.next.child.child = new Node(13);

        head.next.next.next = new Node(7);
        head.next.next.next.child = new Node(17);

        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Flatten the linked list
        // and print the flattened list
        Node flattened = flattenLLOptimal(head);
        System.out.println("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
