import java.util.*;

public class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            String str1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String str2 = words[j];
                if (isPrefixAndSuffix(str1, str2)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isPrefixAndSuffix(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        
        if (len1 > len2) {
            return false; 
        }
        if (!str2.startsWith(str1)) {
            return false;
        }
        if (!str2.endsWith(str1)) {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] words = {"aba", "ababa", "abc", "abcd"};
        int result = solution.countPrefixSuffixPairs(words);
        System.out.println("Number of prefix-suffix pairs: " + result);
    }
}
