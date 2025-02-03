import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                merged.add(currentInterval);
                currentInterval = intervals[i]; 
            }
        }
        merged.add(currentInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };
        int[][] mergedIntervals = solution.merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}