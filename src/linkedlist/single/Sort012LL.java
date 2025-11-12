package src.linkedlist.single;

public class Sort012LL {

    static class Node{
        int data;
        Node next;

        Node(int data ,Node next){
            this.data= data;
            this.next = next;
        }

        Node(int data){
            this.data = data;
            this.next= null;
        }
    }

    static Node sortZeroOneTwo(Node head){
        if(head==null || head.next==null) return head;

        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        Node zero = zeroDummy;
        Node one = oneDummy;
        Node two = twoDummy;

        Node curr = head;

        while(curr!=null){
            if(curr.data==0){
                zero.next = curr;
                zero = zero.next;
            }else if(curr.data==1){
                one.next = curr;
                one = one.next;
            }else{
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        zero.next = (oneDummy.next!=null)? oneDummy.next:twoDummy.next;
        one.next = twoDummy.next;
        twoDummy.next = null;

        return zeroDummy.next;

    }
    static void main() {
        Node head = new Node(1);
        Node second = new Node(2);
//        Node third = new Node(0);
        Node fourth = new Node(1);
//        Node fifth = new Node(0);
        Node sixth = new Node(2);

        head.next = second;
        second.next = fourth;
        fourth.next = sixth;
//        second.next=third;
//        third.next = fourth;
//        fourth.next=fifth;
//        fifth.next=sixth;
        sixth.next = null;

        Node newHead = sortZeroOneTwo(head);
        while(newHead!=null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }

    }
}
