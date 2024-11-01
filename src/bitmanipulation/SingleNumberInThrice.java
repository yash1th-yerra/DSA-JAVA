package src.bitmanipulation;


import java.util.Arrays;

public class SingleNumberInThrice {

//    public static int singleNumber(int[] arr) {
    //if we check the set bits at each bitposition of each number and cnt them
    // after counting at each position divide count by 3 if any odd bit is there then it will return 1
    // if so we have to set a bit at that position of ans.


//        int ans = 0;
//        int n = arr.length;
//        for(int bitIndex=0;bitIndex<32;bitIndex++){         //Time Complexity - O(32)
//            int cnt=0;
//            for(int i=0;i<n;i++){                           //Time Complexity - O(n)
//                if((arr[i] & (1<<bitIndex))!=0)
//                    cnt++;
//            }
//            if(cnt%3==1){
//                ans = ans | (1<<bitIndex);
//            }
//        }
//        return ans;
//
//    }


//    public static int singleNumberJumps(int[] arr) {
    // then starting at 1st index and move three position at a time
    // check successor and predeccor of that element .
    // at some point you'll be finding that unique element


//        for(int i=1;i<arr.length;i+=3){
//            if(arr[i-1]!=arr[i]){
//                return arr[i-1];
//            }
//
//        }
//        return arr[arr.length-1];
//
//    }


    public static int singleNumberBuckets(int[] arr) {
        int ones = 0 ;
        int twos = 0;
        for(int i=0;i<arr.length;i++){
            ones = ones ^ arr[i] & ~twos;
            twos = twos ^ arr[i] & ~ones;
        }
        return ones;
    }


    public static void main(String[] args) {
        int[] arr = {5,5,5,6,7,7,7,4,4,4};

        //First Approach we can go with Hashmap by maintaining frequency of numbers

        // Second Approach using bits
//        int ans = singleNumber(arr);               // Overall Time Complexity - O(n*32) not optimal
//        System.out.println(ans);


        // if array is not sorted then sort it

        Arrays.sort(arr);           // Time Complexity - O(nlogn)
//        System.out.println(singleNumberJumps(arr));     // Overrall Time Complexity - O(nlogn) + O(n/3) although it better than bitindex approach it is not optimal

        // Third Approach using Buckets
        System.out.println(singleNumberBuckets(arr));

    }
}
