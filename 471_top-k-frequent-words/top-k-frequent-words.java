/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Java
@Datetime: 17-04-11 20:31
*/

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
     
     private class Ele {
         int count;
         String word;
         public Ele(String word, int x) {
             this.word = word;
             this.count = x;
         }
     }
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words.length <= 0) {
            return words;
        }
        if (k == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        
        Queue<Ele> pq = new PriorityQueue<Ele>(k, new Comparator<Ele>() {
           public int compare(Ele a, Ele b) {
               if (a.count == b.count) {
                   return b.word.compareTo(a.word);
               } else {
                   return a.count - b.count;
               }
           } 
        }); 
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String temp = entry.getKey();
            int count = entry.getValue();
            pq.add(new Ele(temp, count));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        String[] res = new String[k];
        int index = k - 1;
        while (!pq.isEmpty()) {
            res[index--] = pq.poll().word;
        } 
        return res;
 }
}