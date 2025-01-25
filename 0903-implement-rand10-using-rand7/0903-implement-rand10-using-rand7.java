import java.util.Random;
public class Solution {
    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
    public int rand10() {
        int num;
        do {
            num = (rand7() - 1) * 7 + rand7();
        } while (num > 40); 
        return (num - 1) % 10 + 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10; 
        for (int i = 0; i < n; i++) {
            System.out.println(solution.rand10());
        }
    }
}