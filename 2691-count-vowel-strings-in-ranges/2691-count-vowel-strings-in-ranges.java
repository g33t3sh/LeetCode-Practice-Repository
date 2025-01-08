import java.util.*;

public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[] vowelStartEndCounts = new int[n];
        for (int i = 0; i < n; i++) {
            if (isStartAndEndWithVowel(words[i])) {
                vowelStartEndCounts[i] = 1;
            }
        }
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + vowelStartEndCounts[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = prefixSum[ri + 1] - prefixSum[li];
        }
        
        return ans;
    }
    private boolean isStartAndEndWithVowel(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"aba", "cdc", "eae", "iii", "omo"};
        int[][] queries = {{0, 2}, {1, 3}, {2, 4}};
        
        int[] result = solution.vowelStrings(words, queries);
        System.out.println("Result for queries: " + Arrays.toString(result));
    }
}
