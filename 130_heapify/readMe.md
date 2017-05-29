```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Markdown
@Datetime: 17-04-25 02:50
```

很有代表性的堆的题目，基本的数据结构，要熟练掌握
1.如果采用自底向上的方法，复杂度为O（n）， 每次比较当前父节点和两个子节点的大小，如果父节点已经最小，不做任何操作，如若不然，依次向下下沉，不仅仅是当前层次，一直要比较到堆底部，保证堆的特性
2.如果采用类似于插入堆的方法，那么复杂度为O（nlogn）,**注意top-down和bottom-up方法的实现思路是不一样的，bottom-up是将父节点和两个子节点比较，top-down是模仿每次插入一个节点的情况，将每个插入的节点和父节点比较**