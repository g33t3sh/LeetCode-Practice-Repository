import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> resultSet = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    resultSet.add(words[i]);
                    break; 
                }
            }
        }
        
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"mass", "as", "hero", "superhero", "heroic", "her"};
        List<String> substrings = solution.stringMatching(words);
        System.out.println(substrings);
    }
}