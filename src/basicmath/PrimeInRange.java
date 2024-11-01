package src.basicmath;


// Sieve of Eratosthenez Approach

import java.util.ArrayList;
import java.util.List;

public class PrimeInRange {

    public static int[] primePreCompute(int n){             //Time Complexity - O(Nlog(logn))
        int[] primeFactors = new int[n+1];
        for(int i =2;i<=n;i++){
            primeFactors[i]=1;
        }
        for(int i=2;i<Math.sqrt(n);i++){
            if(primeFactors[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    primeFactors[j]=0;
                }
            }
        }
        return primeFactors;


    }

    public static void main(String[] args) {
        int n = 30;
        List<Integer> list = new ArrayList<>();

        int[] primeFactors = primePreCompute(n);
        for(int i=2;i<=n;i++){          //Time Complexity - O(N)
            if(primeFactors[i]==1){
                list.add(i);
            }
        }

        System.out.println(list);

    }

}
