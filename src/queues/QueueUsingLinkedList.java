package src.queues;

class Node {
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
public class QueueUsingLinkedList {
    Node front,rear;
    int size=0;

    public void push(int data){
        Node temp = new Node(data);
        if(front==null){
            front = rear = temp;
        }
        else{
            rear.next = temp;
        }
        size++;
    }

    public int pop(){
        if(front==null) return -1;
        Node temp = front;
        int data = temp.data;
        front = front.next;
        temp = null;
        size--;
        return data;
    }

    public int peak(){
        if(front==null) return -1;
        return front.data;

    }


    public int size(){
        return size;
    }


}

class Main2 {
    public static void main(String[] args) {
        QueueUsingArray s = new QueueUsingArray();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        s.pop();
        s.push(6);
        s.push(7);
        System.out.println("Size of Queue is "+s.size());
        while(s.peek()!=-1){
            System.out.print(s.pop()+",");
        }


    }
}
