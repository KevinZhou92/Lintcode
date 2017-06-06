```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Markdown
@Datetime: 17-04-25 14:14
```

1.这个问题其实很简单，由于要求在O（n）的时间里解决，第一时间反应到使用hashset和hashmap
2.扫描遍历数组，将所有出现的值存储到set中，然后再一次遍历数组，对于数组中的每个值，查看比这个值大一和小一的值在不在set中（也就是与当前数紧邻的两个数在不在数组中），如果在就继续好找，一直找到情况不满足，注意此时设置的up和down的值均不在数组中（均比数组中的值大一），所以求取length时，要减去2，也就是两个锚点多出来的值，因为连续可以直接减去，求出总共有几个数