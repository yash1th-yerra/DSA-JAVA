package src.linkedlist.single;

public class StartingPointofCycleinLL {
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    static Node startingOfLoop(Node head){
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // cycle detected
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;   // starting point
            }
        }

        return null; // ✅ no cycle
    }

    static void main(String[] args) {
            Node head = new Node(1);
            Node second = new Node(2);
            Node third = new Node(3);
            Node fourth= new Node(4);
            Node fifth= new Node(5);

            head.next = second;
            second.next = third;
            third.next = fourth;
            fourth.next = fifth;
            fifth.next = third;

            System.out.println(startingOfLoop(head).data);

    }

}

