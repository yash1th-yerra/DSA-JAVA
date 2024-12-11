package src.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

    public static List<List<Integer>> triplet(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
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
