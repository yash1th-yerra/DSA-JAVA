package src.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    //minimum no of subsets that can be generated from an array


    public static void main(String[] args) {

        int[] arr = {1,2,3};
        int n = arr.length;
        int subsets = 1<<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<subsets;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    list.add(arr[j]);
                }

            }
            ans.add(list);
        }
        System.out.println(ans);

    }
}
