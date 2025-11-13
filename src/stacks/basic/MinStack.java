package src.stacks.basic;

import java.util.Stack;

class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class MinStack {



    Stack<Pair> st;

    MinStack(){
        st = new Stack<>();
    }

    public void push(int x){
        int min;
        if(st.isEmpty()) min=x;
        else min = Math.min(st.peek().y,x);
        st.push(new Pair(x,min));
    }


    public Pair pop(){
        return st.pop();
    }

    public int top(){
        if(st.isEmpty()) return -1;
        return st.peek().x;
    }
    public int getMin(){
        if(st.isEmpty()) return -1;
        return st.peek().y;
    }


    static void main() {
        MinStack min = new MinStack();
        min.push(1);
        min.push(2);
        min.push(3);
        min.push(5);

        System.out.println(min.top());
        System.out.println(min.getMin());
    }

}
