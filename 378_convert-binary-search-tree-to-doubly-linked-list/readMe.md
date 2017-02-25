```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Markdown
@Datetime: 17-02-08 05:18
```

1.可以用递归的方法做，也可以用栈来做，注意用栈的时候，第50行可能导致node为null，所以在40行的while条件要判断node是不是为空, 注意变量的声明前后要一致，程序的细节要注意
2.递归的方法还是分治法，注意终止条件，返回类型，然后如何判断corner case，先判断左边是不是null，如果不是再判断右边