package src.basicmath;

public class PowerExponentiation {      //Optimized Approach

    public static int power(int n,int p){           // Time Complexity - O(logp )
        if(p==0) return 1;                          // Space Complexity - O(1)
        int ans = power(n,p/2);
        if(p%2==0) return ans*ans;
        else return ans*ans*n;
    }


    public static int power2(int n,int p ){     // Time Complexity  - O(logp)
        int ans=1;                              // Space Complexity - O(logp)
        while(p>0){
            if(n%2==1){
                ans = ans*n;
                p = p-1;
            }
            if(n%2==0){
                p = p/2;
                ans = ans*ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int p = 3;
        int ans = power(n,p);
        System.out.println(ans);
    }
}
