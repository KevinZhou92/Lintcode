```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/unique-paths
@Language: Markdown
@Datetime: 17-04-26 03:35
```

计算解个数的题多半是用DP。而这题状态也非常显然，dp[i][j]表示从起点到位置(i, j)的路径总数。DP题目定义好状态后，接下去有两个任务：找通项公式，以及确定计算的方向。
1. 由于只能向右和左走，所以对于(i, j)来说，只能从左边或上边的格子走下来：
dp[i][j] = dp[i-1][j] + dp[i][j-1]
2. **对于网格最上边和最左边，则只能从起点出发直线走到**，dp[0][j] = dp[i][0] = 1
3. 计算方向从上到下，从左到右即可。可以用滚动数组实现。