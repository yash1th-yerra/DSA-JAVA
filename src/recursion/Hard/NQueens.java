package src.recursion.Hard;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {


    static boolean isSafe(int row, int col, char[][] board, int n) {
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    static void solve(int col, char[][] board, List<List<String>> ans, int n) {

        // Time Complexity - O(n!*n)
        // Space Complexity - O(n*n+n) (why? for configuring board and storing result. then extra n for stack space)


        if (col == n) {
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                curr.add(new String(board[i]));
            }
            ans.add(curr);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, n);
        return ans;
    }


    // Optimal
    // instead of traversing and checking in entire board each time we can reduce it by introducing three boolean arrays.

    static void solveOptimal(int col, char[][] board, int n, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> res) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                solveOptimal(col + 1, board, n, leftRow, upperDiagonal, lowerDiagonal, res);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    static List<List<String>> solveNQueensOptimal(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solveOptimal(0, board, n, leftRow, upperDiagonal, lowerDiagonal, res);
        return res;
    }


    static void main(String[] args) {


        // Set board size
        int n = 4;

        // Solve N-Queens
//        List<List<String>> res = solveNQueens(n);
//
//        // Print each solution
//        for (List<String> board : res) {
//            for (String row : board) {
//                System.out.println(row);
//            }
//            System.out.println();
//        }

        List<List<String>> res2 = solveNQueensOptimal(n);

        // Print each solution
        for (List<String> board : res2) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
