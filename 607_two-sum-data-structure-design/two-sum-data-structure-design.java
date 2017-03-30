/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-data-structure-design
@Language: Java
@Datetime: 17-03-28 14:17
*/

public class TwoSum {
    private ArrayList<Integer> array;
    private Map<Integer, Integer> map;
    
    public TwoSum(){
        array = new ArrayList<>();
        map = new HashMap<>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        array.add(number);
        if (!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int i = 0; i < array.size(); i++) {
            int num1 = array.get(i), num2 = value - num1;
            if (num1 != num2 && map.containsKey(num2) || num1 == num2 && map.get(num1) > 1) {
                return true;
            }
         }
        return false;
        
    }    
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);