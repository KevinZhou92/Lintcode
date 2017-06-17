```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/high-five
@Language: Markdown
@Datetime: 17-04-08 20:58
```

1.这道题难度不大，熟悉整个过程，然后一些api的使用即可，注意接口和具体实现的区别，还有逻辑关系
2.就是使用hashmap实现整个操作，每次比较对应列表中的值，找出最小值，如果小于当前值，就进行替换，注意index=0， 那么就从第一个开始比较，而不需要再去查看index = 0的值，因为那就是自身
> _Map.Entry<K, V>的用法_
> **public static interface Map.Entry<K,V>**
A map entry (key-value pair). The Map.entrySet method returns a collection-view of the map, whose elements are of this class. The only way to obtain a reference to a map entry is from the iterator of this collection-view. These Map.Entry objects are valid only for the duration of the iteration; more formally, the behavior of a map entry is undefined if the backing map has been modified after the entry was returned by the iterator, except through the setValue operation on the map entry.
```
Map.Entry<K, V>  res = map.entrySet();
```