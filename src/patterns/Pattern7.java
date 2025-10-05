package src.patterns;

import java.util.Scanner;

public class Pattern7{

    static void pattern(int n){
        for(int i=0;i<n;i++){
            for (int j = 0; j <n-i+1; j++) {
                System.out.print("   ");

            }
            for (int j = 0; j <2*i+1; j++) {
                System.out.print(" * ");

            }
            for (int j = 0; j <=n-i+1; j++) {
                System.out.print("   ");

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
