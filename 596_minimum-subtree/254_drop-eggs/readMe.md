```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Markdown
@Datetime: 17-01-24 00:25
```

1.此题题意是总共只有两个蛋，破完了就没有了，然后通过这两个蛋找出最合适的位置
2.此题无法使用二分法求解，很tricky的一个方法
3.智力题，假设最少需要扔k次，那么每次第一蛋不碎的话，扔第二个蛋的楼层高度都只能比第一次少一，因为假设第二次碎了，那么为了保证次数恒定，此时还剩下k-2次，所以第二次只能比第一次高k-1层的地方扔
4.假设总共要扔k次，那么初始楼层高度就为k，如果第一次碎了，再扔k-1次即可，如果第二次才碎，接下来就剩k - 2 次，每一层不随，接下来都只能比前面层数少一，因为可扔的次数只剩1了，最后只剩一次的时候，要求出解，也就是所有的可能性都覆盖了
5. 最坏情况是什么，前一次没碎，本次碎了，那么需要把之前所在楼层和当前楼层中的每一层都扔一次