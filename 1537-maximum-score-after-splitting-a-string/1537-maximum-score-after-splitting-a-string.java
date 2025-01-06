public class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        int maxScore = 0;
        int leftZeros = 0;
        for (int i = 0; i < s.length() - 1; i++) { 
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                totalOnes--; 
            }
            int currentScore = leftZeros + totalOnes;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "011101";
        int result = solution.maxScore(s);
        System.out.println("Maximum score after splitting: " + result); 
    }
}