package src.array.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Pascal Triangle
/*
* 1
* 1 1
* 1 2 1
* 1 3 3 1
* 1 4 6 4 1
* 1 5 10 10 5 1
* */

// if we observe the pattern
// 0c0 = 1
// 1c0 = 1 1c1 = 1
// 2c0 = 1 2c1 = 2 2c2 = 1
// 3c0 = 1 3c1 = 3 3c2 = 3 3c3 = 1
// 4c0 = 1 4c1 = 4 4c2 = 6 4c3 = 4 4c4 = 1
// 5c0 = 1 5c1 = 5 5c2 = 10 5c3 = 10 5c4 = 5 5c5 = 1

// to find out the number at a particular position its is a combination of row and column
// rCc where r is row and c is column
// rCc = r! * (r-c)!/c!
// so we need to use two loops for traversing into each column for each row
// for(i = 1 -> rows) {
//      for(j=1 -> i) {
//          element = element*(i-j)/j;
//      }
//  }


public class PascalTriangle {


    // generates elements for each row and column.
    public static List<Integer> generateRow(int row){
        int ans =1;
        List<Integer> temp = new ArrayList<>();
        temp.add(ans);
        for(int i=1;i<row;i++){
            ans = ans * (row-i);
            ans = ans/(i);
            temp.add(ans);
        }
        return temp;

    }

    // generates triangle by generating each row
    public static List<List<Integer>> generatePascalTriangle(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =1;i<=numRows;i++){
            ans.add(generateRow(i));
        }
        return ans;

    }

    // main method to start
    // take input and generate triangle
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no of rows");
        int rows = scanner.nextInt();
        List<List<Integer>> ans = generatePascalTriangle(rows);
        for (List<Integer> i : ans){
            System.out.println(i);

        }
    }
}
