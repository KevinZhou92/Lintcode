```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Markdown
@Datetime: 17-03-29 04:56
```

1.利用hashmap来求解，因为是要求得两个数之和等于一个定值，那么我们循环遍历数组，用target的值减去数组中元素的值，就得到当前数所需要的配对的数值，然后将这个需要的值和当前所遍历到的元素储存到map中，如果接下来循环的时候找到这个值了，那么就输出坐标组合，要记住碰到难题多考虑hashmap