```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Markdown
@Datetime: 17-03-20 19:44
```

1.链表的操作， 没什么难度，注意对于引用对象的理解，对同一个对象可以创建多个引用，通过对任意一个引用的操作可以改变对象的属性，这个属性仍然可以被任意一个引用调用，引用如果被赋予了其他值，那么就不再对原对象有效果了
2.注意细节，最后一个点的next要设置null