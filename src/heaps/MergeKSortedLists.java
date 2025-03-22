package src.heaps;

import java.util.PriorityQueue;
class ListNode{
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

    public static ListNode mergeLists(ListNode[] lists){
        if(lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a,b) -> a.val-b.val
        );

        for(ListNode node:lists){
            if(node!=null)
                minHeap.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;


        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            if(minNode.next!=null){
                minHeap.add(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example input: 3 sorted linked lists
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        // Merging the lists
        ListNode mergedList = mergeLists(lists);

        // Printing the result
        printList(mergedList);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
