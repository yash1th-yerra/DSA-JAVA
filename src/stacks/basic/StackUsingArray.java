package src.stacks.basic;

public class StackUsingArray {
    int size = 10;
    int arr[] = new int[size];
    int top ;

    public StackUsingArray(){
        this.top =-1;
    }

    public void push(int x){
       if(top>=size-1){
           System.out.println("Stack Overflow");
       }else{
           top++;
           arr[top] = x;
           System.out.println("Pushed into Stack");
       }
    }

    public boolean isEmpty(){
        return top<0;
    }

    public int pop(){
        if(top==-1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
    public int size(){
        return top+1;
    }

    public int peek(){
        if(top!=-1) return arr[top];
        System.out.println("Stack Underflow");
        return -1;
    }



}

class Main{
    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray();
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
