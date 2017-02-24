```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Markdown
@Datetime: 17-01-23 19:21
```

1.经典的二分搜索模板
2.边界情况，防止死循环
3.采用此模板，二分搜索终结时起始点和终点一定是两个相邻的数字，所以要注意corner case
4.此题是寻找first，那么一定是先看start
5.如果是last，就先看end