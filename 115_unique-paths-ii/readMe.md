```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Markdown
@Datetime: 17-04-28 05:00
```

1.动态规划，做此类题目的时候注意力放在转移方程上，不要太关注每一个细节，那样很容易走入死胡同，这里和第一题类似，找出每一个格子的路径数量和之前的关系，根据走的方向，只有两种可能走到当前格子，那么就是从上面或者从右边走过来，如果此时路上有路障，那么对于第一行和第一列，在障碍之后的格子就不可能走到，全部为0，如果障碍在中间，那么当前格子的路径数量为0，然后求解