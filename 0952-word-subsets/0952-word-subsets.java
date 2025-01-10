import java.util.HashMap;
import java.util.Map;
public class Solution {
    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        List<String> result = new Solution().wordSubsets(words1, words2);
        System.out.println(result); 
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (String word : words2) {
            Map<Character, Integer> tempMap = getCharCount(word);
            for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
                charCountMap.put(entry.getKey(), Math.max(charCountMap.getOrDefault(entry.getKey(), 0), entry.getValue()));
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            Map<Character, Integer> tempMap = getCharCount(word);
            boolean isUniversal = true;
            for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                if (tempMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(word);
            }
        }
        return result;
    }
    private Map<Character, Integer> getCharCount(String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }
}