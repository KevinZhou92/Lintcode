/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 17-02-25 15:00
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(results, path, nums, visited);
        return results;
    } 
    
    private void dfs(List<List<Integer>> results, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            results.add(new ArrayList(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i] && visited[i - 1] == false || visited[i] == true) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(results, path, nums, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}


