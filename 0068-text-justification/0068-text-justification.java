import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> result = new Solution().fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println(line);
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int j = i;
            int lineLength = 0;
            while (j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder();
            int numWords = j - i;
            int totalSpaces = maxWidth - lineLength;
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" "); 
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spaceBetweenWords = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaceBetweenWords; s++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            result.add(line.toString());
            i = j; 
        }
        return result;
    }
}