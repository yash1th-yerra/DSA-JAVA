package src.array.medium;

public class StockBuySell {
    // Best day to buy stocks and best day to sell stocks such that the profit should be maximum
    // it is something like maximum subsequence sum

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int profit=0;
        int min=arr[0];
        int cost = 0;
        for(int i=1;i<arr.length;i++){
            cost = min - arr[i];
            profit = Math.max(profit,cost);
            min = Math.min(arr[i],min);

        }

        System.out.println(profit);
    }
}
