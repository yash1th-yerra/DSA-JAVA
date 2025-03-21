package src.linkedlist.doubleLL;




public class ReverseLinkedList {
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        if(head ==null || head.next==null){
            return head;
        }
        Node last = null ;
        Node curr = head;
        while(curr!=null){
            last = curr.prev;
            curr.prev = curr.next;
            curr.next =last;
            curr = curr.prev;
        }
        return last.prev;
    }

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


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = convertArr2DLL(arr);
        Node head2 = reverseDLL(head);
        print(head2);

    }

}
