package src.linkedlist.single;

public class SegregateEvenOddLL {
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

    static Node segragateToOddEven(Node head){
        if(head==null || head.next==null) return head;
        Node oddHead = new Node(-1);
        Node evenHead = new Node(-1);

        Node curr=head;
        Node odd = oddHead;
        Node even = evenHead;
        int index=1;
        while(curr!=null){
            if(index%2==1){
                odd.next = curr;
                odd = odd.next;
            }else{
                even.next = curr;
                even = even.next;
            }

            curr = curr.next;
            index++;

        }

        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;

    }
    static Node segragateToOddEvenOptimal(Node head){
        if(head==null || head.next==null) return head;
        Node odd = head,even=head.next,evenHead = head.next;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead.next;
        return head;
    }

    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = segragateToOddEven(head);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
