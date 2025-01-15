public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n; 
        }
        return power(x, n);
    }
    private double power(double x, int n) {
        if (n == 0) {
            return 1; 
        }
        double half = power(x, n / 2); 
        if (n % 2 == 0) {
            return half * half; 
        } else {
            return half * half * x; 
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, 10)); 
        System.out.println(solution.myPow(2.10000, 3)); 
        System.out.println(solution.myPow(2.00000, -2));
    }
}