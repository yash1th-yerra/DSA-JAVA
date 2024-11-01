package src.bitmanipulation;

public class SetiBit {

    public static void main(String[] args) {
        int n = 9;  //1001
        int i = 2;
        n = n | (1<<i); //1101  setting 1 in 2nd bit cnverted 9 to 13
        System.out.println(n);

    }
}
