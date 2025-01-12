public class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false; 
        }
        int open = 0; 
        int close = 0; 
        int free = 0; 
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    open++;
                } else {
                    close++;
                }
            } else {
                free++; 
            }
            if (close > open + free) {
                return false;
            }
        }
        open = 0;
        close = 0;
        free = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    close++;
                } else {
                    open++;
                }
            } else {
                free++; 
            }
            if (open > close + free) {
                return false;
            }
        }
        return true; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "())()";
        String locked = "01000";
        System.out.println(solution.canBeValid(s, locked)); 
    }
}