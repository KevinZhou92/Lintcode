```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Markdown
@Datetime: 17-04-04 00:47
```

1.因为要满足三个数从小到大排列的顺利，并且a+b+c=0，所以我们转化为b+c = -a的形式，因为a是最小的，所以我们一次扫描原数组，扫描出来的数就当做a，然后在剩下的数组中做一个two sum问题
2.这道题还有一个很关键的点就是去重，因为输入中有重复数字，但是结果需要unique，所以我们需要去除重复的组合
3.最后还是注意数组的指针问题