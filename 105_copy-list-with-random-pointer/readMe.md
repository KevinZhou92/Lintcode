```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Markdown
@Datetime: 17-03-22 02:34
```

1.不是很难，注意细节即可，此题思路采用map来映射一个deep copy，先复制节点，再复制节点的关系
2.具体过程为，先deep copy每个点，然后循环原链表，找出map中对应的copy，按照原链表中节点的关系复制新的关系，这个过程中要保持dummy node来记录初始点的关系， 最后不要忘了把链表尾部设为null
3.还有一种巧妙地方法，先复制成1-1‘-2-2’这样的形式，然后再调整random的关系，然后在分开链表
4.java的值传递，引用传递概念不要混淆