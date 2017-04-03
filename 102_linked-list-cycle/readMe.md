```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/linked-list-cycle
@Language: Markdown
@Datetime: 17-03-24 13:33
```

1.注意这里的环并不一定是从链表的头开始的，所以不能只用单指针追踪，这里采用一快一慢两个指针追踪判断，快指针每次向前移动一步，快指针移动两步，如果链表中存在环，那么快指针一定会和慢指针重合，核心在于这里快指针每次循环都以1的距离接近慢指针，所以无论两者开始的位置是什么样子的，只要进入环了之后，两者之间的任何距离都会被覆盖到的，**每次前进1！**
2.注意这里引用值得判断，确保不要出现null pointer的引用，不要越界