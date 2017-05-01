```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Markdown
@Datetime: 17-04-03 22:52
```

1.翻转链表的题目，难度不大，关键是要思考清楚整个流程，非递归的方法每次返回要翻转的k个节点链表的前一个节点，然后以此类推，直到处理完整个链表
2.变量的命名要开门见山，应该一眼看出来变量名所要表示的内容是什么
3.多练习，也可以用递归的方法，每次向上层返回当前翻转后链表的头结点，也就是k+1个节点，然后在当前层次不断链接，递归就是入口，拆解，终止条件，这里注意节点数刚好等于k的情况