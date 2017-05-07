```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Markdown
@Datetime: 17-01-17 03:52
```

1. 字符串是对象，对象之间比较使用**equals()**
2. 字符串对象的长度采用**length()**
3. 边界情况的考虑,字符串索引的计算，因为源字符串和目标字符串第一个字符对齐，所以i+j 和0+j，这个需要反应过来
4. 代码风格