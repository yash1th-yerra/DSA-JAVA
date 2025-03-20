package src.greedy;

import java.sql.Array;
import java.util.*;

public class FractionalKnapsack {


    /*
        you are give two lists/arrays indicating weight and its profit
        wt = [20,10,50,50] and profit = [100,60,100,200]

        we need to select items with weights such that we get maximum profit
        here the catch is we can only select until the capacity

        if at any point weight is greater than capacity we can take a part of it (fraction)


        val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50

        lets dry run :

        if we pickup 10 -> 60 (cap = 40)
        20 -> 100+60 = 160 (cap = 20)
        30 -> 160 + 20/30* 120 =  240 (cap = 0)

        max profit = 240


        how to select if we have diff order

        very simple sort each item by profit/weight -> this will give you profit for 1 wt
        so it is simple to get maximum profit if we go greedily
        also if wt[i] is greater than capacity the we can take maximum element's fraction of remaining weights

    */
    static class Item{
        int wt,val;
        Item(int wt,int val){
            this.wt = wt;
            this.val = val;
        }
    }

    static double fractionalKnapsack(int capacity,List<Integer> val, List<Integer> wt) {
        // code here
        List<Item> items= new ArrayList<>();

        for(int i=0;i<wt.size();i++){
            items.add(new Item(wt.get(i), val.get(i)));
        }

        items.sort((a, b) -> Double.compare((double)b.val / b.wt, (double)a.val / a.wt));
        double profit = 0.0;
        for(Item item : items) {
            if(item.wt <capacity){
                profit+=item.val;
                capacity-=item.wt;
            }
            else{
                profit+=((double)capacity/item.wt)*item.val;
                break;
            }

        }

        return profit;


    }

    public static void main(String[] args) {
        List<Integer> val1 = Arrays.asList(60, 100, 120);
        List<Integer> wt1 = Arrays.asList(10, 20, 30);
        int capacity1 = 50;
        System.out.println("Maximum value: " + fractionalKnapsack(capacity1, val1, wt1)); // Output: 240.0

        // Test Case 2
        List<Integer> val2 = Arrays.asList(500, 300, 400);
        List<Integer> wt2 = Arrays.asList(30, 20, 40);
        int capacity2 = 50;
        System.out.println("Maximum value: " + fractionalKnapsack(capacity2, val2, wt2)); // Output: 800.0

        // Test Case 3 (All items fit)
        List<Integer> val3 = Arrays.asList(70, 80, 100);
        List<Integer> wt3 = Arrays.asList(10, 15, 25);
        int capacity3 = 60;
        System.out.println("Maximum value: " + fractionalKnapsack(capacity3, val3, wt3)); // Output: 250.0

        // Test Case 4 (Knapsack capacity is 0)
        List<Integer> val4 = Arrays.asList(10, 20);
        List<Integer> wt4 = Arrays.asList(5, 10);
        int capacity4 = 0;
        System.out.println("Maximum value: " + fractionalKnapsack(capacity4, val4, wt4)); // Output: 0.0

        // Test Case 5 (Single item larger than capacity)
        List<Integer> val5 = Arrays.asList(50);
        List<Integer> wt5 = Arrays.asList(100);
        int capacity5 = 20;
        System.out.println("Maximum value: " + fractionalKnapsack(capacity5, val5, wt5)); // Output: 10.0
    }
}
