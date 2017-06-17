```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Markdown
@Datetime: 17-04-30 20:33
```

1.这道题是每一层遍历，然后每一层要变换扫描顺序，从左到右和从右到左，所以这里我们采用栈的思路来处理
2.用两个stack来存储curLevel和nextLevel的节点可以实现这样的左右顺序反转。因为stack是先进后出的，节点push进stack的顺序和pop出stack的顺序正好是相反的：
假设stack curLevel pop出的第一个节点是该层的最左节点x，压入x->left和x->right进stack nextLevel。这样依次类推，等整个curLevel的节点都pop出来后，x->left和x->right在nextLevel的最底部。当之后开始pop nextLevel时，最后才pop到x->left和x->right。换句话说，curLevel第一个被访问到的节点的子节点，将在nextLevel中最后被访问到。
3. 这里还需注意的是push left/right child进nextLevel的顺序。因为栈只能解决当前层次的翻转问题，无法判断翻转的方向，不知道先压入左子节点还是右子节点，当curLevel从左向右访问时，应当先push(x->left)再push(x->right)，反之则应该先push(x->right)再push(x->left)。实现时可以用一个bool变量来表示顺序，每访问完一层后反转bool变量t的值，那么实现子节点从左向右压入和从右往左压入。