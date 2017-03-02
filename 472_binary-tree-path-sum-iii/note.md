```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum-iii
@Language: Markdown
@Datetime: 17-02-09 19:30
```

1.首先，我们观察样例，发现相同的路径点，走的顺序不一样，就视为不同的路径；同一个点，只能走一次，不能重复走。
2.既然这样，那我们就有一个最简单的思路，枚举树上的点，以该点为起点搜索可行的路径。
3.dfs(root, target, results)：遍历整棵二叉树，当前遍历到的点是root。
目标值为target，所有可行路径存储在results中。
4.findSum(root, father, target, path, results);
搜索以root为起点，目标值为target的可行路径，并将搜索路径存储在path中。当target为0时，即代表该搜索路径为一条可行路径，将其存入答案results中。
当root为路径起点时，father为空，此时可以向三个方向进行搜索（父亲节点、左儿子节点、右儿子节点）。
当root不是路径起点时，此时的father为搜索路径中，root的上一个点，只能向三个方向中，非father的两个方向进行搜索。
5.最后要注意的就是数据的问题了，题上并没有说数据都是正整数，所以是有可能存在负值和0的。