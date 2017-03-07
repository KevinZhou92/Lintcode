```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence
@Language: Markdown
@Datetime: 17-02-05 16:47
```

1.Divide and conquer的思路
2.注意corner case
3.注意递归的写法，此处采用了全局变量来追踪最长的序列
4.仔细体会递归就是用自己解决自己，分治思路即把一个大问题分成几个相同类型的小问题来解决
5.分治法注意细节，此处需要两个变量来分别追踪之前的最大长度和当前最大长度
------------------------------------------------------------------
__也可以采用traverse的写法，不同的是遍历是从上往下，而分治法则是先化解为最小问题，然后一步一步解决之前的大问题, 在这个角度上，遍历更像是深度优先搜索,从上至下遍历__