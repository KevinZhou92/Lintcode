/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 17-04-04 03:00
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long sum = 0;
        for (int i = 0; i < key.length; i++) {
            sum = (sum * 33  + key[i]) % HASH_SIZE;
        }
        
        
        return (int)sum;
    }
}