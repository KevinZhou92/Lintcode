```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Markdown
@Datetime: 17-05-01 14:45
```

1.很好的理解动态规划的一道题目，注意如何寻找状态转移方程，考虑到空间复杂度，可以不使用数组，使用两个变量，这里是一维的
2.这里考虑走n步有多少方法，这种情况一般都是dp，走到n步可能是走n-2步的方法再走2步，或者n-1步的方法再走一步， 那么就是把这两个值加起来就可得到最终解
3.corner case