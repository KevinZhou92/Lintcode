```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/zigzag-iterator-ii
@Language: Markdown
@Datetime: 17-04-24 02:19
```

1.这道题是只有两个list的follow up，用一个arraylist记录所有的列表迭代器，然后每次取next的时时候，从当前的iterator取完了要判断当前iterator是否为空，如果为空就从arraylist中remove这个迭代器，然后变更下标即可