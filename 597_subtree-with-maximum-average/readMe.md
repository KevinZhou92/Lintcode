```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subtree-with-maximum-average
@Language: Markdown
@Datetime: 17-01-31 00:54
```

1.BST,对于inner class 的写法要强化
2.本题是遍历和分而治之的思路（divide and conquer），采用了递归
3.递归三要素：定义、拆解、终止条件，函数不断调用自身去解决问题，在BT的图上很好的表现
4.此题分清楚概念，每个层级函数调用了后返回给上层函数什么样的数据类型,同时注意需要返回给上层什么样的数据