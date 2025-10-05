package src.patterns;

import java.util.Scanner;

public class Pattern16{

    static void pattern(int n){
//        char ch= 'A';
        for(int i=0;i<n;i++){

            for (int j=0; j<=i; j++) {
                System.out.print((char)((int)('A'+i))+ " ");

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
