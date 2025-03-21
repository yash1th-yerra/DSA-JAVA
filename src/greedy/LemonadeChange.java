package src.greedy;

public class LemonadeChange {

    // Here if bill[i] is 5 we add it
    // if it is ten we had to decrement 5 if we have else return false
    // if it is 20 we had to decrement 1 ten and 1 five if we have both
    // else if only 5's are there and greater or equal to 3 then we can decrement 3 of them
    // else return false;

    public static boolean lemonadeChange(int[] bills) {

        int five=0,ten =0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5)five++;
            else if(bills[i]==10){
                if(five!=0) {
                    five--;
                    ten++;
                }
                else return false;
            }
            else{
                if(ten!=0 && five!=0){
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five-=3;
                }
                else return false;
            }
        }
        return true;

    }



    public static void main(String[] args) {
        int[] bill = {5,5,5,10,10,10,20};


        System.out.println(lemonadeChange(bill));


    }
}
