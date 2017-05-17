```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/smallest-rectangle-enclosing-black-pixels
@Language: Markdown
@Datetime: 17-03-08 19:29
```

1.注意前提条件，所有的黑色像素都是连接在一起的，所以不存在其中一行或者一列没有像素点
2.那么可以考虑到使用二分搜索，找出上下左右最远的黑色像素的坐标值，然后做一个简单的乘法，此题思考代码复用
