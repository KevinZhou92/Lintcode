```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Markdown
@Datetime: 17-02-25 17:22
```

1.此题采用宽优先搜索，注意要求的结果是起始词到终点词的词的总数（inclusive），在变量初始化的时候要注意‘
2.每次迭代过程获得新词只要循环当前词的每一个字符，然后将这个字符换成任意的26个字符, 然后如果当前字典中包含这个单词，就将这个词加入下层深度搜索的等待列表中
3.注意一些collections的区别，以及字符串方法的使用
4.如果输入的dict是list，那么要先把它转化为set，因为list的contains放方法复杂度过高，程序会超时