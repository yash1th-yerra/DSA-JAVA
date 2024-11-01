package src.bitmanipulation;

public class ToggleiBit {
    public static void main(String[] args) {
        int n =13;
        int i=2;
        System.out.println(n);
        n = n^(1<<i);
        System.out.println(n);
        n = n^(1<<i);
        System.out.println(n);
    }
}
