package src.bitmanipulation;

public class XorNumInRange {

    //If we observe carefully the pattern of xor of numbers as below
    //1 - 1
    //1^2 - 3
    //1^2^3 - 0
    //1^2^3^4 - 4
    //1^2^3^4^5 - 1
    //1^2^3^4^5^6 - 7
    //1^2^3^4^5^6^7 - 0
    //1^2^3^4^5^6^7^8 - 8

    // i.e if n%4==1 return 1
    // i.e if n%4==2 return n+1
    // i.e if n%4==3 return 0
    // i.e if n%4==0 return n

    public static int xorNumInRange(int n){
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 0;
        if(n%4==0) return n;
        return -1;

    }




    public static void main(String[] args) {
        int[][] queries = {{1,3},{4,6},{7,9}};
        int q = queries.length;
        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int ansl = xorNumInRange(l-1);
            int ansr = xorNumInRange(r);
            System.out.println(ansl^ansr);



        }
    }
}
