class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = generateNext(result);
        }
        return result;
    }
    private String generateNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char current = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            } else {
                sb.append(count);
                sb.append(current);
                current = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(current);
        
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5; 
        String result = solution.countAndSay(n);
        System.out.println("The " + n + "th element of the count-and-say sequence is: " + result);
    }
}
