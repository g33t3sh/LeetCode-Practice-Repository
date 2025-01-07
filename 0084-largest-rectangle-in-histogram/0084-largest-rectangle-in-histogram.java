import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights1));
        
        int[] heights2 = {2, 4};
        System.out.println(solution.largestRectangleArea(heights2)); 
        
        int[] heights3 = {1, 1, 1, 1};
        System.out.println(solution.largestRectangleArea(heights3));
        
        int[] heights4 = {0, 9, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(solution.largestRectangleArea(heights4)); 
    }
}