```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-input-array-is-sorted
@Language: Markdown
@Datetime: 17-03-28 23:43
```

1.第一次采用了map加上循环，效率较差
2.其实可以采用双指针法, 左右指针分别保存了当前区间的最小值和最大值，那么一旦左右指针的和大于目标值，只有可能移动右指针，小于的话，只有可能移动左指针，思考通透这一点，因为此时左右指针分别代表当前区间的最小和最大值，如果最小值加最大值都小于target，那么说明最小值过小，移动最小值的指针，反之，如果最小加最大值大于target，那么说明最大值取得过大，不存在其他情况，这是这个解法的关键，**其实这是构造了一对数，其中每个数是当前区间的最大值最小值，然后检查这两个数的值是不是可能在最终结果中，如果说加上当前最大/最小值仍然小于/大于目标值，那么这个数肯定不在最终结果中**