package src.array.hard;

import java.util.ArrayList;
import java.util.List;

public class MissRepeatNumbers {
    // we are given an array arr = {4,3,6,2,1,1}
    /*
        numbers in the array should be in range of 1 to length of array
        however there exists one repeating number which made another number to miss
        so task is to find that missing and repeating numbers

     */


    /*
        BruteForce:

        1. run a loop from 1 to n(array length)
        2. do linear search for each number and maintain counter
        3. at each iteration check count at end
        4. if it is 2 then it is repeating
            if it is 0 then it is missing
        5. take those elements and return
     */


    public static int[] bruteMissRepeat(int[] arr){
        int n = arr.length;
        int repeating=-1,missing=-1;


        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[j]==i) count++;
            }
            if(count==2) repeating = i;
            else if(count==0) missing = i;
            if(repeating!=-1 && missing!=-1) break;
        }
        return new int[]{repeating,missing};
    }           // TC - O(N^2) SC - O(1)



    // better approach will be hashing

    public static int[] hashMissRepeat(int[] arr){
        int n = arr.length;
        int[] hash = new int[n+1];
        int miss = -1, repeat = -1;
        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }

        for(int i=1;i<=n;i++){
            if(hash[i]==0) miss = i;
            if(hash[i]==2) repeat =i;
        }
        return new int[]{repeat,miss};

    }


    // optimal -1 (using math)
    /*
        1. sum each element in array  as s
        2. sum from 1 to n as sn
        3. then do sum of squares of elements in array as s2
        4. same with 1 to n as s2n
        5. now do s2-s2n(as a^2-b^2 ) which upon divided by s2-sn(a-b) will give s2+sn(a+b)
            i.e. (a^2-b^2)/(a-b) = (a+b)
           now we have s+sn and s-sn
        6. using these we can get repeat and missing
        7. by adding both we get missing and repeating by substracting
     */


    public static int[] mathMissRepeat(int[] arr){
        int n = arr.length;
        long sum = 0,sumsq = 0;
        long expectedSum = (long) n*(n+1)/2;
        long expectedSumSq = (long)(n*(n+1)*(2*n+1))/6;
        for(int num:arr){
            sum +=num;
            sumsq+=(long)(num*num);
        }

        long diff = sum-expectedSum;
        long sqDiff = sumsq-expectedSumSq;

        long sumXY = sqDiff/diff;
        int repeating = (int)((diff+sumXY)/2);
        int missing  =(int)(sumXY-repeating);
        return new int[]{repeating,missing};


    }

    // optimal-2(buckets approach)
    /*
        1. XOR all numbers from 1 to n → let’s call this xor1
        2. XOR all elements in the array → let’s call this xor2
        3. Now do xor1 ^ xor2 = xor = X ^ Y (because all other numbers cancel out)
        4. So now you have:
           xor = X ^ Y → but you don’t know which is which.

        5. Find the rightmost set bit in xor (to separate X and Y):
        6. int rightmostSetBit = xor & -xor;
        7. Now divide numbers into two buckets:
        Bucket 1: Numbers with the set bit
        Bucket 2: Numbers without the set bit
        8. Do this for both: the array and numbers from 1 to n
        After that, you’ll get two results → One is X, one is Y.
        Now check the input array to know which is the repeating one.
     */


    public static int[] bitMissRepeat(int[] arr){
        int n = arr.length;
        int xr = 0;
        for(int i=0;i<n;i++){
            xr = xr ^ arr[i];
            xr  = xr ^ (i+1);
        }
//        int bitNo = (xr & (xr-1))^(xr);
        int bitNo =0;
        while(true){
            if((xr&(1<<bitNo))!=0) break;
            bitNo++;
        }
        int zero = 0,one=0;
        for(int i=0;i<n;i++){
            if((arr[i]&(1<<bitNo))!=0) one = one ^ arr[i];
            else zero = zero ^ arr[i];
        }
        for(int i=1;i<=n;i++){
            if((i&(1<<bitNo))!=0) one = one^i;
            else zero = zero^i;
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==zero) count++;
        }
        if(count==2) return new int[]{zero,one};
        return new int[]{one,zero};
    }


    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
//        int[] ans = bruteMissRepeat(arr);
//        int[] ans = hashMissRepeat(arr);
        int[] ans = bitMissRepeat(arr);
        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }
}
