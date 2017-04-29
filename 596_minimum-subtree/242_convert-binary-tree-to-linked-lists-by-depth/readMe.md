```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/convert-binary-tree-to-linked-lists-by-depth
@Language: Markdown
@Datetime: 17-03-08 05:13
```

1.宽度优先搜索，注意遍历的问题应该如何处理
2.要熟悉模板，同时也要学会根据题目做基本的变化
3.也可以用深度优先搜索，用当前层次的深度作为该层次点的index，从右向左依次找出所有的点，向下遍历的时候，先把最右边的所有点加入集合，然后递归到每一层就把当前层点加到结果中去
4.递归三要素
```
递归的定义
递归的出口
递归的拆解
```