```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/strstr-ii
@Language: Markdown
@Datetime: 17-01-18 19:16
```

此题关键在于Hash 函数的写法
经过试验，即使不对计算出来的值进行取模操作，也可以得到正确的结果，取膜的作用是为了方便计算，保证基准一致，否则会得出错误的结果。

此外，取模后，在得出的值小于0时，加上模的值，就可以得到对应在膜中是哪一个数字了。