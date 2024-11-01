package src.bitmanipulation;

public class Convert2Binary {

    public static void main(String[] args) {
        int n = 12;
        String res="";
        while(n!=0){
            if(n%2==0) res+="0";
            else res+="1";
            n/=2;
        }
        StringBuilder stringBuilder = new StringBuilder(res);
        String reversedRes = stringBuilder.reverse().toString();

        System.out.println(reversedRes);
    }
}
