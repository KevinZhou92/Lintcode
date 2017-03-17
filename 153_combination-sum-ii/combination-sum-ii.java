/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 17-03-07 04:23
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (num == null) {
            return results;
        }
        
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        List<Integer> path = new ArrayList<>();
        dfs(results, path, num, 0, 0, target, visited);
        return results;
    }
    
    private void dfs(List<List<Integer>> results, List<Integer> path, int[] num, int sum, int startIndex, int target, boolean[] visited) {
        if (sum == target) {
            results.add(new ArrayList(path));
            return;
        }
        if (sum > target) {
            return;
        }
        
        for (int i = startIndex; i < num.length; i++) {
            if (i != 0 && num[i] == num[i - 1] && visited[i - 1] == false) {
                continue;
            }
            path.add(num[i]); 
            visited[i] = true;
            dfs(results, path, num, sum + num[i], i + 1, target, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}