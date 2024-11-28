package src.linkedlist.single;

// creating a linked list using node
class Node{
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

// this code consists
/*
*   1. converting array into linked list
*   2. finding length of linked list
*   3. searching a key in linked list
*   4. deletion at start,end,specific location and specific value.
*   5. insertion at start,end,specific location and specific value.
*
*
*
*
* */
public class CreateSingleLinkedList {

    // Convert Array to LinkedList
    public static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node curr = head ;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            curr.next = temp;
            curr = temp;
        }
        return head;
    }


    // Length of LinkedList
    public static int lengthOfLinkedList(Node head){
        int cnt=0;
        Node curr= head;
        while(curr!=null){
            curr = curr.next;
            cnt++;

        }
        return cnt;
    }

    // Search in LinkedList
    public static boolean searchInLinkedList(Node head,int k){
        Node curr  = head;
        while(curr!=null){
            if(curr.data==k){
                return true;
            }
            curr = curr.next;
        }
        return false;

    }

    // Print LinkedList
    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println("");
    }


    // Delete node at head of LinkedList
    public static Node removeAtHead(Node head){
        if(head ==null) return head;
        head = head.next;
        return  head;
    }


    // Delete node at tail of LinkedList

    public static Node removeAtTail(Node head){
        if(head ==null || head.next ==null ) return head;
        Node curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }


    //Delete kth node in LinkedList
    public static Node removeAtK(Node head,int k){
        int cnt = 0;
        if(head ==null) return head;
        if(k==1) {
            head = head.next;
            return head;
        }
        Node curr = head;
        Node prev= null;
        while(curr!=null){
            cnt++;
            if(cnt==k){
                prev.next = prev.next.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    //Delete a node with value x in LinkedList
    public static Node removeValue(Node head,int x){
        if(head ==null) return head;
        if(head.data == x){
            head = head.next;
            return head;
        }
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            if(curr.data==x){
                prev.next = prev.next.next;
                break;
            }
            prev = curr;
            curr= curr.next;
        }
        return head;
    }

    //Insert at head of LinkedList
    public static Node insertAtHead(Node head,int data){
//        Node n = new Node(data);
//        if(head ==null){
//            return n;
//        }
//        n.next = head;
//        head = n;

        //or

        return new Node(data,head);

    }


    //Insert at end of LinkedList
    public static Node insertAtEnd(Node head,int data){
        if(head==null){
            return new Node(data);
        }
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        Node n = new Node(data);
        curr.next = n;
        return head;


    }

    //Insert node before a value k in LinkedList
    public static Node insertBeforeK(Node head,int data,int k){
        if(head ==null) {
            if(k==1){
                return new Node(data);
            }else{
                return head;
            }
        }
        if(k==1){
            return new Node(data,head);
        }
        Node curr = head;
        int cnt =0;
        while(curr.next!=null){
            cnt++;
            if(cnt==k-1){
                Node n = new Node(data,curr.next);
                curr.next = n;
                break;
            }
            curr = curr.next;
        }
        return head;

    }

    public static void main(String[] args) {
        int[] arr  ={1,2,3,4,5};

        Node head = convertArr2LL(arr);
//        int length = lengthOfLinkedList(head);
//        System.out.println(length);
//        boolean present = searchInLinkedList(head,3);
//        System.out.println("Search key is "+(present?"found":"not found"));
//        Node head2 = removeAtHead(head);
//        Node head2 = removeAtTail(head);
//        Node head2 = removeAtK(head,2);
//        Node head2 = removeValue(head,4);
//        Node head2 = insertAtHead(head,90);
//        Node head2 = insertAtEnd(head,89);
//        Node head2 = insertBeforeK(head,23,5);



        print(head);







    }



}
