package src.bitmanipulation;

public class RemoveLastSet {
    public static void main(String[] args) {
        int n =4;
        int ni = n -1;
        n = n & (n-1);
        System.out.println(n);
    }
}
