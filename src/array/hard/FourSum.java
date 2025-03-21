package src.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourSum {


    // Extension to Triplet sum
    // Add one extra pointer
    // now iterate two loops and within it traverse two pointers
    // Time Complexity - O(N^3)
    // Space Complexity - O(1)
    public static List<List<Integer>> fourSum(int[] arr){       // Overall Time Complexity ~ O(N^3)
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){       // Time Complexity - O(N)
            if(i!=0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++){     // Time Complexity - O(N)
                if(j >i+1 && arr[j]==arr[j-1]) continue;
            int k = j+1;
            int l = n-1;
                while (k < l) {         // Time Complexity ~ O(N)
                    long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    if (sum == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    } else if (sum < 0) k++;
                    else l--;
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
        List<List<Integer>> ans = fourSum(arr);
        System.out.println(ans);
    }
}
