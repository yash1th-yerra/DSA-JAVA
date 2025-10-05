package src.array.basic;

public class CheckSorted {


    public static boolean findSorted(int[] arr){    // Time Complexity - O(N)


        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {5,2,2,1,6};
        int[] arr2 = {1,2,3,4,5};

        if(findSorted(arr)){
            System.out.println("Sorted");
        }
        else{
            System.out.println("Not Sorted");
        }

    }
}
