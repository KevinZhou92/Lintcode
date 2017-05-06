```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-break-ii
@Language: Markdown
@Datetime: 17-03-15 21:06
```

1.这道题是word break 1的翻版，第一版只需要找出有没有可能的分割在分割完毕后所有词都存在与字典中，那么我们只需要使用动态规划，找到可能的组合就立刻返回，只需要一个boolean数组去记录当截取原字符串的一部分子串时，子串分解结果在不在字典中，然后一步步递推得到结果，但是这个follow up需要我们找到所有可能的组合，并输出这些组合
2.这里我们还是使用深度优先的思路去求解，先对字符串做预处理，获得两个信息，截取任意一个子串， 看看这个字串在不在字典中，从字符串的i位置开始，看看子串（i，n）是不是在字典中，这样我们实现了从头部和尾部的两个剪枝
3.最后就是深度搜索，先判断在当前位置到尾部的子串在不在字典中，如果不在，不需要下一步搜索，然后判断是不是已经到达尾部，然后就开始进一步递归，这里加入路径的是当前子串的结束坐标
4.在重建输出结果时，注意StringBuilder的使用：
```
if (startIndex == s.length()) {
	StringBuilder sb = new StringBuilder();
	int lastIndex = 0;
	for (int i = 0; i < path.size(); i++) {
		sb.append(s.substring(lastIndex, path.get(i)));
		if (i != path.size() - 1) sb.append(" ");
		lastIndex = path.get(i);
	}
	results.add(sb.toString());
	return;
}
```