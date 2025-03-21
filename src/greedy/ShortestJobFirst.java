package src.greedy;

import java.util.Arrays;

public class ShortestJobFirst {

    // each process should be allocated based on minimum shortest job as first
    // so we can sort them since bursttimes are given
    // lets say
    // 4 , 1 , 2 , 5
    // process 1 -> 0 = 0
    // process 2 -> 0 + 1 = 1
    // process 3 -> 0 + 1 + 2 = 3
    // process 4 -> 0 + 1 + 2 + 4 = 7

    // total waiting time = 0 + 1+ 3+ 7 = 11
    // total no of process = 4
    // average waiting time = 11/4 = 2.75 ~ 2


    public static int findAvgWaitingTime(int[] bt){
        if(bt.length<=1) return 0;

        Arrays.sort(bt);
        int waitingTime = 0;
        int burstTimePerProcess = 0;

        for(int i=0;i<bt.length;i++){
            waitingTime+=burstTimePerProcess;
            burstTimePerProcess+=bt[i];

        }
        return waitingTime/bt.length;

    }


    public static void main(String[] args) {
        int[] bt = {1,3,2,4,7};
        System.out.println(findAvgWaitingTime(bt));
    }



}
