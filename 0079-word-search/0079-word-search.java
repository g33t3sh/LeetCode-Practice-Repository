public class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true; 
                }
            }
        }
        return false; 
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#'; 
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (backtrack(board, word, newRow, newCol, index + 1)) {
                return true; 
            }
        }
        board[i][j] = temp;
        return false; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean result = solution.exist(board, word);
        System.out.println("Word exists: " + result); 
    }
}