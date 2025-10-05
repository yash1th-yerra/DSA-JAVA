package src.patterns;

import java.util.Scanner;

public class Pattern12{

    static void pattern(int n){
        for(int i=1;i<n;i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j=1;j<2*n-(2*i+1);j++){
                System.out.print(" ");
            }

            for(int j=i;j>=1;j--){
                System.out.print(j);
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
