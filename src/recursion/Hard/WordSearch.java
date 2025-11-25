package src.recursion.Hard;

public class WordSearch {

    static boolean searchNext(char[][] board,String word,int index,int row,int col,int n,int m){
        if(index==word.length()){
            return true;
        }
        if(row<0 || col<0 || row==n || col==m || board[row][col]!=word.charAt(index) || board[row][col]=='!') return false;
        char c = board[row][col];
        board[row][col] = '!';
        boolean top = searchNext(board,word,index+1,row-1,col,n,m);
        boolean right = searchNext(board,word,index+1,row,col+1,n,m);
        boolean bottom = searchNext(board,word,index+1,row+1,col,n,m);
        boolean left = searchNext(board,word,index+1,row,col-1,n,m);
        board[row][col]=c;
        return top || bottom || right || left;
    }


    static boolean exist(char[][] board,String word){
        int n = board.length;
        int m = board[0].length;
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(index)){
                    if(searchNext(board,word,index,i,j,n,m)) return true;
                }
            }
        }
        return false;
    }

    static void main() {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";


        boolean res = exist(board, word);
        System.out.println(res);
    }
}
