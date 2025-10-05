package src.patterns;

import java.util.Scanner;

public class Pattern11{

    static void pattern(int n){
        for(int i=1;i<=n;i++){
            int start = 1;
            if (i%2==0) start =0;
            for (int j = 1; j <=i; j++) {
                System.out.print(start+" ");
                start = 1-start;

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
