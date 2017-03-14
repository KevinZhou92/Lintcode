/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 17-03-07 02:58
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        
        Set<List<Integer>> visited = new HashSet<>();
        Arrays.sort(candidates);
        
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[index] != candidates[i]) {
                candidates[++index] = candidates[i]; 
            }
        }
        
        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        
        
        List<Integer> path = new ArrayList<>();
        helper(results, path, nums, target, 0, 0);
        return results;
    }
    
    private void helper(List<List<Integer>> results, List<Integer> path, int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            results.add(new ArrayList(path));
            return;
        }
        
        
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(results, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}