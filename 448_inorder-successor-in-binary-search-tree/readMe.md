```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Markdown
@Datetime: 17-02-07 02:45
```

1.注意题意，这里是要求将二叉搜索树的节点按照中序遍历排列后，找到任意节点的后面一个节点，注意此处排序的顺序始终是根左右根左右
2.那么此时对于根节点，先判断当前是否为null或者等于指定节点，如果不是，继续判断根节点的值和指定节点的值得大小，如果小于，那么说明指定节点在右子树中，如果大于，则在左子树中寻找，这里要将success设置为当前根节点，因为当前节点左边有可能就是p，这样搜索一定能找到p点，此时跳出循环，然后先判断corner case， 判断原始节点是否为空，如果不是，判断当前节点右节点是不是为空，如果是，返回successor，如果不是，那么久就返回右节点的最左节点，注意中序搜索的顺序即可