```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/minimum-subtree
@Language: Markdown
@Datetime: 17-01-30 23:36
```

1.此题和Maximum Average Subtree题目一个思路，divide and conquer和递归
2.由于题目中自己有一个树节点的对象，我们只要再设计一个私有的记录每个节点的结果对象就可以，同时设立一个全局变量，方便对象实例化后用来记录当前最小和的节点以及这个最小和
3.最后就是分别每个字数做同样的计算，统计节点之和，然后和全局变量比较，如果小于就更换掉，这样多次迭代，递归得到最后结果
4.注意corner case