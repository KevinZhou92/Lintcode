```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Markdown
@Datetime: 17-02-02 17:26
```

1.后序，左右根
2.关于递归，如果是分治法，那么就是从下至上，基本上都要把下层结果返回给上层，如果是遍历，那么就是从上至下，每层的状态都会有追踪，并不需要返回值
3.分治法思考每一层都需要做什么，因为所有的子问题都是一个规模，所以思考每一层即可，注意返回条件的设立
4.这道题目反复练习