```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Markdown
@Datetime: 17-02-16 22:33
```

1.序列化就是把内存中的数据写入到存储装置中，一般都是用字符串的形势表示，比如json，去序列化就是一个反向的过程，对这个定义要清楚
2.注意如何还原字符串，也就是deserialize的方法，牢记api的使用
3.序列化的过程中要注意细节，尤其是首尾部分的情况