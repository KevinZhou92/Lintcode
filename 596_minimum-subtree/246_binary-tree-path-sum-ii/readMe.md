```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum-ii
@Language: Markdown
@Datetime: 17-02-08 19:47
```

1.倒序解决问题，从当前递归层次向上回溯，满足答案值就返回
2.注意最后一步
>buffer.remove(buffer.size() - 1);
在当前迭代层次结束后，返回同层另一个递归方向，从根节点到当前点的所有路径探索完毕，需要将当前点换成同层次内其他可能的节点然后继续搜索，这一步很重要，和permutation很像