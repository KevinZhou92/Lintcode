```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Markdown
@Datetime: 17-04-09 01:20
```

1.基本数据结构的使用，list的用法，参数要写正确，careful
2.可以使用堆，O（nklogK), 保持一个大小为k的堆，记录了每个列表中最小的，然后堆的最顶层元素就是least one，每次弹出之后，加入当前列表的下一个
3.可以使用分治法
4.可以使用merge sort, 一定要注意merge sort是指针的界限，否则会造成爆栈