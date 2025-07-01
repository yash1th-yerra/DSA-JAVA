package src.heaps;

import java.util.PriorityQueue;

public class KClosestToOrigin {
    // you are given an array of arrays where each array represent points (x,y) we need to find points
    /*
        we need to find closest point to origin
        how?
        using euclidean distance
        since we are calculating it from origin distance = x^2 + y^2

        so we need to use minheap and sort values by distance since we need closest distance i.e. min dist
        we need maxHeap
    */


    public static int[][] closestToOrigin(int[][] points,int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a,b)->getDistance(b)-getDistance(a)
        );

        for(int[] point:points){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index=0;
        while(!maxHeap.isEmpty()){
            result[index++] = maxHeap.poll();
        }
        return result;
    }

    private static int getDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }


    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2},{5,8},{0,1}};
        int k =2;
        int[][] res = closestToOrigin(points,k);
        for(int[] r:res){
            for(int i:r){

                System.out.print(i+" ");
            }
            System.out.print("  ");
        }
    }
}
