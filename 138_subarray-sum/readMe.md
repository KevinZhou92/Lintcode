```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Markdown
@Datetime: 17-03-17 13:12
```

1.数组的索引，下标的取值范围
2.采用了一个附属数组，计算数组中元素的累加和，然后比较任意两个entry的值是不是相等，如果相等就表示这个区间之内的数组元素的累加和为零
3.注意此处要仔细判断元素下标和实际位置的关系