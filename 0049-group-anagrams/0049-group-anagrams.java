import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            java.util.Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs1)); 
        String[] strs2 = {""};
        System.out.println(solution.groupAnagrams(strs2)); 
        String[] strs3 = {"a"};
        System.out.println(solution.groupAnagrams(strs3)); 
    }
}