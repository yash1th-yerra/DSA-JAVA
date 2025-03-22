package src.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFreq {
    public static String frequencySort(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a,b) -> freq.get(b) - freq.get(a)
        );
        maxHeap.addAll(freq.keySet());


        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()){
            char current = maxHeap.poll();
            int frequency = freq.get(current);
            for(int i=0;i<frequency;i++){
                result.append(current);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        String s2 = "cccaaa";
        String s3 = "Aabb";
        String res = frequencySort(s);
        String res2 = frequencySort(s2);
        String res3 = frequencySort(s3);
        System.out.println(res  );
        System.out.println(res2  );
        System.out.println(res3 );
    }
}
