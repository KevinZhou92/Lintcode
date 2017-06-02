```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/lru-cache
@Language: Markdown
@Datetime: 17-04-15 14:23
```

1.这个least recently used算法是内存换页的经典算法，最少使用的页面会被最先替换掉
2.本题核心是使用了双向链表，然后设置一头一尾两个锚点，方便处理数据
3.熟悉双向链表的使用，熟悉采用复合的数据结构解决问题 
4.在set函数中，查询当一个页面是否在内存中，假如这个页面存在的话，那么改变这个页面值的同时，这个页面也成为了最近使用过的，需要改变所处的位置，并且改变前后节点的连接关系，这也是我们为什么直接使用get函数，而不是用map.containsKey()的原因
```java
public void set(int key, int value) {
	if (get(key)!=-1) {
		map.get(key).val = value;
		return;
}
```