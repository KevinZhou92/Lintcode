```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Markdown
@Datetime: 17-01-29 03:08
```

1.此种对于有序数组的搜索问题都可以考虑使用二分搜索
2.二分搜索很关键的一点就是搜索的起始点和终止点的设置
3.此题因为是寻找第一个元素，所以在边界条件的上比较宽松，保证start永远和起始位置绑定即可
4.建议将此题和寻找最后一个target对比思考，思考不同情况的corner case应该怎么处理