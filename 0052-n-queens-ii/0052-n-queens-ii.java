public class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
       
        int[] queens = new int[n];
        solveNQueens(queens, 0, n);
        return count;
    }

    private void solveNQueens(int[] queens, int row, int n) {
        if (row == n) {
            count++; 
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                solveNQueens(queens, row + 1, n); 
            }
        }
    }

    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 8;
        int result = solution.totalNQueens(n);
        System.out.println("Number of distinct solutions for " + n + "-Queens: " + result);
    }
}