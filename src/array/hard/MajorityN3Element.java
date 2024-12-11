package src.array.hard;

import java.sql.Array;
import java.util.*;


// In an array of size n there can be 2 n/3 elements at max and 1 at min
// for example if i take 8 elements 1,1,1,2,2,2,3,3 {1,2} or
// 1,1,1,2,2,3,3,4 {1,2}
// In this case we can follow following approaches


// 1. naive approach
// run two loops and calculate count of each element in array
// Time Complexity - O(n*n)

// 2. Frequency Count using hashing
// take one hashmap and add elements and their frequency
// return elements with freq >  n/3

// 3. Extended Moore's Voting Algorithm
// this is an extension to moore's voting algorithm
// keep two counter variables  and increment them if cnt is 0 and check if it is already taken or not by maintaining another element variable
// it's kind of mixed approach moore's voting and bit similar to bucket approach
// Time Complexity - O(N)
// Space Complexity - O(1)
public class MajorityN3Element {


    public static List<Integer> findMajority(int[] arr){
        int cnt1 = 0 ,cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(cnt1==0 && arr[i]!=ele2){
                cnt1 =1;
                ele1 = arr[i];
            }
            else if(cnt2==0 && arr[i]!=ele1){
                cnt2 =1;
                ele2 = arr[i];
            }
            else if(arr[i]==ele1) cnt1++;
            else if(arr[i]==ele2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;cnt2 = 0;
        for(int i=0;i<arr.length;i++){
            if(ele1 == arr[i]) cnt1++;
            if(ele2 == arr[i]) cnt2++;
        }
        int min = (int)(arr.length/3)+1;
        if(cnt1>=min) ans.add(ele1);
        if(cnt2>=min) ans.add(ele2);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter Size of Array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter array of elements: ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> majority = findMajority(arr);
        System.out.println(majority);


    }
}
