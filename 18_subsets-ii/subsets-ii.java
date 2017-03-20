/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 17-02-25 15:29
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums ==  null) {
            return results;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(results, path, nums, 0, visited);
        return results;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> results, 
                        ArrayList<Integer> path, 
                        int[] nums, 
                        int startIndex, 
                        boolean[] visited) {
        results.add(new ArrayList(path));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && visited[i -1] == false ) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(results, path, nums, i + 1, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
