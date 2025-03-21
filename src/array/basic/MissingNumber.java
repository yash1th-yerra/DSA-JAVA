package src.array.basic;


// Problem is to identify missing number in an array
// such that array contains {1,2,3,4}
// i.e. for index 0,1,2,3,4 it should contain 1,2,3,4,5 else there is missing number



// Naive Approach
// run two loops
// 1. 1st loop to run for numbers 1 to n
// 2. 2nd nested inner loop to traverse of elements in array
// 3. compare elements with number and check if there is any missing




public class MissingNumber {

    // brute force

//    public static int bruteMissingNumber(int[] arr){            //Time Complexity ~ O(N^2)
//        for(int i=1;i<=arr.length;i++){                         //Space Complexity  - O(1)
//            int flag = 0;
//            for(int j=0;j<arr.length;j++){
//                if(arr[j]==i){
//                    flag = 1;
//                    break;
//                }
//            }
//            if(flag==0){return i;}
//        }
//        return -1;
//    }

    // Better Solution: Using Hashing

//    public static int betterMissingNumber(int[] arr){   //Time Complexity - O(N) + O(N)
//        int[] hash  =new int[arr.length+1];             // Space Complexity - O(N)
//        for(int i=0;i<arr.length;i++){
//            hash[arr[i]]++;
//        }
//        for(int i=1;i<=arr.length;i++){
//            if(hash[i]==0){
//                return i;
//            }
//        }
//        return -1;
//    }


    // Optimal-1 Approach

//    public static int optimal1Missing(int[] arr){         //Time Complexity - O(N)
//        int sum1= 0;                                      //Space Complexity - O(1)
//        for(int i=0;i<arr.length;i++){
//            sum1 = sum1 + arr[i];
//        }
//        int N = arr.length+1;
//        int sum2 = N*(N+1)/2;
//        return sum2-sum1;
//

//    }


    // for even faster operation we can make use of bit wise operations

    public static int optimal2Missing(int[] arr){
        int xor1= 0;
        int xor2= 0;
        for(int i=0;i<arr.length;i++){
            xor1 = xor1^arr[i];
        }
        for(int i=1;i<=arr.length+1;i++){
            xor2 = xor2^i;
        }

        return xor1^xor2;
    }


    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,2,4,5};

//        int missing = bruteMissingNumber(arr);
//        int missing = betterMissingNumber(arr);
//        int missing = optimal1Missing(arr);
        int missing = optimal2Missing(arr);
        System.out.println(missing);

    }
}
