package src.bitmanipulation;

public class DivideTwoIntegers {

    // divided is integer in range [-2^31 to 2^31]



//    public static int calQuotient(int dividend, int divisor){
//        int ans = 0;
//        int sum = 0;
//        while(sum+divisor<=dividend){
//            ans+=1;
//            sum+=divisor;
//        }
//        return ans;
//    }

    public static int calQuotient(int dividend, int divisor){           //TimeComplexity - O(logdividend)^2
        if(dividend==divisor) return 1;
        boolean sign =true;
        if(dividend>=0 && divisor<0){
            sign = false;
        }
        if(dividend<0 && divisor>0){
            sign = false;
        }

        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);
        int ans = 0;
        while(dividendAbs>=divisorAbs){         // Time Complexity - O(logdividend)
            int count =0;
            while(dividendAbs>=divisorAbs<<(count+1)){           // Time Complexity - O(logdividend)
                count++;
            }
            ans+=1<<(count);
            dividendAbs-=divisorAbs<<(count);
        }

        if(ans>=Integer.MAX_VALUE && sign==false) return Integer.MIN_VALUE;
        if(ans>=Integer.MAX_VALUE && sign==true) return Integer.MAX_VALUE;
        return sign?ans:-ans;



    }


    public static void main(String[] args) {
        int dividend = 22;
        int divisor= 3;

        int ans = calQuotient(dividend,divisor);
        System.out.println(ans);
    }
}
