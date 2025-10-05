package src.patterns;

import java.util.Scanner;

public class Pattern10{

    static void pattern(int n){
        for(int i=1;i<=2*n;i++){
            int stars = i;
            if(i>n) stars = 2*n-i;
            for (int j = 1; j <=stars; j++) {
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
