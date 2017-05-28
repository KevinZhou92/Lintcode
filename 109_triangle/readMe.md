```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Markdown
@Datetime: 17-05-06 15:04
```

1.这道题是要求矩阵按指定位置排放成三角形，然后求从上到下的基本路径，而不是将每行矩阵左对齐排列，按照三角形排列时，adjacent的numbers只有下面左右两个，所以在动态规划时注意细节，然后注意每一个位置都可能走上两个位置走到比较一下哪个最短，就是当前最短路径，除了自顶向下，也可以自底向上，这样直接返回f[0][0]即可
2.涉及到数组的要注意下标的取值范围，不能越界，也不能漏掉
3.还有一种记忆化搜索，就是DFS过程在遇到已经计算过的值时，直接返回，而不再像更深层次递归，这样是只需要n^2的复杂度
4.如果采用单纯的dfs，会超时，DFS如果采用travers的方法，需要向下层递归传递变量，如果分治法，就是先分解到最小子问题，然后一层层向上返回