package src.greedy;

import java.util.Arrays;

public class Candy {


    /*

        you are given n children with ratings and each should be assigned candies on conditions as below
        1. each child must have atleast one candy
        2. children with high rating will get more candies

        so here children with high ratings can get more candies means greedy


        BruteForce:
        ex: ratings =[1,0,2]    output = [2 + 1 + 2] = 5
        1 1 2 = 4
        2 1 1 = 4
        if i consider max from both
        then 2 1 2 = 5 is the answer

        Time complexity - O(3N)
        Space Complexity - O(2N)


        we can reduce this a bit by modifying bruteforce

        Time Complexity - O(2N)
        Space Complexity - O(N)




        Optimal :


        ex: ratings = [0 2 4 7 6 5 4 3 2 1 1 1 2 3 4 2 1 1 1 ]

        since we need sum we can do that using slope approach and adding candies in
        incremental way irrespective of whether they are increasing slope or decreasing slope

        only thing that we need to take care of is peak element if decreasing slope is greater than increasing slope since peak must be greater than its left and right
        cumulative addition of candies will fail the condition there

        if decreasing slope is greater than increasing slope
        then sum at peak is going to be sum =sum +  downSum - peakSum

        Time Complexity - O(N)
        Space Complexity - O(1)
        let's execute





     */


    // BruteForce
    public static int maxCandies(int[] ratings){
        int n = ratings.length;

        int[] left =new  int[n];
        left[0] =1;
        int right = 1,curr=1;

        int sum = 0;


        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i] =left[i-1] +1;
            }
            else{
                left[i]= 1;
            }
        }


        sum += Math.max(left[n - 1], 1);
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                curr = right+1;

            }
            else{
                curr = 1;

            }sum += Math.max(left[i],curr);
            right = curr;
        }



        return sum;

    }

    // Optimal
    public static int candies(int[] ratings){
        int n = ratings.length;
        int sum = 1;
        int i=1;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum+=1;
                i++;
                continue;
            }
            int peak = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }
            int down= 1;

            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                down++;
                i++;
            }

            if(down>peak){
                sum +=(down-peak);
            }

        }
        return sum;
    }


    public static void main(String[] args) {

        // Test Case 1: Simple increasing and decreasing
        int[] ratings1 = {1, 0, 2};
        System.out.println("Input: " + Arrays.toString(ratings1) + " → Output: " + candies(ratings1)); // 5

        // Test Case 2: Equal Ratings
        int[] ratings2 = {1, 2, 2};
        System.out.println("Input: " + Arrays.toString(ratings2) + " → Output: " + candies(ratings2)); // 4

        // Test Case 3: Single child
        int[] ratings3 = {1};
        System.out.println("Input: " + Arrays.toString(ratings3) + " → Output: " + candies(ratings3)); // 1

        // Test Case 4: All children have the same ratings
        int[] ratings4 = {3, 3, 3, 3};
        System.out.println("Input: " + Arrays.toString(ratings4) + " → Output: " + candies(ratings4)); // 4

        // Test Case 5: Strictly decreasing ratings
        int[] ratings5 = {5, 4, 3, 2, 1};
        System.out.println("Input: " + Arrays.toString(ratings5) + " → Output: " + candies(ratings5)); // 15
    }









}
