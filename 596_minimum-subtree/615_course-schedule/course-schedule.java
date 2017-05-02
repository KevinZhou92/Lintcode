/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/course-schedule
@Language: Java
@Datetime: 17-02-15 04:41
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0;i < numCourses; i++)
            edges[i] = new ArrayList<Integer>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int candidate = queue.poll();
            for (int i = 0; i < edges[candidate].size(); i++) {
                int point = (int)edges[candidate].get(i);
                indegree[point]--;
                if (indegree[point] == 0) {
                    queue.offer(point);
                }
            }
        }
        
        return count == numCourses;
    }
}