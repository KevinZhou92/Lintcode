```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix
@Language: Markdown
@Datetime: 17-05-24 04:41
```

1.如果用堆解决这道题目，采用构造对象的方式，利用矩阵在行和列上递增的特点，每次处理当前最小点最接近的两个点，避免重复处理，避免处理不必要的点
2.掌握二分的做法,利用矩阵从左向右，从上至下是递减的特点，从矩阵的左下角（或者也可以从右上角开始搜索), 如果当前数比二分搜索的mid小，那么这一列之前所有数都小于mid，那么直接右移一列，继续比较，最终找出整个矩阵比mid小的个数，得出mid的位置，还要判断二分搜索的mid值是否存在于矩阵中