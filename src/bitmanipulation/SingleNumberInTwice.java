package src.bitmanipulation;

public class SingleNumberInTwice {

    public static void main(String[] args) {
        int[] arr = {4,1,2,2,1};
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = ans ^ arr[i];

        }
        System.out.println(ans);
    }
}
