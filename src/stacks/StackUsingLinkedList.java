package src.stacks;


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
public class StackUsingLinkedList {

    // creating a doubly linked list using node
    Node top =null;
    int size=0;
    public void push(int data){
        Node temp  = new Node(data);
        temp.next = top;
        top = temp;
        size++;
    }

    public int pop(){
        if(top==null) return -1;
        Node temp = top;
        int data = temp.data;
        top = top.next;
        temp = null;
        return data;

    }

    public int size(){
        return size;
    }

    public int peek(){
        if(top==null) return -1;
        return top.data;
    }

}

class Main2 {
    public static void main(String[] args) {
        StackUsingLinkedList s = new StackUsingLinkedList();
        s.push(3);
        s.push(4);
        s.push(1);
        s.push(2);
        s.push(2);
        s.push(2);
        s.push(2);
        s.push(2);
        s.push(2);
        s.push(2);
        s.push(2);

        System.out.println(s.size);
        System.out.println(s.peek());
        System.out.println(s.pop());
        do{
            System.out.println(s.pop());
        }while(s.peek()!=-1);
    }
}
