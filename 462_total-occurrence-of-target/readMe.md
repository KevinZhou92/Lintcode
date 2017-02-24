```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Markdown
@Datetime: 17-01-23 21:56
```

1.Find first position of target问题的变种，先找到第一个出现的位置，然后循环统计总共出现了多少次
2.也可采用先找第一个，再找最后一个位置的解法,这种解法注意边界情况的判断，当找这个元素的第一个位置就没找到时，就可以直接return 0了