package src.patterns;

import java.util.Scanner;

public class Pattern1 {

    static void pattern1(int n){
        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                System.out.print("* ");

            }
            System.out.println();
        }

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern1(n);
    }
}
