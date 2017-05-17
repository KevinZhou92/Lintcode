```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/insert-into-a-cyclic-sorted-list
@Language: Markdown
@Datetime: 17-03-16 20:34
```

1.对基本的链表循环要熟悉，简单题多练习
2.两种可能，一种就是插入的数的值在链表最大最小值之间,那么直接插入顺序链表即可，另外一种就是插入值在链表由最大转到最小的转折处，那么此时判断一下插入值比最小值小或者比最大值大即可