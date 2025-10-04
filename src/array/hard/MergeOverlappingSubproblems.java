package src.array.hard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubproblems {

    // Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
    // Example 1:
    // intervals = [[1,3],[2,6],[8,10],[15,18]]
    // output = [[1,6],[8,10],[15,18]]
    // Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
    // intervals.


    private static List<List<Integer>> bruteMergeOverlappingIntervals(int[][] arr) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>(){       // nlogn
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < n; i++){
            int start =  arr[i][0];
            int end = arr[i][1];
            if(!ans.isEmpty() && end<=ans.getLast().get(1)){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(arr[j][0]<=end){
                    end = Math.max(end,arr[j][1]);
                }else{
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }
        return ans;

    }


    private static List<List<Integer>> optimalMergeOverlappingIntervals(int[][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        for (int[] ints : arr) {
            if (ans.isEmpty() || ans.getLast().get(1) <= ints[0]) {
                ans.add(Arrays.asList(ints[0], ints[1]));
            } else {
                ans.getLast().set(1, Math.max(ans.getLast().get(1), ints[1]));
            }
        }

        return ans;
    }

    public static void main(String args[]){
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans =optimalMergeOverlappingIntervals(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();

    }

}
