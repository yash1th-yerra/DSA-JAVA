package src.linkedlist.single;

import java.util.HashSet;

public class IntersectionPointLL {


    static class Node{
        Node next;
        int data;

        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    static Node intersectionPointBrute(Node head1,Node head2){
        while(head2!=null){
            Node temp = head1;
            while(temp!=null){
                if(temp==head2) return head2;
                temp= temp.next;
            }
            head2 =head2.next;
        }
        return null;
    }

    static Node intersectionPointHashing(Node head1,Node head2){
        HashSet<Node> st = new HashSet<>();
        while(head1!=null){
            st.add(head1);
            head1 = head1.next;
        }

        while(head2!=null){
            if(st.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }

    static int getDiffInLength(Node head1,Node head2){
        int len1=0,len2=0;
        while(head1!=null || head2!=null){
            if(head1!=null){
                len1++;
                head1= head1.next;
            }
            if(head2!=null){
                len2++;
                head2 = head2.next;
            }

        }
        return len1-len2;
    }

    static Node intersectionPointByLengths(Node head1,Node head2){
        if(head1==null || head2==null) return null;
        int diff = getDiffInLength(head1,head2);
        if(diff<0){
            while(diff++!=0) head2 = head2.next;
        }
        else while(diff--!=0) head1 = head1.next;
        while(head1!=null){
            if(head1==head2) return head1;
            head1=head1.next;
            head2 = head2.next;
        }
        return null;
    }

    static Node intersectionByLengthOptimal(Node head1 , Node head2){
        if(head1==null || head2==null) return null;
        Node d1 = head1;
        Node d2 = head2;
        while(d1!=d2){
            d1= d1==null?head2:d1.next;
            d2 = d2==null?head1:d2.next;
        }
        return d1;
    }


    static void main() {
        Node head1 = new Node(1);
        Node second1 = new Node(2);
        Node third1 = new Node(3);

        Node head2 = new Node(4);
        Node second2 = new Node(5);

        Node common1 = new Node(6);
        Node common2 = new Node(7);

        // Connect list 1
        head1.next = second1;
        second1.next = third1;
        third1.next = common1;

        // Connect list 2
        head2.next = second2;
        second2.next = common1;

        // Continue the common part
        common1.next = common2;

        // Call the intersection function
        Node intersection = intersectionByLengthOptimal(head1, head2);

        if (intersection != null) {
            System.out.println("Intersection point data: " + intersection.data);
        } else {
            System.out.println("No intersection found.");
        }
    }


}
