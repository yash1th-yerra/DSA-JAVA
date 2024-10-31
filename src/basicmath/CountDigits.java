package src.basicmath;

public class CountDigits{

    public static int countDigits(int n ){
        int count = 0;
        while(n>0){
            n = n/10;
            count++;
            
        }
        return count;
    }

    public static int countDigitsOptimized(int n ){
        int count = (int)(Math.log10(n)+1);
        
        return count;
    }


    public static void main(String [] args){
        int n = 234;

        int count  = countDigits(n);
        int countOp  = countDigitsOptimized(n);

        System.out.println("count=" +count);
        System.out.println("count=" +countOp);


        
    }
}