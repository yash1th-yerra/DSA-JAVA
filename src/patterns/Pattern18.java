package src.patterns;

import java.util.Scanner;

public class Pattern18{

    static void pattern(int n){
        for(int i=0;i<n;i++){
            for (char ch=(char)(int)('A'+(n-i-1)); ch <= (char)(int)('A'+n-1); ch++) {
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
