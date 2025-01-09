public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        if (lastSpaceIndex == -1) {
            return s.length();
        }
        return s.length() - lastSpaceIndex - 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String param_1 = "Hello World";
        int ret = solution.lengthOfLastWord(param_1);
        System.out.println("Length of the last word: " + ret); 
    }
}