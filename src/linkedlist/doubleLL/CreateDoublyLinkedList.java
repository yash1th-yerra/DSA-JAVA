package src.linkedlist.doubleLL;


// creating a doubly linked list using node
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data,Node next,Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }




}


public class CreateDoublyLinkedList {


    // converting array into linked list
    public static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node curr = new Node(arr[i],null,prev);
            prev.next = curr;
            prev = curr;
        }
        return head;
    }

    // Print LinkedList
    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println("");
    }

    // delete at head of doubly linked list
    public static Node removeAtHead(Node head){
        if(head == null || head.next==null) return null;
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    //delete at end of doubly linked list
    public static Node removeAtEnd(Node head){
        if(head==null || head.next==null) return null;
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }


    //delete kth element in doubly linked list
    public static Node removeAtK(Node head,int k){
        Node curr = head;
        int cnt = 0;
        while(curr!=null){
            cnt++;
            if(cnt==k) break;
            curr = curr.next;
        }
        if(curr!=null){
            Node rear = curr.prev;
            Node front = curr.next;
            if (rear == null && front == null) return null;
            else if (rear == null) {
                Node previous = head;
                head = head.next;
                previous.next = null;
                head.prev = null;
            } else if (front == null) {
                Node previous = curr.prev;
                curr.prev = null;
                previous.next = null;
            } else {
                rear.next = front;
                front.prev = rear;
                curr.next = null;
                curr.prev = null;
            }
        }
        return head;
    }


    public static Node removeNode(Node head,int k){
        // k cannot be 1
        if(k==1) return head;
        Node temp = head;
        int position = 1;

        while (position < k && temp != null) {
            temp = temp.next;
            position++;
        }

        // If the k-th node is found, update pointers
        if (temp != null) {
            Node prev = temp.prev;
            Node next = temp.next;

            // If the node to be deleted is not the tail
            if (next != null) {
                next.prev = prev;
            }

            // If the node to be deleted is not the head
            if (prev != null) {
                prev.next = next;
            }

            // Detach the node
            temp.next = null;
            temp.prev = null;
        }

        // Return the head of the list
        return head;
    }

    // Insert a node at head
    public static Node insertAtHead(Node head,int data){
        if(head==null) return head;
        Node newNode = new Node(data,head,null);
        head.prev = newNode;
        head = newNode;
        return head;
    }

    public static Node insertAtEnd(Node head,int data){
        if(head == null) return new Node(data);
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        Node newNode = new Node(data);
        curr.next = newNode;
        newNode.prev = curr;
        newNode.next = null;
        return head;
    }


    //Insert a node at kth position
    public static Node insertAtK(Node head,int data,int k){
        Node newNode = new Node(data);
        if(k==0){
            newNode.next = head;
            if(head!=null){
                head.prev=newNode;
            }
            return newNode;
        }

        Node curr = head;
        for(int i=0;i<k-1;i++){
            curr = curr.next;
        }
        Node nextNode = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
        if(nextNode!=null){
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        return head;
    }


    //Insert a node at given node in doubly linkedlist

    public static Node insertAtValue(Node head,int val,int data){
        if(head ==null) return null;
        Node curr = head;
        while(curr!=null && curr.data!=val){
            curr = curr.next;
        }
        if(curr==null){
            return head;
        }
        Node newNode = new Node(data);

        newNode.next = curr.next;
        newNode.prev = curr;

        if(curr.next!=null){
            curr.next.prev = newNode;

        }
        curr.next = newNode;
        return head;


    }



    public static void main(String[] args) {
//        int[] arr  ={6,62};
        int[] arr = {1,2,3,4,5};
        Node head = convertArr2DLL(arr);
//        Node head2 = convertArr2DLL(arr2);
//        Node head2 = removeAtHead(head);
//        Node head2 = removeAtEnd(head);
//        Node head3 = removeAtK(head,1);
//        Node head4 = removeNode(head2,3);

//        print(head3);
//        Node head2 = insertAtHead(head,3);
//        Node head2 = insertAtEnd(head,6);
//        Node head2 = insertAtK(head,100,3);
        Node head2 = insertAtValue(head,3,1000);

        print(head2);

    }
}
