```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Markdown
@Datetime: 17-04-11 20:31
```

1.优先队列，先利用hashmap遍历统计词频，然后新建一个对象，将词和对应的词频封装到对象中，然后将对象插入优先队列，保持大小为k的优先队列，然后遍历完所有的组合，得到最后结果
2.注意各种数据结构的细节，优先队列的初始化，hashmap的使用，string自带的comparable方法
3.如果需要降低时间复杂度，那么只需要每次在加入元素到优先队列之前时，先和优先队列头部的比较，如果小于的话，就不用加入了,因为肯定不是topK