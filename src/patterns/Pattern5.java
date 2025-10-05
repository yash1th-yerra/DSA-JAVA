package src.patterns;

import java.util.Scanner;

public class Pattern5{

    static void pattern(int n){
        for(int i=n;i>=1;i--){
            for (int j = 1; j <=i; j++) {
                System.out.print("* ");

            }
            System.out.println();
        }

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern(n);
    }
}
