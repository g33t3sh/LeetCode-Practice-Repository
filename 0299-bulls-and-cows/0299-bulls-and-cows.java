import java.util.HashMap;
import java.util.Map;
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> secretCount = new HashMap<>();
        Map<Character, Integer> guessCount = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char sChar = secret.charAt(i);
            char gChar = guess.charAt(i);
            if (sChar == gChar) {
                bulls++;
            } else {
                secretCount.put(sChar, secretCount.getOrDefault(sChar, 0) + 1);
                guessCount.put(gChar, guessCount.getOrDefault(gChar, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : guessCount.entrySet()) {
            char gChar = entry.getKey();
            if (secretCount.containsKey(gChar)) {
                cows += Math.min(secretCount.get(gChar), entry.getValue());
            }
        }
        return bulls + "A" + cows + "B";
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String secret = "1807";
        String guess = "7810";
        String hint = solution.getHint(secret, guess);
        System.out.println(hint); 
    }
}
