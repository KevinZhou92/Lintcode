```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Markdown
@Datetime: 17-01-25 20:19
```

1.暴力解法循环遍历每个元素可解
2.这个题目比较tricky的部分是对题目的理解，将数组想象成函数，那么这个题目就是去找函数的局部最大值
3.分割出来的数组首尾单调性一定是不一样的，这样才能保证函数在这个区间内一定是有增有减
	