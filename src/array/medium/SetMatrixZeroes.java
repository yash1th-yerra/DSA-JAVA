package src.array.medium;

public class SetMatrixZeroes {


    /*
        you are given n*m matrix with elements 0's and 1's , it there is 0 then you have to replace every element
        in that corresponding row and column with zero.

        1 1 1 1                         1 0 0 1
        1 0 0 1                         0 0 0 0
        1 1 0 1         -------->       0 0 0 0
        1 1 1 1                         1 0 0 1
    */

    // brute force

    /*
        1. traverse through the matrix
        2. if zero appears mark anything apart from zero's in that column and row with -1
        3. once done traverse again and replace -1 with 0
    */

    private static void markRow(int[][] arr,int row,int m){
        for(int j=0;j<m;j++){
            if(arr[row][j]!=0){
                arr[row][j]=-1;
            }
        }
    }

    private static void markCol(int[][] arr,int col,int n){
        for(int i=0;i<n;i++){
            if(arr[i][col]!=0){
                arr[i][col]=-1;
            }
        }
    }

    public static void replaceZeroes(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,i,m);
                    markCol(matrix,j,n);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }



    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        replaceZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+  " ");
            }
            System.out.println();
        }
    }




}
