package src.basicmath;

import java.util.ArrayList;
import java.util.List;

public class PrimeQuery {

    //Naive Approach enclosed in comments

    //Optimized Solution at bottom

//    public static boolean prime(int n){
//        boolean isPrime = true;
//
//        for(int i=2;i<=Math.sqrt(n);i++){       // Time Complexity - O(n^1/2)
//            if(n%i==0){
//                isPrime = false;
//                break;
//            }
//        }
//
//        return isPrime;
//    }

//    public static int naiveQuery(int[][] queries){
//        int count= 0;
//        int q = queries.length;
//        for(int i=0;i<q;i++){               // time complexity - O(q)
//            int l = queries[i][0];
//            int r = queries[i][1];
//            for(int j=l;j<=r;j++){          // time complexity - O(l-r)
//                if(prime(j))
//                    count++;
//            }
//        }
//        return count;
//    }

    public static int[] getSieve(int n){
        int[] prime = new int[n+1];
        for(int i=2;i<=n;i++){
            prime[i]=1;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }

        return prime;
    }

    public static List<Integer> optimisedQuery(int[][] queries){
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int q = queries.length;
        int[] prime = getSieve(1000000);        // Time Complexity - O(10^6*log(log(10^6)))
        for(int i=2;i<=1000000;i++){              // time Complexity - O(10^6)
            count+=prime[i];
            prime[i]=count;
        }

        for(int i=0;i<q;i++){                       // Time Complexity - O(q)
            int l = queries[i][0];
            int r = queries[i][1];
            list.add(prime[r]-prime[l-1]);

        }

        return list;
    }




    //driver code

    public static void main(String[] args) {
        int[][] queries = {{3, 10}, {8, 20}, {1, 5}};     // {l,r} - where 1<=l<=r<=10^6  and queries <= 10^5

//        int countNaive = naiveQuery(queries);           // Overall Time Complexity - O(n^1/2 * q * (l-r))
        // q and (l-r) the multiple of these two will be huge so it is not optimal

        List<Integer> countOptimise = optimisedQuery(queries); // Overall time Complexity - O(10^6*log(log(10^6))) + O(10^6) + O(q)
        System.out.println(countOptimise);



    }
}
