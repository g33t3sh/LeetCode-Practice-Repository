import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> positionMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (positionMap.containsKey(num)) {
                int[] pos = positionMap.get(num);
                int row = pos[0];
                int col = pos[1];
                rowCount[row]++;
                colCount[col]++;
                if (rowCount[row] == n || colCount[col] == m) {
                    return i; 
                }
            }
        }
        return -1; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 4, 2, 5, 6};
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int result = solution.firstCompleteIndex(arr, mat);
        System.out.println(result); 
    }
}