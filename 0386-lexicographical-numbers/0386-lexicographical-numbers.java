import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i <= 9; i++) {
            dfs(current * 10 + i, n, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13; 
        List<Integer> result = solution.lexicalOrder(n);
        System.out.println("Numbers in lexicographical order: " + result);
    }
}