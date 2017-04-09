```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Markdown
@Datetime: 17-03-15 21:21
```

1.注意java是值传递，如果是主数据类型，那么就是把变量的值拷贝一份传入到调用的方法中，之后原变量的值不受影响，如果是传递的引用类型，如果之后不在调用过程中，将调用过程中的引用改变，那么原值跟着改变，如果调用过程中，引用改变了，那么不会影响到原来的值，因为这里已经创建了一个新的对象
2.这里采用常规的dfs可能会爆栈，采用动态规划的思路求解，要求一个字符串能不能分解为字典中的单词，我们从0号位置出发，就是不切割，那么字典中肯定有空字符串，然后我们开始双重循环，在一个长度为i的字符串中，是否存在一种切割，使得这个字符串切割完的后的子字符串都在dict，注意这里我们用了一个布尔数组来记录在位置i的子字符串能够被分割程字典中的字符串，这里只要求找到，不要求所有可能，所以我们只需要记录可能性就可以，然后依次迭代，注意两个循环值的设定， 内层始终小于等于外层的长度，外层的最大值应该是原始字符串的长度，这样保证了能记录指定长度字符串是否能够成功分割
3.然后进一步优化，如果每次我们外层循环的字符串长度加1的时候，我们在内层循环从头开始，我们会进行很多重复计算，因为从开头开始的长度稍短的子字符串我们已经计算出了，那么我们就从尾部向前倒着计算，从新的子串的尾部开始切割，这样就省掉了很多重复步骤，这样只要计算这个新的子串，以及之前的子串是不是能够分割，即可获得我们想要的解
4.最后一次优化，我们事先统计一下字典中所有词的最大长度，那么在循环时，一旦切割的子串长度大于这个最大长度了，我们就跳出循环，这样进一步节省了时间
5.此处最后一个单词的长度的判断关系要写对，字符串的索引不要混乱