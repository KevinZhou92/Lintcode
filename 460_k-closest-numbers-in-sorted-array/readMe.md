```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Markdown
@Datetime: 17-01-28 03:19
```

1.组合题，二分搜索先找到first position of target，或者说最接近first target的那个点，注意corner case的判定
2.这里可以采用两个指针来追踪有序数组中小于target和大于target的点，这点非常重要，要灵活点做题
3.二分法的边境情况要反复练习