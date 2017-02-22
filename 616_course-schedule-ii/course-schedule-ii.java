/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/course-schedule-ii
@Language: Java
@Datetime: 17-02-15 06:23
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        int[] result = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
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
        
        Queue<Integer> schedule = new LinkedList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int course = queue.poll();
            schedule.offer(course);
            for (int i = 0; i < edges[course].size(); i++) {
                int candidate = (int)edges[course].get(i);
                indegree[candidate]--;
                if (indegree[candidate] == 0) {
                    queue.offer(candidate);
                }
            }
        }
        
        if (count == numCourses) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = (int)schedule.poll();
            }
            return result;
        }
        return new int[0];
    }
}