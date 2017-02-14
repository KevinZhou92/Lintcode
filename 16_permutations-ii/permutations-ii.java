/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 17-01-19 15:56
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
           
        if (nums == null) {
           return results;
       } 
    
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        int[] visited = new int[nums.length];
        for (int i = 0; i< nums.length; i++) {
            visited[i] = 0;
        }
        Arrays.sort(nums);
        search(visited, nums,new ArrayList<Integer>(), results);
        return results;
    }
    
    private void search(int[] visited, int[] nums, ArrayList<Integer> set, ArrayList<List<Integer>> results) {
        if (set.size() == nums.length) {
            results.add(new ArrayList<Integer>(set));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || i !=0 && nums[i] == nums[i-1] && visited[i-1] == 0) {
                continue;
            }
            visited[i] = 1;
            set.add(nums[i]);
            search(visited, nums, set, results);
            visited[i] = 0;
            set.remove(set.size() - 1);
        }
    }
    
    
}


