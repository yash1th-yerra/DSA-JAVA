package src.array.medium;

// An element in an array is said to be leader if any element on its right is smaller than current element.
// i.e. [10,22,12,3,0,6] in this after 22 everything is smaller than 22 hence 22 is leader of array





import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersOfArray {
//Brute-Force Approach will be
// do linear search from start with two loops .
// i.e. for each element compare if there is any larger element than it.

//    public static List<Integer> bruteLeader(int[] arr){     //Overall Time Complexity ~ O(n^2)
//
//
//        List<Integer> ans = new ArrayList<>();
//        boolean flag;
//        for(int i=0;i<arr.length;i++){                  // Time Complexity - O(N)
//            flag = true;
//            for(int j=i+1;j<arr.length;j++){            // Time Complexity ~ O(N)
//                if(arr[j]>arr[i]){
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag==true) ans.add(arr[i]);
//        }
//        return ans;
//    }

// Optimal Approach

    // if we traverse in array in backward direction , and after every occurence of large element by keeping track
    // of max element and adding it into list

    public static List<Integer> OptimalFindLeaders(int[] arr){
        int max = -1;
        List<Integer> ans  = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>max){         // if duplicates should also be needed to store then make it >=
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }



    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        int[] arr2 = {16,17,17,4,3,5,2};

        List<Integer> ans = OptimalFindLeaders(arr2);
        System.out.println(ans);



    }
}
