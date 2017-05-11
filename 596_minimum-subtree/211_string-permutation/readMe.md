```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/string-permutation
@Language: Markdown
@Datetime: 17-03-02 01:05
```

1.可以用字符索引数组来解决，先遍历A字符串，按照每个出现的字母建立数组，然后出现一次这个索引的值就加1
2.再遍历B字符串，如果出现相应字符就把以这个字符为索引的数组元素值减去1