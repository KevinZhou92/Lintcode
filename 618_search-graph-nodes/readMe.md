```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/search-graph-nodes
@Language: Markdown
@Datetime: 17-02-10 02:51
```

1.很简单的深度搜索问题，注意corner case，当要寻找的点就是给的起始点的时候，对这个情况需要判断一下
2.另外，要再建一个hashset来储存访问过的点,这样在宽度搜索遇到的时候就跳过这个点
```java
Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();
if (!hash.contains(neighbor)) {
			q.offer(neighbor);
			hash.add(neighbor);
}


```