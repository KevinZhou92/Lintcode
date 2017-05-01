```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/remove-duplicate-numbers-in-array
@Language: Markdown
@Datetime: 17-03-28 17:50
```

1.可以先用一个mao或者集合记录数组中不重复的元素，然后再依次复制到原数组中，统计不重复元素的个数
2.或者可以先排序，然后在原数组中循环，注意这里保持追踪的指针和数组指针始终相差一，只有不相等的的时候，追踪指针才前进，否则继续循环