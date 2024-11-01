package src.bitmanipulation;

public class Convert2Decimal {

    public static void main(String[] args) {
        String bin = "11001011";
        int res = 0;
        int p = 1;
        for(int i=bin.length()-1;i>=0;i--){
            int digit = bin.charAt(i)-'0';
            if(digit==1){
                res = res + p;
            }
            p = p*2;
        }
        System.out.println(res);
    }
}
