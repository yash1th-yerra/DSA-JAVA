package src.bitmanipulation;

public class TwoUniqueInTwice {

    //first approach
    public static int[] twoUnique(int[] arr, int n){
        int ans=0;

        //First xor every element.it will result in 14^4 (a number having 1's at bits where these numbers have distinct bits )
        for(int i=0;i<n;i++){               // Time Complexity - O(n)
            ans = ans^arr[i];
        }

        //If we able to find any bit that differs then our job is done
        //the bit 1 represents that these numbers differs at that position .
        //so we can find last set bit in ans which differs in both numbers
        int lastSetBit = (ans & (ans-1))^ans;

        //Now have two buckets and add numbers into buckets which differs in last set bit by doing xor
        int b1 = 0,b2=0;
        for(int i=0;i<n;i++){                       // Time Complexity - O(n)
            if((arr[i] & lastSetBit) != 0){
                b1 = b1^arr[i];
            }
            else{
                b2=b2^arr[i];
            }
        }

        // both buckets will contain two unique elements

        return new int[]{b1,b2};

    }

    public static void main(String[] args) {
        int[] arr = {2,4,2,14,3,7,7,3};
        int n = arr.length;
        int[] ans = twoUnique(arr,n);       //Time Complexity - O(n) + O(n)
        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }
}
