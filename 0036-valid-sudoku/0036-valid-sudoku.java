public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9]; 
        boolean[][] cols = new boolean[9][9]; 
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') { 
                    int n = num - '1'; 
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (rows[i][n] || cols[j][n] || boxes[boxIndex][n]) {
                        return false; 
                    }
                    rows[i][n] = true;
                    cols[j][n] = true;
                    boxes[boxIndex][n] = true;
                }
            }
        }

        return true; 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean isValid = solution.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + isValid);   }
}