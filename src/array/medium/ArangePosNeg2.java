package src.array.medium;

import java.util.ArrayList;
import java.util.List;

public class ArangePosNeg2 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // If pos and neg are in different count.
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int[] res = new int[arr.length];

        for (int value : arr) {
            if (value < 0) {
                neg.add(value);
            } else {
                pos.add(value);
            }
        }

        int i = 0, pIndex = 0, nIndex = 0;

        // Alternate filling of positive and negative numbers
        while (pIndex < pos.size() && nIndex < neg.size()) {
            res[i++] = pos.get(pIndex++);
            res[i++] = neg.get(nIndex++);
        }

        // If there are remaining positive numbers
        while (pIndex < pos.size()) {
            res[i++] = pos.get(pIndex++);
        }

        // If there are remaining negative numbers
        while (nIndex < neg.size()) {
            res[i++] = neg.get(nIndex++);
        }

        // Print the result array
        for (int value : res) {
            System.out.print(value + " ");
        }
    }
}
