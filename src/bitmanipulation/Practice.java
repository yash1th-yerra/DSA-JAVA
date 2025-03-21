package src.bitmanipulation;

import java.lang.reflect.Array;
import java.util.* ;
import java.io.*;
import java.util.ArrayList;
public class Practice {
    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        if (mat == null || mat.isEmpty() || mat.get(0).isEmpty()) {
            return -1;
        }

        int i = 0, j = m - 1;
        int ans = -1;

        while (i < n && j >= 0) {
            if (mat.get(i).get(j) == 1) {
                ans = i;
                j--;
            } else {
                i++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0,0,1)));
        list.add(new ArrayList<>(Arrays.asList(0,11)));
        list.add(new ArrayList<>(Arrays.asList(0,0,0)));


        int index = rowMaxOnes(list,list.size(),list.get(0).size());
        System.out.println(index);

    }
}