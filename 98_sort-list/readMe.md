```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Markdown
@Datetime: 17-03-27 16:48
```

1.这道题要求复杂度为O(nlogn)，首先想到使用归并排序和快速排序，这两种排序方式都是采用了divide and conquer的理念，总共问题会被切割log n次
2. Merge sort要求先找到中点，然后先处理中点右边的链表，处理完毕后，将中点的next设置为null，再行处理左边的，这是由链表的特性决定的，这里注意要处理corner case，比如链表中只有两个点，那么如果找点的中点不对的话，始终是在嵌套调用原函数处理原来的输入，要保证处理的右边链表一定不为null，也就是找到的中点不是最后一个点即可