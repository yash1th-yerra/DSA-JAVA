package src.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

    // Three sum or Triplet Sum
    // -1 0 1 -1 -2 2 1
    // triplet sum can be -1 0 1 , 0 -2 2 , -1 -1 2 , 1 -2 1,....
    // so we can have one pointer i at first and j at end
    // and another pointer k at i+1 traverse till it crosses j i.e. k<j
    // add a[i] + a[j] + a[k] and check if sum == 0  if so add a[i],a[j],a[k] into list.
    // Time Complexity - O(N^2)
    // Space Complexity - O(1)

    public static List<List<Integer>> triplet(int[] arr){   // Overall Time Complexity ~ O(N^2)
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){   // Time Complexity - O(N)
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){         // Time Complexity ~ O(N)
                int sum = arr[i]+arr[j]+arr[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j]== arr[j-1]) j++;
                    while(j<k && arr[k] == arr[k+1]) k--;
                }
            }


        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter Array Size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter Array Elements: ");
        int[] arr  =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> ans = triplet(arr);
        System.out.println(ans);
    }
}
