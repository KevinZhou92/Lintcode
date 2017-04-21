/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 17-04-04 00:47
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -numbers[i];
            twoSum(res, numbers, target, i + 1, numbers.length - 1);
        }
        return res;
    }
    private void twoSum(ArrayList<ArrayList<Integer>> res, int[] numbers, int target, int start, int end) {
        while (start < end) {
            long sum = numbers[start] + numbers[end];
            if (target < sum) {
                end--;
            } else if (target > sum) {
                start++; 
            } else {
                ArrayList<Integer> path = new ArrayList<>();
                path.add(-target);
                path.add(numbers[start]);
                path.add(numbers[end]);
                res.add(path);
                start++;
                end--;
                while (start < end && numbers[start] == numbers[start - 1]) {
                    start++;
                }
                while (start < end && numbers[end] == numbers[end + 1]) {
                    end--;
                }
            }
        }
    }
}