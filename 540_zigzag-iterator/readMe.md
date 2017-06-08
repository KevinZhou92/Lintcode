```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/zigzag-iterator
@Language: Markdown
@Datetime: 17-04-24 01:19
```

1.利用两个迭代器和一个整型变量计数解决，**迭代器的好处是每次只产生一个对象，节省内存**
2.注意取next的这个过程，每当迭代到对应的列表，先判断当前列表是否为应该操作的列表，如果不是，判断对应的另外一个列表是否为空，如果空的话就还是从这个列表迭代，如果情况都不满足就返回0