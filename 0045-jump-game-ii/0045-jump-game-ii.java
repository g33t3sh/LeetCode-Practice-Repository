public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; 
        int jumps = 0; 
        int currentEnd = 0; 
        int farthest = 0; 

        for (int i = 0; i < n - 1; i++) { 
            farthest = Math.max(farthest, i + nums[i]); 
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest; 
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums1)); 
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums2)); 
        int[] nums3 = {1, 2, 3};
        System.out.println(solution.jump(nums3)); 
        int[] nums4 = {0};
        System.out.println(solution.jump(nums4)); 
    }
}