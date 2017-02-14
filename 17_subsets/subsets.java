/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 17-01-17 19:19
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<> ();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> subset =  new ArrayList<Integer>();
        subsetSearch(0, nums, subset, results);
        return results;
    }
    
    private void subsetSearch(int startIndex, int[] nums, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results) {
        
        results.add(new ArrayList<Integer>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetSearch(i + 1, nums, subset, results);
            subset.remove(subset.size()-1);
        }
    }
}