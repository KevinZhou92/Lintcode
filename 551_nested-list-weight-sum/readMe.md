```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/nested-list-weight-sum
@Language: Markdown
@Datetime: 17-04-09 23:35
```

1.Recursion的方法，递归三要素，定义/出口/拆解，要熟悉java的参数传递是值传递
2.非递归的方法要多练习，因为递归很有可能爆栈,这里是一个采用了广度优先的非递归方法，因为每个整型值要和对应的深度相乘，所以采用广度优先，注意对应的数据类型使用什么数据结构