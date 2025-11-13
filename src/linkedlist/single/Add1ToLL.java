package src.linkedlist.single;

public class Add1ToLL {
    static class Node{
        Node next;
        int data;
        Node(int data,Node next){
            this.next = next;
            this.data = data;

        }

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node front = curr.next;
            curr.next= prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }


    static Node add1ToLL(Node head){
        if(head==null) return null;

        head = reverse(head);
        Node curr = head;
        int carry =1;

        while(curr!=null && carry>0){
            int sum = curr.data+carry;
            curr.data = sum%10;
            carry = sum/10;

            if(curr.next==null && carry>0){
                curr.next = new Node(carry);
                carry=0;
            }
            curr = curr.next;
        }

        head = reverse(head);
        return head;
    }

    static int addOneUtil(Node node){
        if(node==null) return 1;

        int carry = addOneUtil(node.next);
        int sum = carry + node.data;
        node.data = sum%10;
        return sum/10;

    }

    static Node addOne(Node head){
        int carry = addOneUtil(head);
        if(carry!=0){
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }


    static void main() {
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(9);

        System.out.print("Original Linked List: ");

        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }

        Node newHead = add1ToLL(head);
        System.out.println("\nLinked List after adding 1: ");
        while(newHead!=null){
            System.out.print(newHead.data+" ");
            newHead=newHead.next;
        }
    }
}
