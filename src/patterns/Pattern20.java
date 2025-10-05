package src.patterns;

import java.util.Scanner;

public class Pattern20{

    static void pattern(int n){
        int space =2;
        for(int i=1;i<n;i++){

            for(int j=0;j<=n-i-1;j++){
                System.out.print("*");
            }
            for (int j = 0; j < space; j++) {
                System.out.print(" ");

            }

            for(int j=0;j<=n-i-1;j++){
                System.out.print("*");
            }
            space+=2;

            System.out.println();

        }

    }

    static void invertedPattern(int n){
        int space =2*n-2;
        for(int i=0;i<n;i++){

            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for (int j = 0; j <space; j++) {
                System.out.print(" ");

            }

            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            space-=2;
            System.out.println();

        }

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        invertedPattern(n);
        pattern(n);
    }
}
