/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 17-01-18 23:38
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
         ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null ) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        premutation(nums, new ArrayList<Integer>(), results);
        return results;
        
    }
    
    private void premutation(int[] nums, ArrayList<Integer> set, ArrayList<List<Integer>> results) {
        if (set.size() == nums.length) {
            results.add(new ArrayList<Integer>(set));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            premutation(nums, set, results);
            set.remove(set.size()-1);
        }
        
    }
}
