```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Markdown
@Datetime: 17-03-07 04:23
```

1.和subset题目类似，这个题目要求，每个数字只能用一次，同时给定的数据集合中存在重复的值,这个情况下我们要考虑同样的数字在同一个递归层次如果已经出现过了，我们就要跳过这种情况
2.那么单独设立一个布林数组来记录数组中元素的访问情况，如果当前元素和之前一个元素想等，那么在同一层次再次进入这个元素时，直接跳过，不予考虑，因为在前一个元素的时候已经计算出相同的结果了，不需要再做一遍