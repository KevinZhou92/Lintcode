```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Markdown
@Datetime: 17-04-12 01:38
```

1.这就是多链表Merge Sort的一个扩展题。对于任意一个ugly number - K, 2*K, 3*K, 和5K都是ugly number，所以说新的ugly number都是从已有的ugly number上，通过与{2,3,5}相乘而产生的,那么我们只要用较小的基数乘以2 3 5，然后每次加入最小的一个数（但是这个数要大于已知的最大的ugly number即可），可以采用一个list然后扫描n次，此时的复杂度为O（n）