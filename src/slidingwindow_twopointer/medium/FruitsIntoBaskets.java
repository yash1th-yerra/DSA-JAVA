package src.slidingwindow_twopointer.medium;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {


    static int maxFruitsIntoBaskets(int[] fruits){
        int maxFruits=0;
        for(int start = 0;start<fruits.length;start++){
            Map<Integer,Integer> basket = new HashMap<>();
            int currentCount= 0;
            for(int end=start;end<fruits.length;end++){
                basket.put(fruits[end],basket.getOrDefault(fruits[end],0)+1);
                if(basket.size()>2) break;
                currentCount++;
            }
            maxFruits = Math.max(maxFruits,currentCount);
        }

        return maxFruits;
    }

    static int maxFruitsIntoBasketsBetter(int[] fruits){
        int maxFruits=0;
        Map<Integer,Integer> basket = new HashMap<>();
        int left = 0;
        for(int right=0;right<fruits.length;right++){
            basket.put(fruits[right],basket.getOrDefault(fruits[right],0)+1);

            while(basket.size()>2){

                basket.put(fruits[left],basket.get(fruits[left])-1);
                if(basket.get(fruits[left])==0) basket.remove(fruits[left]);
                left++;
            }

            maxFruits = Math.max(maxFruits,right-left+1);
        }
        return maxFruits;
    }


    static void main() {
//        int[] fruits = {1, 2, 1};
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println("maximum fruits into baskets: "+maxFruitsIntoBaskets(fruits));
        System.out.println("maximum fruits into baskets: "+maxFruitsIntoBasketsBetter(fruits));
    }
}
