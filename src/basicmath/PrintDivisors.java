package src.basicmath;

import java.util.ArrayList;
import java.util.List;

public class PrintDivisors {


    /*
    36
    1*36
    2*18
    3*12
    4*9
    6*6 (but here we are having i and n/i same numbers which may iinclude duplicates in such case we just need to include i not n/i.
    ---------------------- below are just repetitions of above in reverse order so until here we need to store
    i and n/i
    9*4
    12*3
    18*2
    36*1


    */


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
