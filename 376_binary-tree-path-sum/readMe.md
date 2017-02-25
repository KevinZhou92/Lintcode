```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Markdown
@Datetime: 17-02-03 01:32
```

1.仍然是DFS，和Subset以及Permutation大同小异，注意总结归纳
2.熟悉Collection的用法和性质
3.仍然是初始条件，corner case要细心辨别,此处是一直加到根节点，所以判别条件不能加上sum < target, 中间允许超过