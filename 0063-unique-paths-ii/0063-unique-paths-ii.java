public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (grid[i][0] == 0) ? dp[i - 1][0] : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (grid[0][j] == 0) ? dp[0][j - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) { 
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0; 
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int result = solution.uniquePathsWithObstacles(grid);
        System.out.println("Number of unique paths: " + result); 
    }
}
