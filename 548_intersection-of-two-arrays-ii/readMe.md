```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays-ii
@Language: Markdown
@Datetime: 17-03-22 00:45
```

1.这个follow up和第一个不同的地方在于需要把相同的元素都放进最后的结果集合中，不管重不重复，每个元素的数量就是他在两个集合中出现次数的较小值
2.那么这里考虑采用一个map结构将每个元素和期出现的次数对应起来，先循环其中一个数组，统计每个元素的出现此处，然后循环第二个数组，每发现一个同样的，就加入结果几个中，同时将map中对应的值减去1，这样保证相同元素出现的次数以两个数组中较少出现的次数为准, 还是要细心，要保证元素出现的次数是其在两个数组中出现较少的次数
3.能用循环别用迭代器