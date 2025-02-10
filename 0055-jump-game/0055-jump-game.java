public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums1)); 

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums2)); 
    }
}