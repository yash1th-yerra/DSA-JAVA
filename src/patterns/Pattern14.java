package src.patterns;

import java.util.Scanner;

public class Pattern14{

    static void pattern(int n){
        for(int i=0;i<n;i++){
            for (char ch='A'; ch <= 'A'+i; ch++) {
                System.out.print(ch+" ");

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
