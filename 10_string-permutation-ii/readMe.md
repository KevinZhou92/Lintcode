```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Markdown
@Datetime: 17-05-03 01:21
```

1.这道题和Permutations类似，都是深度优先搜索，依次枚举结果
2.注意字符串中存在重复字符，要建立布林数组判断当前那些字符使用过了，哪些字符不能用
3.使用深度优先需要O(n)的额外的空间来储存每个可能的字符组合，这里可以采用和next permutation一样的思路， 吧字符串转化为字符型数组，然后利用排列组合的思路求解