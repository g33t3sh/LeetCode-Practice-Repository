public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pChar == '?' || sChar == pChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        Solution matcher = new Solution();
        String param_1 = "adceb";
        String param_2 = "*a*b";
        boolean ret = matcher.isMatch(param_1, param_2);
        System.out.println("Does the string match the pattern? " + ret); 
    }
}