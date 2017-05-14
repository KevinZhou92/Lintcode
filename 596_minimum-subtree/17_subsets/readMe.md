```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Markdown
@Datetime: 17-02-25 15:20
```

1.深度搜索
2.递归的理解, 每次添加一个元素，然后下层循环从当前位置的下一位添加
3.注意此处在低层次递归结束后，将上一层添加的元素出去，在原始数组中寻找下一个元素加入进去继续递归