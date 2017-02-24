```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Markdown
@Datetime: 17-02-14 21:04
```

1.可以使用并查集求解，想象成灌水问题， 从一个点往里面灌水，能达到所有连接的点，那么从指定的联通集合中任一点灌水，所达到的效果是一样的，然后逐步检查edge，当存在一个edge的两端是在一个联通的集合中时，说明并查集中存在环，那么此时不是一个valid tree
2.典型做法是深度优先搜索，从任意一点出发，将访问过的点加入一个set当中，然后遍历每个点，将所连路径另一端端点加入队列等待访问，如果这个端点已经访问过就跳，此处注意，不是所有的点都连接在一起，存在这样一种情况，点被分为分开的连通部分，然后在当中存在自环，仍然存在：
> \# of nodes - 1= # of edges

但是这显然不是一个valid tree，要注意这个corner case