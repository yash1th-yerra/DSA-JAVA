package src.linkedlist.single;

public class Add2NumbersinLL {
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


    static Node addTwoNumbers(Node l1,Node l2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry==1){
            int sum = 0;
            if(l1!=null){
                sum+=l1.data;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            Node node = new Node(sum%10);
            temp.next = node;
            temp = temp.next;

        }
        return dummy.next;
    }


    static void main() {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        Node l1dummy = l1;
        Node l2dummy = l2;
        System.out.print("First number : ");
        while(l1dummy!=null){
            System.out.print(l1dummy.data+" ");
            l1dummy = l1dummy.next;
        }
        System.out.print("Second number: ");
        while(l2dummy!=null){
            System.out.print(l2dummy.data+" ");
            l2dummy = l2dummy.next;
        }
        System.out.println();
        Node result = addTwoNumbers(l1, l2);

        System.out.print("Sum          : ");
        while(result!=null){
            System.out.print(result.data+" ");
            result = result.next;
        }

    }
}
