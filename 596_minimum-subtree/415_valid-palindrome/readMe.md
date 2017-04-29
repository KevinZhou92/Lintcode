```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Markdown
@Datetime: 17-03-30 01:51
```

1.这一题虽然是一个简单题，但是corner case很多，需要细心处理，反复练习
2.特别注意空字符串的情况，对于指针边界的情况也要细心，这里有两种处理方式：

*   ` if (front == s.length()) { // for emtpy string “.,,,”     return true;}           `
*   在内部的条件判断语句中加上continue， 那么每次判断左右指针的工作就交给while loop，这样就可以保证不越界