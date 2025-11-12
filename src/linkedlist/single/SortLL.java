package src.linkedlist.single;

import java.util.ArrayList;
import java.util.Collections;

public class SortLL {

    static class Node{
        int data;
        Node next;

        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node sortLLBrute(Node head){
        if(head==null || head.next==null) return head;

        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp!=null){
            arr.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(arr);

        temp=head;
        for(int i=0;i<arr.size();i++){
            temp.data = arr.get(i);
            temp = temp.next;
        }
        return head;
    }


    static Node mergeTwoSortedLinkedLists(Node list1,Node list2){
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(list1!=null && list2!=null){
            if(list1.data <=list2.data){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1!=null) {
            temp.next = list1;
        }else{
            temp.next = list2;
        }
        return dummy.next;
    }


    static Node findMiddle(Node head){
        if(head==null || head.next==null) return head;
        Node slow = head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static Node sortLLOptimal(Node head){
        if(head==null || head.next==null) return head;
        Node middle= findMiddle(head);
        Node right = middle.next;
        middle.next=null;
        Node left = head;
        left = sortLLOptimal(left);
        right = sortLLOptimal(right);
        return mergeTwoSortedLinkedLists(left,right);
    }
    static void main() {

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next=fourth;
        fourth.next=fifth;
        fifth.next=third;
        third.next = null;

        Node newHead = sortLLOptimal(head);
        while(newHead!=null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }
}
