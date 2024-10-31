package src.basicmath;

import java.util.ArrayList;
import java.util.List;

public class PrintDivisors {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int n = 36;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                list.add(i);
                if(i!=n/i){
                    list.add(n/i);
                }

            }
        }

        list.sort((a,b)->a-b);

        System.out.println(list);
    }
}
