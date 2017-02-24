```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Markdown
@Datetime: 17-02-03 18:06
```

1.二叉搜索树的定义，左子树中的值小于等于节点，右子树的值大于等于节点，并且子树的子树也是这个规则
2.还是分治法，要熟悉自己为返回结果设计自定类型
3.如果使用遍历法，基本上都是需要全局变量记录当前状况的，注意BST的特点就是从左至右节点的值是单调上升状态，所以我们先遍历当前节点的左子树，记录当前节点值，然后遍历右子树，任何子问题的判定就是，当前节点是否是根节点，然后只要比较当前值是不是比之前值小就可以了，在左子树中，如果当前值比之前的小，说明不成立，右子树同理，这是由BST的性质得出的
4.注意corner case