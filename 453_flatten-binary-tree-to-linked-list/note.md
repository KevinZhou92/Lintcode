```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Markdown
@Datetime: 17-02-07 04:31
```

三种写法：
1.遍历，由上至下,需要有一个全局变量来追踪当前点，注意逻辑关系
2.分治，由下至上，自己调用自己解决问题，现将问题分解为最小的子问题，然后一步步解决上去，在这个过程中，本层函数返回至上层时要追踪本层的状态，向上层返回
3.非递归，手动实现栈的调用，注意第三种方法，模拟了递归的过程，利用了栈的特性，深度搜索利用栈，广度搜索用队列