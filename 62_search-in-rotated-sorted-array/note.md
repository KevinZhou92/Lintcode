```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Markdown
@Datetime: 17-01-24 02:42
```

1.此题是排序后翻转的数组，其实相当于两个排序的数组拼接在一起，那么拆分思考，其实相当于先确定target的范围，然后在指定的范围之内进行二分查找
2.如何判定初始数组的情况，先比较中点和起始值的情况，然后在判断target在起始值和中点之间还是之外
3.这道题首先目标是先找到target位于哪一个有序数组中，左边还是右边，然后转化为一个典型的二分查找