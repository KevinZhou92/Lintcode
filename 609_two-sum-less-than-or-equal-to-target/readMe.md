```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target
@Language: Markdown
@Datetime: 17-03-28 22:00
```

1.第一步先想到暴力解法，双重循环，但是这样会超时,复杂度为 n^2
2.优化暴力解法，可以先将数组排序，然后一头一尾采用两个指针来追踪，选定左端数为基准，然后从尾部选择数，看能否组合成小于target的值, 如果能，那么能组成右指针-左指针个组合，然后递增，如果不能就j递减，因为此时数组是有序的，要改变两数之和，想变得更小就左边指针或者右边指针向左移，变得更小就相反的操作，这是一个O(n)的解法