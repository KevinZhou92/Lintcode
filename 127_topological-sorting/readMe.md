```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Markdown
@Datetime: 17-04-30 16:06
```

1.Just classic topological sort, be careful for the details
2.Can use map to store the indegree counts and the node, use queue to record the order of all the nodes
3.这里可以不先统计indegree为0的点，因为在map建立各点的indegree关系时，如果，当前点indegree为0，则不会加入indegree关系中，那么在建立初始队列时，扫描看graph中哪个点不在indegree中，也就是indegree为0， 然后加入队列和结果中即可