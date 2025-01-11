import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "annabelle";
        int k1 = 2;
        boolean result1 = solution.canConstruct(s1, k1);
        System.out.println("Can construct " + k1 + " palindromes from \"" + s1 + "\": " + result1);
        String s2 = "leetcode";
        int k2 = 3;
        boolean result2 = solution.canConstruct(s2, k2);
        System.out.println("Can construct " + k2 + " palindromes from \"" + s2 + "\": " + result2);
        String s3 = "true";
        int k3 = 4;
        boolean result3 = solution.canConstruct(s3, k3);
        System.out.println("Can construct " + k3 + " palindromes from \"" + s3 + "\": " + result3);
    }
}
