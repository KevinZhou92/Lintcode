```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/k-closest-points
@Language: Markdown
@Datetime: 17-04-08 23:24
```

1.解法1，可以新建一个数组，然后将原数组中的点的横纵坐标分别减去origin点的横纵坐标，然后利用arrays.sort（），自己新建一个比较器来对数组排序，按照距离从小到达排序
2.解法2，采用优先队列，要熟悉这种数据结构的使用，熟悉comparator的写法,数组的索引边界要细心一点