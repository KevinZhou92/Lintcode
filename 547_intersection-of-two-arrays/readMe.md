```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Markdown
@Datetime: 17-03-20 19:56
```

1.可以采用暴力解法，但是尽量避免双重循环，会导致超时，将两个循环分开，第一个循环建立建立一个set来存储一个数组中不重复的entry，然后循环第二个数组，然后比较和第一个集合中有没有相同的元素，有的话就加入到结果集合中，然后把这个结果集合的元素迭代到数组中即可
2.注意程序的细节问题，避免typo