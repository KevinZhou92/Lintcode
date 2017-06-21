/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/high-five
@Language: Java
@Datetime: 17-04-08 20:58
*/

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                map.put(r.id, new ArrayList<Integer>());
            }
            if (map.get(r.id).size() < 5) {
                map.get(r.id).add(r.score);
            } else {
                int index = 0;
                for (int i = 0; i < 5; i++) {
                    if (map.get(r.id).get(i) < map.get(r.id).get(index)) {
                        index = i;
                    }
                }
                if (map.get(r.id).get(index) < r.score) {
                    map.get(r.id).set(index, r.score);
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> pair : map.entrySet()) {
            double ans = 0;
            int id = pair.getKey();
            List<Integer> list = pair.getValue();
            for (int i = 0; i < 5; i++) {
                ans += list.get(i);
            }
            ans = ans / 5.0;
            res.put(id, ans);
        }
        return res;
    }
}