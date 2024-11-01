package src.bitmanipulation;

public class CheckiBit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        //using left shift operator
        if((n &(1<<i))!=0){
            System.out.println("Set");
        }
        else{
            System.out.println("Not Set");
        }

        //Using right shift operator
        if((n>>(i)&1) != 0){
            System.out.println("Set");

        }
        else{
            System.out.println("Not Set");
        }

    }
}
