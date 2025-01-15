public class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitsCount = Integer.bitCount(num2);
        int x = 0;
        for (int i = 31; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0 && setBitsCount > 0) {
                x |= (1 << i); 
                setBitsCount--; 
            }
        }
        for (int i = 0; i < 32 && setBitsCount > 0; i++) {
            if ((x & (1 << i)) == 0) { 
                x |= (1 << i); 
                setBitsCount--; 
            }
        }
        return x;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num1 = 1;
        int num2 = 12;
        int result = solution.minimizeXor(num1, num2);
        System.out.println("Result for num1 = " + num1 + " and num2 = " + num2 + ": " + result); 
        num1 = 3;
        num2 = 5;
        result = solution.minimizeXor(num1, num2);
        System.out.println("Result for num1 = " + num1 + " and num2 = " + num2 + ": " + result); 
    }
}