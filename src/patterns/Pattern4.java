package src.patterns;

import java.util.Scanner;

public class Pattern4{

    static void pattern1(int n){
        for(int i=1;i<=n;i++){
            for (int j = 1; j <=i; j++) {
                System.out.print(i+" ");

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
