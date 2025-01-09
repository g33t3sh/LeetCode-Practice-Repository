public class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] param_1 = {"apple", "app", "apricot", "banana", "ap"};
        String param_2 = "ap";
        int ret = solution.prefixCount(param_1, param_2);
        System.out.println("Number of strings with prefix '" + param_2 + "': " + ret);
    }
}
