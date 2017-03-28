```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Markdown
@Datetime: 17-02-17 15:26
```

1.典型的深度优先问题，从source点出发，逐步访问，这里有两种思路，可以设置一个map去记录每个点的step值，这样进入队列的每个点都会记录自己的状态，也可以遍历每层node时，先获得此层node的数量，然后逐一对这些点处理，获得neighbor，如果这个neighbor已经访问过，那么不加入队列
2. **注意细节，如果是copy一个graph，那么对于当前所处的层次没有要求，就不要求记录当前的状态，如果类似这种统计步数，或者最短路径时，就需要记录BFS每层的节点数量**