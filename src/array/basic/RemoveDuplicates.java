package src.array.basic;

import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicates {




    public static List<Integer> bruteRemoveDuplicates(int[] arr){
      List<Integer> list = new java.util.ArrayList<>();
        int j=0;
        list.add(arr[0]);
        for(int i=0;i<arr.length;i++){
            if(list.get(j)!=arr[i]){
                list.add(arr[i]);
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3};
        List<Integer> ans = bruteRemoveDuplicates(arr);
        System.out.println(ans);
    }
}
