```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sequence-reconstruction
@Language: Markdown
@Datetime: 17-04-30 04:55
```

1.这道题采用了拓扑排序，将sequence想象成图中的点和边，在org中就是排好序的点，并且这里的先后顺序很严格，不存在两点并列的情况，我们先扫描org序列，获得所有的存在于图中的点，建立点的和点指向的点的映射，然后建立每个点的indegree的映射，然后处理seqs序列，获得点与点之间的指向和相连关系，统计各个点的indegree数量，在这个过程中可以添加判断seq中的值是不是在org范围之内，如果不在，那可以直接返回false结果，要特别注意一些cornercase， 比如说：[5,3,2,4,1], [[5,3,2,4],[4,1],[1],[3],[2,4], [1000000000]]，这个情况下，由于我们是按照org的内容来创建映射，按照sequence的内容来统计连接情况，那么可能导致这个多余的1000000处理不到，需要在扫描sequence的时候进行判断，确保所有数据都在范围之内
2.java的运算符优先级需要注意，当if条件中出现多个逻辑判断符时，一定要注意先后的取值顺序，稳妥起见，要加括号来提升优先级
