package src.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingProblems {


    // given list of intervals as (start,end) we need to find out overlapping intervals and remove them
    // return minimal removal of overlapping intervals

    // (1,2) (2,3) (3,4) (1,3)
    // (1,2) (2,3) (3,4) - non overlapping
    // (1,3) is removed (1 - count)
    // if we observe carefully this problem is exactly similar to N-Meetings in Room problem
    // start is starting time and end is ending time




    public static int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a-> a[1]));

        int count=0;
        int lastEnd = Integer.MIN_VALUE;

        for(int[] interval : intervals){
            if(interval[0]>=lastEnd){
                lastEnd = interval[1];
            }
            else{
                count++;
            }
        }



        return count;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals1)); // Output: 1

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals2)); // Output: 2

        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(intervals3)); // Output: 0

    }
}
