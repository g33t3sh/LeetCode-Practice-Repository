import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        k--; 
        StringBuilder permutation = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = k / factorials[n - 1 - i];
            permutation.append(numbers.get(index));
            numbers.remove(index); 
            k %= factorials[n - 1 - i]; 
        }

        return permutation.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int k = 3;
        System.out.println(solution.getPermutation(n, k));
        
        n = 4;
        k = 9;
        System.out.println(solution.getPermutation(n, k)); 
    }
}