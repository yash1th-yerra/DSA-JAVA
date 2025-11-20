package src.stacks.implementations;

public class CelebrityProblem {

    static int findCelebBrute(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[] knowMe =new int[n];
        int[] iKnow =new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(knowMe[i]==n-1 && iKnow[i]==0) return i;
        }

        return -1;

    }

    static int findCelebOptimal(int[][] arr){
        int n = arr.length;
        int top=0,down=n-1;
        while(top<down){
            if(arr[top][down]==1) top++;
            else if (arr[down][top]==1) down--;
            else {
                top++;
                down--;
            }



        }
        if(top>down) return -1;
        for(int i=0;i<n;i++){
            if(i==top) continue;
            if(arr[top][i]==1 || arr[i][top]==0) return -1;

        }
        return top;

    }

    static void main() {
        int[][] arr = {{0, 0, 0, 0}, {1, 0, 0, 0}, {1, 1, 0, 0}, {1, 1, 1, 0}};
        int celeb = findCelebBrute(arr);
        System.out.println("Celebrity is: "+celeb);
    }

}
