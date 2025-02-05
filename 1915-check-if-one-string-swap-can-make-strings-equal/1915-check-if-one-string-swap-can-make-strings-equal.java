public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] diffIndices = new int[2];
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffCount < 2) {
                    diffIndices[diffCount] = i;
                }
                diffCount++;
            }
        }
        if (diffCount == 2) {
            int i = diffIndices[0];
            int j = diffIndices[1];
            return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();   
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(solution.areAlmostEqual(s1, s2)); 
        s1 = "attack";
        s2 = "defend";
        System.out.println(solution.areAlmostEqual(s1, s2)); 
        s1 = "abcd";
        s2 = "badc";
        System.out.println(solution.areAlmostEqual(s1, s2)); 
    }
}