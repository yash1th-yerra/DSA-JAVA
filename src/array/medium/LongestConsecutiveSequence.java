package src.array.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    //linear search

    private static boolean linearSearch(int[] arr,int x){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                return true;
            }
        }
        return false;
    }

    // Brute Force
    public static int bruteLongestConsecutiveSequence(int[] arr){   // Time Complexity - O(N^2)
        int longest = 1;                                            // Space Complexity - O(1)
        for(int i=0;i<arr.length;i++){
            int x = arr[i];
            int cnt = 1;
            while(linearSearch(arr,x+1)==true){
                x+=1;
                cnt+=1;

            }

            longest = Math.max(longest,cnt);
        }


        return longest;
    }



    private static int optimalLongestConsecutiveSequence(int[] arr){
        if(arr.length==0) return 0;
        int longest=1;
        Set<Integer> set = new HashSet<>();
        for(int i:arr) set.add(i);
        for(int it: set){
            if(!set.contains(it-1)){
                int cnt=1;
                int x = it;
                while(set.contains(x+1)){
                    cnt++;
                    x++;
                }
                longest = Math.max(longest,cnt);
            }
        }
        return longest;

    }




    public static void main(String[] args) {

        int[] arr = {102,4,100,1,101,3,2,1,1};
//        int longest = bruteLongestConsecutiveSequence(arr);
        int longest = optimalLongestConsecutiveSequence(arr);
        System.out.println(longest);







    }
}
