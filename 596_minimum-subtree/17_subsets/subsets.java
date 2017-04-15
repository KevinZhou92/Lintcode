/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 17-02-25 15:20
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums ==  null) {
            return results;
        }
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(results, path, nums, 0);
        return results;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> path, int[] nums, int startIndex) {
        
        results.add(new ArrayList(path));
        
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(results, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}