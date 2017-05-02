/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/strstr-ii
@Language: Java
@Datetime: 17-01-18 19:16
*/

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
       final int BASE = 100000;
       if (source == null || target == null) {
           return -1;
       }
       
       if (target.equals("")) {
           return 0;
       }
       
       int m = target.length();
       
       //power of the first letter
       
       int power = 1;
       for (int i = 0; i < m ; i++) {
           power = power * 31 ;
       }
       
       //hashcode for target
       int targetHash = 0;
       for (int i = 0; i < m; i++) {
           targetHash = targetHash * 31 + target.charAt(i) ;
       }
       
       //hashcode at source
       int hashCode = 0;
       for (int i = 0; i < source.length(); i++) {
            hashCode = (hashCode * 31 + source.charAt(i)) ;
        
        if (i < m -1 ) {
            continue;
        }
        if (i >= m ) {
            hashCode = hashCode - (power * source.charAt(i - m)) ;
            //if(hashCode < 0){
              //  hashCode += BASE;
            //}
        }
        
        if (hashCode == targetHash) {
            if (source.substring(i - m + 1, i + 1).equals(target)) {
                return i - m + 1;
            }
        }
    }
       return -1;
    }
}