package src.bitmanipulation;

public class CleariBit {
    public static void main(String[] args) {
        int n = 13;
        int i=2;
        n = n &~(1<<i);

        System.out.println(n);
    }
}
