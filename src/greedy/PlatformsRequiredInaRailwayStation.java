package src.greedy;

import java.util.Arrays;

public class PlatformsRequiredInaRailwayStation {



    // given two arrays representing arrival and departure times of trains
    // if there is any overlapping of timings of trains then we need new platform
    // in such way how many minimum number of platforms required


    // so we need to count maximum intersections of train timings
    // arr = [900 945 955 1100 1500 1800] -> [9:00 9:45 9:55 11:00 15:00 18:00]
    // dep = [920 1200 1130 1150 1900 2000]

    // so here we need to check if a new train arrives before previous train ends then we required a new platform
    // hint : maximum no of intersections = minimum number of platforms required

//    public static int findPlatforms(int[] arr, int[] dep){
//        int maxCount = 0;
//
//        for(int i=0;i<arr.length;i++){
//            int count = 1;
//            for(int j=0;j<arr.length;j++){
//                if(i!=j && arr[j] >= arr[i] && arr[j] <= dep[i]){
//                    count++;
//                }
//            }
//                maxCount = Math.max(count,maxCount);
//        }
//        return maxCount;
//
//    }
    // there are some inconsistencies in brute force approach

    public static int findPlatforms(int[] arr, int[] dep){
        int maxCount =0;

        int n =arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int l =0,r=0;



        int cnt = 0;
        while(l<n){

            if(arr[l]<=dep[r]){
                cnt++;
                l++;
            }else{
                cnt--;
                r++;
            }
            maxCount = Math.max(cnt,maxCount);
        }



        return maxCount;
    }

    public static void main(String[] args) {

            int[] arr = {900, 945, 955, 1100, 1500, 1800};
            int[] dep = {920, 1200, 1130, 1150, 1900, 2000};


            int[] arr2 = {1114 ,825 ,357 ,1415 ,54};
            int[] dep2 = {1740 ,1110 ,2238 ,1535 ,2323};

            System.out.println("Minimum platforms required: " + findPlatforms(arr, dep));
            // Output: 3
            System.out.println("Minimum platforms required: " + findPlatforms(arr2, dep2));
            // Output: 5

    }


}
