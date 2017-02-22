```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Markdown
@Datetime: 17-01-24 03:53
```

1.此题属于简单题，没有什么难度，但是循环的使用要会
2.要熟悉怎么去设置终止条件，本题当中利用参数的自减法由大到小添加，避免了重新创立数组,注意到这里是在原数组上操作，所以要从尾部添加，否则会覆盖原有数据，造成程序出错
3.仔细体会程序是如何控制跟踪数组下标的，基本功需要加强