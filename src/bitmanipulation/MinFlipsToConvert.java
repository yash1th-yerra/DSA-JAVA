package src.bitmanipulation;

public class MinFlipsToConvert {
    public static void main(String[] args) {
        int n1 = 16;
        int n2  = 15;
        int ans = n1 ^ n2;
        int cnt = 0;
        for(int i=0;i<=31;i++){
            if((ans&(1<<i))!=0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
