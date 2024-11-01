package src.basicmath;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

//    public static boolean prime(int n){
//        boolean isPrime = true;
//        for(int i=2;i<=Math.sqrt(n);i++){
//            if(n%i==0){
//                isPrime = false;
//                break;
//            }
//
//        }
//        return isPrime;
//    }
//
//    public static void main(String[] args) {    //Overall Time Complexity ~ O(n^1/2 * 2* n^1/2)
//                                                //Overall Space Complexity ~ depends on number of factors.
//        List<Integer> list = new ArrayList<>();
//        int n = 780;
//        for(int i=2;i<=Math.sqrt(n);i++){       // Time Complexity - O(n^1/2)
//            if(n%i==0){
//                if(prime(i)){                   // Time Complexity - O(n^1/2)
//                    list.add(i);
//                }
//                if(prime(n/i)){
//                    list.add(n/i);
//                }
//            }
//        }
//
//        System.out.println(list);
//    }

    // To Optimize above problem we can go with Sieve of Eratosthenez approach

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        int n = 780;
        for(int i=2;i<Math.sqrt(n);i++){            //  Time Complexity - O(n^1/2)
            if(n%i==0){
                list.add(i);
                while(n%i==0){                      // Time Complexity - O(log(n))
                    n=n/i;
                }

            }

        }
        if(n!=1) list.add(n);


        System.out.println(list);

    }







}
