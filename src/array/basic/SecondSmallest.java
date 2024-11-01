package src.array.basic;

public class SecondSmallest {

    public static void main(String[] args) {
        int[] arr = {5,3,2,1,1,4,4,6,7,8,9};;
        int min = arr[0];
        int sec = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){min = arr[i];}

        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<sec && arr[i]!=min){sec = arr[i];}
        }
        System.out.println(sec);

    }
}
