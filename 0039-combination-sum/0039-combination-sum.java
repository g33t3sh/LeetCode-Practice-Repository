import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(result, currentList, candidates, target, 0);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return; 
        } else if (remain == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                
                currentList.add(candidates[i]); 
                backtrack(result, currentList, candidates, remain - candidates[i], i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
