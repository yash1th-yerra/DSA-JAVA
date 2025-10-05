package src.patterns;

import java.util.Scanner;

public class Pattern13{

    static void pattern(int n){
        int num=1;
        for(int i=1;i<=n;i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(num+" ");
                num++;

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
