package src.bitmanipulation;

public class DivideTwoIntegers {

    // dividend is integer in range [-2^31 to 2^31]



//    public static int calQuotient(int dividend, int divisor){
//        int ans = 0;
//        int sum = 0;
//        while(sum+divisor<=dividend){
//            ans+=1;
//            sum+=divisor;
//        }
//        return ans;
//    }




    // optimal approach
    // lets take example like 22/7 quotient - 3 this is our answer
    // dividend = 22, divisor = 7
    // 7 * 2^k <=dividend we have to increment k value until that condition is true(k is nothing but count in code)
    // once condition fails we have to add 2^k value to ans and remove and divisor*2^k from dividend
    // once that is done we have to check if dividend is still greater than divisor if so we continue same process till divident becomes less than divisor


    // edge cases and constraints
    // if either of divisor or divident is less zero we have to make a flag to indicate answer to be negative as sign
    // if answer is greater that max value and sign is +ve then return max value
    // if answer is greater than max but sign is -ve then return min value
    // if above two conditions failed based on sign we make the number either -ve or +ve

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
