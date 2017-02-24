```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Markdown
@Datetime: 17-01-22 20:20
```

1.此题的思维要能够切合到二分搜索，注意观察给的数据的规律
2.注意边界条件的判定，除了典型的判断数组是否为空或引用是否为null的情况，还需要注意一些特殊情况，比如此题中 如果数组还是已排序的情况，那么返回的就应该是第一个值，因为这个情况只有end指针在移动，并且无论start还是end均小于target值