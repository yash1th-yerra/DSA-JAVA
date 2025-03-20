package src.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobSequencing {

    static class Job{
        int id,profit,deadline;
        Job(int id,int deadline,int profit){
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }


    private static int find(int[] parent,int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent,parent[x]);

    }

    public static int[] jobScheduling(int[] id,int[] deadline,int[] profit){
        int n = id.length;
        List<Job> jobs = new ArrayList<>();
        for(int i=0;i<n;i++){
            jobs.add(new Job(id[i],deadline[i],profit[i]));
        }

        jobs.sort((a,b) -> b.profit-a.profit);

        int maxDeadline = 0;
        for(Job job: jobs){
            maxDeadline = Math.max(maxDeadline,job.deadline);
        }

        int[] parent = new int[maxDeadline+1];
        for(int i=0;i<=maxDeadline;i++){
            parent[i] = i;

        }
        int jobCount =0,totalProfit=0;
        for(Job job : jobs){
            int availableSpot = find(parent, job.deadline);
            if(availableSpot>0){
                jobCount++;
                totalProfit+=job.profit;
                parent[availableSpot] = find(parent,availableSpot-1);

            }
        }

        return new int[]{jobCount,totalProfit};






    }


    public static void main(String[] args) {
        int[] id1 = {1, 2, 3, 4};
        int[] deadline1 = {4, 1, 1, 1};
        int[] profit1 = {20, 1, 40, 30};
        System.out.println(Arrays.toString(jobScheduling(id1, deadline1, profit1))); // [2, 60]

        int[] id2 = {1, 2, 3, 4, 5};
        int[] deadline2 = {2, 1, 2, 1, 1};
        int[] profit2 = {100, 19, 27, 25, 15};
        System.out.println(Arrays.toString(jobScheduling(id2, deadline2, profit2))); // [2, 127]

        int[] id3 = {1, 2, 3, 4};
        int[] deadline3 = {3, 1, 2, 2};
        int[] profit3 = {50, 10, 20, 30};
        System.out.println(Arrays.toString(jobScheduling(id3, deadline3, profit3)));
    }
}
