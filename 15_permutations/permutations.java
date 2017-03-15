/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 17-02-25 14:49
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) {
            return results;
        }
        
        List<Integer> path = new ArrayList<>();
        dfs(results, path, nums);
        return results;
    }
    private void dfs(List<List<Integer>> results, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            results.add(new ArrayList(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(results, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
