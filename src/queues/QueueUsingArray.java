package src.queues;

public class QueueUsingArray {

    int front,rear;
    int[] queue;
    int capacity = 10;
    int currSize;

    public QueueUsingArray(){
        this.queue= new int[capacity];
        this.front = -1;
        this.rear =-1;

    }
    public QueueUsingArray(int c){
        capacity = c;
        queue= new int[capacity];
        front = -1;
        rear =-1;
    }

    public void push(int data){
        if(capacity==currSize){
            System.out.println("Queue is full");
        }
        if(currSize==0){
            rear=0;
            front=0;
        }
        else{
            rear = (rear+1)%capacity;
        }
        queue[rear] = data;
        currSize++;

    }

    public int peek(){
        if(currSize==0) {
            System.out.println("End of Queue ");
            return -1;
        }
        return queue[front];

    }

    public int pop(){
        if(currSize==0){
            System.out.println("End of Queue");
            return -1;
        }
        int result =queue[front];;
        if(currSize==1){
            front=-1;
            rear=-1;
        }
        else{
            front = (front+1)%capacity;
        }
        currSize--;
        return result;
    }

    public int size(){
        return currSize;
    }

}

class Main{
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

