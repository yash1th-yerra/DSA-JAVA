package src.basicmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorsQuery {
    // in the package src.basicmath.PrimeFactors we have already done a problem of prime factorization of a number
    // This time we are going to do same but with queries i.e. we are given with some queries of size lets say 10^5
    // and each queries contains a number so that we have to find primefactorization of each numnber in query

    // for example  - query = {3,12,16,20}
    // then prime factorization of 3 - 3
    // then prime factorization of 12 - 2,2,3
    // then prime factorization of 16 - 2,2,2,2
    // then prime factorization of 20 - 2,2,5
    // like wise we have to print {{3},{2,3},{2},{2,5}}

    // if we want to add duplicates as well simply add factor while dividing the number

//    public static List<Integer> primeFactors(int n){
//        List<Integer> list = new ArrayList<>();
//        for(int i = 2;i<Math.sqrt(n);i++){                    // Time Complexity  O(n^(1/2)*log(n))
//            if(n%i==0){
//                list.add(i);
//                while(n%i==0){
//                    n = n/i;
//                }
//            }
//        }
//        if(n!=1) list.add(n);
//        return list;
//    }


    public static int[] getSieves(int n){
        int[] spf = new int[n+1];
         for(int i=2;i<=n;i++){
             spf[i]=i;
         }

         for(int i=2;i<=Math.sqrt(n);i++){
             if(spf[i]==i){
                 for(int j=i*i;j<=n;j+=i){
                     spf[j] = i;
                 }
             }
         }

         return spf;
    }


    public static List<Integer> primeFactors(int n){

        int[] spf = getSieves(n);
        List<Integer> list = new ArrayList<>();
        while(n!=1){
            list.add(spf[n]);
            n = n/spf[n];
        }
        return list;
    }



    public static void main(String[] args) {
        int[] query = {3,12,16,20};

//        for(int i=0;i<query.length;i++){                  // Time Complexity - O(q) * (n^1/2 * log(n)) Not Optimal
//            System.out.println(primeFactors(query[i]));
//        }

        for(int i=0;i<query.length;i++){                    // Time Complexity - O(q*(log(n)) + O(nlog(logn))
            System.out.println(primeFactors(query[i]));     // Space Complexity - O(N) fr spf array
        }


    }

}
